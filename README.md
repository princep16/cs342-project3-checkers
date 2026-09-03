# Networked Checkers Game

A feature-rich JavaFX Checkers application where players can challenge friends in real time or compete against a computer AI with multiple difficulty levels. 
Built with TCP sockets and a multithreaded client-server architecture, it supports matchmaking, chat, friend requests, player statistics, and server-enforced game rules.

## ✨ Features

### Gameplay

- Real-time multiplayer Checkers
- Player-versus-player and player-versus-AI modes
- Easy, medium, and hard AI difficulty options
- Server-side move validation and turn management
- Mandatory jumps and consecutive jump handling
- King promotion and game-over detection
- Move hints, draw requests, rematches, and match quitting

### Multiplayer and Social Features

- Unique player usernames
- Online-player and friend lists
- Direct match challenges
- Friend requests and responses
- In-game player chat
- Session-based win and loss statistics

## 🛠️ Technologies

- Java 11
- JavaFX
- TCP sockets
- Java object serialization
- Multithreading
- Concurrent collections
- Maven
- Git and GitHub

## Architecture

The application uses a client-server architecture with separate Maven projects for the client and server.

### Server

- Accepts connections through a `ServerSocket` on port `5555`
- Creates a separate thread for each connected client
- Manages connected users and active games with `ConcurrentHashMap`
- Validates moves and enforces Checkers rules
- Coordinates matchmaking, chat, friends, statistics, and game sessions
- Sends updates through serialized `Message` objects

### Client

- Connects to the server through a TCP socket
- Uses JavaFX for login, lobby, game, and game-over interfaces
- Sends player actions to the server
- Receives board, match, chat, and player-status updates
- Updates the interface safely through the JavaFX application thread

## 🚀 Getting Started

### Prerequisites

- Java Development Kit 11 or later
- Maven
- IntelliJ IDEA or another Java IDE with Maven and JavaFX support

### Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/princep16/cs342-project3-checkers.git
   ```

2. Open the cloned project in IntelliJ IDEA.

3. Load both Maven projects:

   ```text
   hw5.startercode/HW5Server
   hw5.startercode/HW5Client
   ```

4. Allow Maven to download the JavaFX and JUnit dependencies.

### Running the Application

1. Open the server project and run:

   ```text
   GuiServer.java
   ```

2. Confirm that the server is listening on port `5555`.

3. Open the client project and run:

   ```text
   GuiClient.java
   ```

4. Run a second client instance to test multiplayer mode, or choose the AI option from the lobby.

The current client configuration connects to the server on the local machine at `127.0.0.1`.

## 📁 Project Structure

```text
hw5.startercode/
├── HW5Client/
│   ├── pom.xml
│   └── src/main/java/
│       ├── Client.java
│       ├── GuiClient.java
│       └── Message.java
│
└── HW5Server/
    ├── pom.xml
    └── src/main/java/
        ├── Server.java
        ├── GuiServer.java
        └── Message.java
```

## 👥 Team

- Prince Patel
- Shlok Zala

### Prince Patel’s Contributions

- Implemented client-server communication using Java TCP sockets
- Developed Checkers rules, turn handling, and move-validation logic
- Built matchmaking, friend-request, chat, and player-statistics features
- Designed and implemented the JavaFX client interface
- Coordinated the GitHub workflow and project integration
- Performed integration testing and debugging across the client and server

## Current Limitations

- The client currently connects to a locally hosted server.
- Player profiles, friends, and statistics are stored in memory and reset when the server restarts.
- Automated test coverage is currently limited.

## Future Improvements

- Persist player accounts and statistics in a database
- Allow configurable remote-server addresses
- Expand automated testing for game rules and networking
- Improve authentication and reconnection handling
- Package the client and server as executable applications

## Academic Context

Developed as a team project for CS 342: Software Design at the University of Illinois Chicago.
