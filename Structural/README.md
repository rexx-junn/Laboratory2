 Modular Media Streaming Suite

A Java-based modular media streaming application demonstrating key design patterns and clean architecture principles.

Overview

This project implements a flexible media streaming system that supports multiple media sources, rendering strategies, and dynamic feature enhancement through decorators. The architecture emphasizes modularity, extensibility, and separation of concerns.

 Features

- Multiple Media Sources: Local files, remote APIs, HLS streams
- Flexible Rendering: Software and hardware rendering options
- Dynamic Enhancement: Decorator pattern for adding features like watermarks,        subtitles, and audio equalization
- Playlist Management: Composite pattern for managing media collections
- Caching Support: Proxy pattern for stream caching
- Runtime Flexibility: Switch between different implementations at runtime

 Architecture

The system is organized into four main packages:

- `com.modularmedia.player` - Core player functionality and facade
- `com.modularmedia.playlist` - Playlist management with composite pattern
- `com.modularmedia.source` - Media source abstractions and implementations
- `com.modularmedia.render` - Rendering system with decorator support

 Quick Start

 Prerequisites

- Java 8 or higher
- Bash shell (for build script)

 Building and Running

1. Build the project:
   ```bash
   ./build.sh
   ```

2. Run the demo:
   ```bash
   ./build.sh demo
   ```

3. Run tests:
   ```bash
   ./build.sh test
   ```

 Example Usage

```java
// Create media sources
MediaSource local = new LocalFileSource("song.mp3");
MediaSource remote = new RemoteApiSource("https://example.com/stream/lofi");

// Create playlist
Playlist playlist = new Playlist("My Playlist");
playlist.addItem(new MediaFileItem(local));
playlist.addItem(new MediaFileItem(remote));

// Create base renderer
Renderer renderer = new SoftwareRenderer();

// Add decorator layers
renderer = new WatermarkDecorator(renderer, "© ModularMedia");
renderer = new SubtitleDecorator(renderer, "Now Playing...");
renderer = new EqualizerDecorator(renderer, "Bass Boost");

// Initialize and use player
PlayerFacade player = new PlayerFacade(renderer);
player.loadPlaylist(playlist);
player.playAll();
```

 Design Patterns

This project demonstrates several key design patterns:

- Decorator Pattern: Dynamic feature enhancement for renderers
- Facade Pattern: Simplified interface to complex subsystems
- Composite Pattern: Hierarchical playlist management
- Strategy Pattern: Interchangeable media sources and renderers
- Proxy Pattern: Caching and lazy loading

 Project Structure

```
src/
├── com/modularmedia/
│   ├── Main.java                       Application entry point
│   ├── player/                         Player layer
│   │   ├── Player.java                 Core player
│   │   └── PlayerFacade.java           Facade implementation
│   ├── playlist/                       Playlist management
│   │   ├── Playlist.java               Composite playlist
│   │   ├── PlaylistItem.java           Playlist item interface
│   │   └── MediaFileItem.java          Media file wrapper
│   ├── source/                         Media sources
│   │   ├── MediaSource.java            Source interface
│   │   ├── LocalFileSource.java        Local file source
│   │   ├── RemoteApiSource.java        Remote API source
│   │   ├── HLSStreamSource.java        HLS stream source
│   │   └── StreamProxy.java            Caching proxy
│   └── render/                         Rendering system
│       ├── Renderer.java               Renderer interface
│       ├── SoftwareRenderer.java       Software rendering
│       ├── HardwareRenderer.java       Hardware rendering
│       └── decorator/                  Decorator implementations
│           ├── RendererDecorator.java
│           ├── WatermarkDecorator.java
│           ├── SubtitleDecorator.java
│           └── EqualizerDecorator.java
```

 Documentation

Detailed documentation is available in the `docs/` folder:

- [Architecture Overview](docs/architecture.md)
- [UML Class Diagrams](docs/uml-diagrams.md)
- [Sequence Diagrams](docs/sequence-diagrams.md)
- [Design Rationale](docs/design-rationale.md)

 Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Add tests if applicable
5. Submit a pull request

 License

This project is licensed under the MIT License - see the LICENSE file for details.
