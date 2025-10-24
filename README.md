
# Modular Media Streaming Suite

## Project Overview

The Modular Media Streaming Suite is an educational and practical implementation of a professional media streaming platform. Built with clean architecture principles, it demonstrates how structural design patterns can be effectively applied to create maintainable, scalable, and extensible software systems.

## Key Structural Design Patterns

| Pattern           | Implementation                                                | Purpose                                                      |
| ----------------- | ------------------------------------------------------------- | ------------------------------------------------------------ |
| Decorator Pattern | Feature decorators (Caching, Equalizer, Subtitles, Watermark) | Dynamic feature enhancement without modifying core classes   |
| Composite Pattern | PlaylistComposite for hierarchical media management           | Unified interface for individual and composite media objects |
| Adapter Pattern   | Media source adapters for different input formats             | Interface compatibility between different media sources      |
| Facade Pattern    | MediaEngine as unified interface to complex subsystem         | Simplified interface to complex media processing system      |

## Core Features

### Media Source Management

* Local Media Sources: High-performance file-based media playback with optimized I/O operations
* HLS Streaming Integration: Full HTTP Live Streaming (HLS) support for adaptive bitrate streaming
* API-Based Sources: RESTful API integration for external media content delivery
* Cached Media Sources: Intelligent caching layer for improved performance and reduced bandwidth

### Advanced Decorators

* Intelligent Caching: Multi-level caching system with LRU eviction policies
* Real-time Audio Processing: Advanced equalizer with frequency domain analysis
* Dynamic Subtitle Rendering: Multi-format subtitle support with real-time positioning
* Professional Watermarking: Configurable visual overlays with transparency support

### Media Processing Architecture

* Unified Media Interface: Consistent interface for all media sources through Facade pattern
* Extensible Decorator Chain: Multiple decorators can be chained for enhanced functionality
* Hierarchical Playlist Management: Composite pattern enables nested playlist structures

### Playlist Management System

* Hierarchical Playlist Structure: Nested playlist support with unlimited depth
* Dynamic Playlist Construction: Runtime playlist building with real-time updates
* Intelligent Playback Control: Advanced sequencing with shuffle and repeat modes
* Playlist Persistence: Save and restore playlist configurations

## System Architecture

### Core Components

| Component            | Responsibility                                 | Design Pattern    |
| -------------------- | ---------------------------------------------- | ----------------- |
| MediaEngine          | Central orchestration and lifecycle management | Facade Pattern    |
| MediaSource          | Abstract media source interface                | Adapter Pattern   |
| PlaylistComposite    | Hierarchical media collection management       | Composite Pattern |
| MediaSourceDecorator | Feature enhancement wrapper                    | Decorator Pattern |
| MediaFormatAdapter   | Interface compatibility for different formats  | Adapter Pattern   |

## Running the Application

### 1. Compile the Project

```bash
javac *.java
```

Or using Maven:

```bash
mvn compile
```

### 2. Run the Main Application

```bash
java Main
```

Or run with a specific media file:

```bash
java Main path/to/your/video.mp4
```

### 3. Run the Presentation Demo

```bash
java -cp . PresentationDemo
java -cp . DemoScenarios
```

## Demo Scenarios

### Basic Playlist Demo

```bash
java -cp . DemoScenarios basicPlaylist
java -cp . DemoScenarios decoratorChain
java -cp . DemoScenarios rendererSwitch
java -cp . DemoScenarios fullWorkflow
```

### Interactive Demo Menu

```
=== Modular Media Streaming Suite ===
1. Add Local Media Source
2. Add HLS Stream Source  
3. Add API Media Source
4. Configure Decorators
5. Switch Rendering Engine
6. Play Current Playlist
7. Show System Status
8. Exit
```

## Testing

### Run All Tests

```bash
javac -cp . test/*.java
java -cp . TestRunner
java -cp . IntegrationTestRunner
```

### Manual Testing Scenarios

```bash
java -cp . TestScenarios basicFunctionality
java -cp . TestScenarios decoratorPatterns
java -cp . TestScenarios compositePattern
java -cp . TestScenarios adapterPattern
```

### Performance Testing

```bash
java -cp . PerformanceTest
java -Xmx2g -cp . MemoryAnalysis
java -cp . RenderingPerformanceTest
```

## Educational Value

This project serves as a comprehensive laboratory for Integrative Programming 2, demonstrating:

* Real-world Pattern Application: How design patterns solve actual software engineering challenges
* Architecture Decision Making: Trade-offs between different architectural approaches
* Code Organization: Professional code structure and separation of concerns
* Extensibility Design: Building systems that can grow and adapt to new requirements

### Learning Outcomes

* Understanding of structural design patterns in practice
* Experience with clean architecture principles
* Knowledge of media streaming system design
* Skills in creating extensible, maintainable codebases

## Development Guidelines

### Code Quality Standards

* SOLID Principles
* Clean Code with meaningful names and small functions
* Consistent use of design patterns
* Comprehensive error handling and recovery

### Extension Points

* Custom Media Sources: Implement MediaSource interface for new source types
* Custom Decorators: Extend MediaSourceDecorator for new features
* Custom Renderers: Implement Renderer interface for specialized rendering
* Custom Playlist Items: Extend PlaylistItem for specialized media handling

## Documentation

All documentation files are in the `docs/` folder:

* `docs/architecture.md`
* `docs/uml-diagrams.md`
* `docs/sequence-diagrams.md`
* `docs/design-rationale.md`

## Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Add tests if applicable
5. Submit a pull request

## License

This project is licensed under the MIT License.

