# Sequence Diagrams

## 1. Play Media Flow

This sequence diagram shows the complete flow when playing media through the system:

```mermaid
sequenceDiagram
    participant Main
    participant PlayerFacade
    participant Player
    participant Playlist
    participant MediaFileItem
    participant MediaSource
    participant Renderer
    participant Decorator1 as WatermarkDecorator
    participant Decorator2 as SubtitleDecorator
    participant Decorator3 as EqualizerDecorator

    Main->>PlayerFacade: new PlayerFacade(renderer)
    PlayerFacade->>Player: new Player(renderer)
    
    Main->>PlayerFacade: loadPlaylist(playlist)
    PlayerFacade->>PlayerFacade: this.playlist = playlist
    
    Main->>PlayerFacade: playAll()
    PlayerFacade->>Playlist: getItems()
    Playlist-->>PlayerFacade: List<PlaylistItem>
    
    loop For each PlaylistItem
        PlayerFacade->>Player: play(item)
        Player->>MediaFileItem: getData()
        MediaFileItem->>MediaSource: fetch()
        MediaSource-->>MediaFileItem: String data
        MediaFileItem-->>Player: String data
        
        Player->>Renderer: render(data)
        Note over Renderer,Decorator3: Decorator Chain Execution
        Renderer->>Decorator1: render(data)
        Decorator1->>Decorator2: super.render(data)
        Decorator2->>Decorator3: super.render(data)
        Decorator3->>Renderer: wrappedRenderer.render(data)
        Renderer-->>Decorator3: (rendered)
        Decorator3->>Decorator3: Apply equalizer effects
        Decorator3-->>Decorator2: (with equalizer)
        Decorator2->>Decorator2: Apply subtitle overlay
        Decorator2-->>Decorator1: (with subtitles)
        Decorator1->>Decorator1: Apply watermark
        Decorator1-->>Player: (final rendered output)
    end
```

## 2. Apply Decorator Stack Flow

This sequence diagram shows how decorators are applied and how they work together:

```mermaid
sequenceDiagram
    participant Main
    participant SoftwareRenderer
    participant WatermarkDecorator
    participant SubtitleDecorator
    participant EqualizerDecorator
    participant Player

    Note over Main: Creating Decorator Stack
    Main->>SoftwareRenderer: new SoftwareRenderer()
    Main->>WatermarkDecorator: new WatermarkDecorator(renderer, "© ModularMedia")
    WatermarkDecorator->>SoftwareRenderer: super(renderer)
    
    Main->>SubtitleDecorator: new SubtitleDecorator(watermarkDecorator, "Now Playing...")
    SubtitleDecorator->>WatermarkDecorator: super(watermarkDecorator)
    
    Main->>EqualizerDecorator: new EqualizerDecorator(subtitleDecorator, "Bass Boost")
    EqualizerDecorator->>SubtitleDecorator: super(subtitleDecorator)
    
    Note over Main: Decorator Stack Created
    Note over Main: EqualizerDecorator -> SubtitleDecorator -> WatermarkDecorator -> SoftwareRenderer

    Main->>Player: new Player(finalRenderer)
    
    Note over Main: Playing Media with Decorator Stack
    Player->>EqualizerDecorator: render("Media Data")
    EqualizerDecorator->>SubtitleDecorator: super.render("Media Data")
    SubtitleDecorator->>WatermarkDecorator: super.render("Media Data")
    WatermarkDecorator->>SoftwareRenderer: wrappedRenderer.render("Media Data")
    SoftwareRenderer-->>WatermarkDecorator: (base rendering complete)
    WatermarkDecorator->>WatermarkDecorator: Apply watermark: "© ModularMedia"
    WatermarkDecorator-->>SubtitleDecorator: (with watermark)
    SubtitleDecorator->>SubtitleDecorator: Apply subtitle: "Now Playing..."
    SubtitleDecorator-->>EqualizerDecorator: (with subtitles)
    EqualizerDecorator->>EqualizerDecorator: Apply equalizer: "Bass Boost"
    EqualizerDecorator-->>Player: (final output with all effects)
```

## 3. Media Source Strategy Selection

This sequence diagram shows how different media sources are used:

```mermaid
sequenceDiagram
    participant Main
    participant MediaFileItem
    participant LocalFileSource
    participant RemoteApiSource
    participant StreamProxy
    participant HLSStreamSource

    Note over Main: Creating Different Media Sources
    Main->>LocalFileSource: new LocalFileSource("song.mp3")
    Main->>RemoteApiSource: new RemoteApiSource("https://example.com/stream")
    Main->>HLSStreamSource: new HLSStreamSource("https://live.example.com/stream.m3u8")
    
    Note over Main: Wrapping with Proxy for Caching
    Main->>StreamProxy: new StreamProxy(remoteApiSource)
    
    Note over Main: Creating Media File Items
    Main->>MediaFileItem: new MediaFileItem(localSource)
    Main->>MediaFileItem: new MediaFileItem(streamProxy)
    
    Note over Main: Playing Media - Strategy Pattern in Action
    MediaFileItem->>LocalFileSource: fetch()
    LocalFileSource-->>MediaFileItem: "File:song.mp3"
    
    MediaFileItem->>StreamProxy: fetch()
    StreamProxy->>RemoteApiSource: fetch()
    RemoteApiSource-->>StreamProxy: "API Stream:https://example.com/stream"
    StreamProxy-->>MediaFileItem: "API Stream:https://example.com/stream"
    
    MediaFileItem->>HLSStreamSource: fetch()
    HLSStreamSource-->>MediaFileItem: "HLS Stream: https://live.example.com/stream.m3u8"
```

## 4. Playlist Composite Structure

This sequence diagram shows how the composite pattern works with playlists:

```mermaid
sequenceDiagram
    participant Main
    participant Playlist
    participant MediaFileItem1
    participant MediaFileItem2
    participant MediaFileItem3

    Note over Main: Creating Playlist Structure
    Main->>Playlist: new Playlist("My Playlist")
    Main->>MediaFileItem1: new MediaFileItem(localSource)
    Main->>MediaFileItem2: new MediaFileItem(remoteSource)
    Main->>MediaFileItem3: new MediaFileItem(hlsSource)
    
    Main->>Playlist: addItem(mediaFileItem1)
    Main->>Playlist: addItem(mediaFileItem2)
    Main->>Playlist: addItem(mediaFileItem3)
    
    Note over Main: Playing All Items in Playlist
    Main->>Playlist: getItems()
    Playlist-->>Main: List<PlaylistItem> [item1, item2, item3]
    
    loop For each PlaylistItem
        Main->>MediaFileItem1: getData()
        MediaFileItem1-->>Main: "File:song.mp3"
        
        Main->>MediaFileItem2: getData()
        MediaFileItem2-->>Main: "API Stream:https://example.com/stream"
        
        Main->>MediaFileItem3: getData()
        MediaFileItem3-->>Main: "HLS Stream: https://live.example.com/stream.m3u8"
    end
```

## 5. Runtime Renderer Switching

This sequence diagram shows how the system can switch renderers at runtime:

```mermaid
sequenceDiagram
    participant Main
    participant PlayerFacade
    participant Player
    participant SoftwareRenderer
    participant HardwareRenderer
    participant DecoratorStack

    Note over Main: Initial Setup with Software Renderer
    Main->>SoftwareRenderer: new SoftwareRenderer()
    Main->>DecoratorStack: new DecoratorStack(softwareRenderer)
    Main->>PlayerFacade: new PlayerFacade(decoratorStack)
    PlayerFacade->>Player: new Player(decoratorStack)
    
    Note over Main: First Playback with Software Renderer
    Main->>PlayerFacade: playAll()
    PlayerFacade->>Player: play(item)
    Player->>DecoratorStack: render(data)
    DecoratorStack->>SoftwareRenderer: render(data)
    SoftwareRenderer-->>DecoratorStack: "[SoftwareRenderer] Rendering: data"
    DecoratorStack-->>Player: (with all decorator effects)
    
    Note over Main: Runtime Switch to Hardware Renderer
    Main->>HardwareRenderer: new HardwareRenderer()
    Main->>PlayerFacade: setRenderer(hardwareRenderer)
    PlayerFacade->>Player: setRenderer(hardwareRenderer)
    Player->>Player: this.renderer = hardwareRenderer
    
    Note over Main: Second Playback with Hardware Renderer
    Main->>PlayerFacade: playAll()
    PlayerFacade->>Player: play(item)
    Player->>HardwareRenderer: render(data)
    HardwareRenderer-->>Player: "[HardwareRenderer] GPU rendering: data"
```



