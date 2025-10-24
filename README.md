Modular Media Streaming Suite
Project Overview

The Modular Media Streaming Suite is a refactored version of a legacy media player, designed to demonstrate the use of structural design patterns in creating a flexible, maintainable, and scalable system. This project supports multiple media sources, feature decorators, playlist composition, and rendering strategies. It serves as a laboratory exercise for Integrative Programming focusing on software architecture and design patterns.

The goal is to evolve a simple monolithic media player into a modular streaming suite that supports dynamic extensions and adaptability through pattern-based refactoring.

Key Structural Design Patterns
Pattern	Implementation	Purpose
Decorator Pattern	Feature decorators (Caching, Equalizer, Subtitles, Watermark)	Dynamically add features to existing media without altering core classes
Composite Pattern	PlaylistComposite class	Treat individual media files and playlists uniformly
Adapter Pattern	Media source adapters for file, API, and HLS	Allow incompatible media sources to integrate into the unified system
Facade Pattern	MediaEngine class	Provide a single entry point to complex subsystems for simplified use
Core Features
Media Source Management

Local file playback for media stored on disk.

HLS streaming for online content.

API-based streaming integration for remote sources.

Proxy and caching to reduce redundant data fetching.

Feature Decorators

Caching for faster access to frequently played media.

Audio equalization for enhanced sound control.

Subtitles overlay system for readable text on video.

Watermarking for content branding.

Playlist System

Composite playlist that can contain both single files and sub-playlists.

Recursive playback of nested playlists.

Basic playback controls (play, pause, stop).

Rendering Strategy

Supports runtime switching between hardware and software rendering engines.

Allows flexible performance tuning depending on device capability.

System Architecture
Core Components
Component	Description	Pattern Used
MediaEngine	Main controller that manages playback, rendering, and sources.	Facade
MediaSource	Abstract class for all media types.	Adapter
PlaylistComposite	Manages multiple media objects as one.	Composite
MediaSourceDecorator	Base for all feature extensions (e.g., Equalizer, Subtitles).	Decorator
Renderer	Interface for switching between rendering methods.	Strategy (optional extension)
Architecture Overview (Summary)

The system follows a modular architecture, where each component can be extended or replaced independently. MediaEngine acts as a facade that communicates with MediaSource objects, which can either be simple files or complex composites of multiple sources. The Decorator pattern is applied to add extra behaviors at runtime without modifying existing code.

A docs/ folder contains UML and sequence diagrams that visualize the structure and flow:

Class Diagram: Shows the relationship between MediaSource, MediaEngine, and decorators.

Sequence Diagram: Demonstrates the processes of playing media and applying decorators.

Running the Application
1. Compile the Project
javac *.java


or, if using Maven:

mvn compile

2. Run the Main Program
java Main

3. Example Usage
=== Modular Media Streaming Suite ===
1. Add Local Media Source
2. Add HLS Stream Source
3. Add API Media Source
4. Apply Decorators
5. Switch Rendering Engine
6. Play Current Playlist
7. Show System Status
8. Exit

Testing the System
Manual Tests
# Test the basic playback
java -cp . Main

# Test decorator stacking
java -cp . DemoDecorator

# Test composite playlist structure
java -cp . DemoPlaylist

Integration Tests
# Run all test classes (if provided)
javac -cp . tests/*.java
java -cp . tests.TestRunner

Deliverables

Your repository should include the following:

1. Source Code Repository

All .java files inside the src/ directory.

A README.md file (this one).

Meaningful commit history showing development progress.

2. Documentation Folder (docs/)

architecture.md – Short overview of the system structure.

uml-diagram.png – UML class diagram showing class relationships.

sequence-diagram-play-media.png – Sequence diagram for the play flow.

sequence-diagram-decorator.png – Sequence diagram for decorator flow.

design-rationale.md – Explanation (max 800 words) of the patterns used and why.

3. Video Demonstration (max 12 minutes)

60–90 seconds: Explain architecture using diagrams.

4–6 minutes: Code walkthrough showing patterns in use.

2–3 minutes: Live demo of playlist, decorator toggling, and renderer switching.

60–90 seconds: Reflection on what could be improved.

Development Guidelines
Code Quality

Follow SOLID principles for maintainable code.

Use meaningful commit messages (e.g., “Added Decorator pattern for subtitles”).

Keep methods small and well-documented.

Handle exceptions gracefully with meaningful error messages.

Recommended Folder Structure
/src
    /MediaEngine.java
    /MediaSource.java
    /PlaylistComposite.java
    /Decorators/
        AudioEqualizer.java
        SubtitleRenderer.java
        Watermark.java
    /Adapters/
        LocalFileAdapter.java
        HLSStreamAdapter.java
        ApiMediaAdapter.java
/docs
    architecture.md
    uml-diagram.png
    sequence-diagram-play-media.png
    sequence-diagram-decorator.png
    design-rationale.md
README.md
LICENSE

Design Rationale (Summary)

The project uses structural design patterns to modularize and extend the system efficiently:

Decorator Pattern – Enables runtime addition of features without changing the core player.

Composite Pattern – Allows nested playlist structures that can contain both media files and other playlists.

Adapter Pattern – Integrates multiple types of media sources into a common format.

Facade Pattern – Simplifies user interaction by centralizing operations through the MediaEngine.

These design choices make the system flexible, testable, and easier to maintain as new media formats and features are added.
