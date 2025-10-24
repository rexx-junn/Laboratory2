# Architecture Overview

## System Architecture

The Modular Media Streaming Suite follows a layered architecture with clear separation of concerns:

```
┌─────────────────────────────────────────────────────────────┐
│                    Application Layer                        │
│                     (Main.java)                            │
└─────────────────────────────────────────────────────────────┘
                                │
┌─────────────────────────────────────────────────────────────┐
│                    Facade Layer                             │
│                 (PlayerFacade)                              │
└─────────────────────────────────────────────────────────────┘
                                │
        ┌───────────────────────┼───────────────────────┐
        │                       │                       │
┌───────▼────────┐    ┌─────────▼─────────┐    ┌───────▼────────┐
│  Player Layer  │    │  Playlist Layer   │    │  Render Layer  │
│   (Player)     │    │  (Playlist,       │    │  (Renderer +   │
│                │    │   PlaylistItem)   │    │   Decorators)  │
└────────────────┘    └───────────────────┘    └────────────────┘
                                │
┌─────────────────────────────────────────────────────────────┐
│                  Source Layer                               │
│            (MediaSource implementations)                    │
└─────────────────────────────────────────────────────────────┘
```

## Key Components

### 1. Player Layer
- **Player**: Core playback functionality
- **PlayerFacade**: Simplified interface hiding complexity

### 2. Playlist Management
- **Playlist**: Composite structure for media collections
- **PlaylistItem**: Interface for playlist elements
- **MediaFileItem**: Wrapper connecting media sources to playlists

### 3. Media Sources
- **MediaSource**: Strategy interface for different source types
- **LocalFileSource**: Local file access
- **RemoteApiSource**: Remote API integration
- **HLSStreamSource**: Live streaming support
- **StreamProxy**: Caching and optimization

### 4. Rendering System
- **Renderer**: Strategy interface for rendering approaches
- **SoftwareRenderer**: CPU-based rendering
- **HardwareRenderer**: GPU-accelerated rendering
- **Decorators**: Dynamic feature enhancement

## Design Principles

1. **Single Responsibility**: Each class has one clear purpose
2. **Open/Closed**: Open for extension, closed for modification
3. **Dependency Inversion**: Depend on abstractions, not concretions
4. **Interface Segregation**: Small, focused interfaces
5. **Composition over Inheritance**: Favor object composition

## Data Flow

1. **Media Loading**: Sources fetch media data
2. **Playlist Management**: Items are organized in playlists
3. **Rendering Pipeline**: Data flows through decorator chain
4. **Output**: Processed media is rendered to output

## Extensibility Points

- New media sources can be added by implementing `MediaSource`
- New rendering strategies via `Renderer` interface
- New features through decorator pattern
- New playlist item types via `PlaylistItem` interface



