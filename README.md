# Retro Pong

A classic Pong game built with Java using the Swing and AWT libraries. This project features a single-player mode against a Bot, a local multiplayer mode, and customizable themes.

## Features

* **Single Player:** Play against a virtual opponent with adjustable difficulty levels (Potato, Average, Pro).
* **Local Multiplayer:** Play against a friend on the same computer.
* **Themes:** Customize the look of the game with different color schemes.
* **Retro Feel:** Classic arcade-style graphics and gameplay.

## Controls

### Main Menu
* **Up Arrow:** Navigate up
* **Down Arrow:** Navigate down
* **Enter:** Select an option

### In-Game (Multiplayer)
* **Player 1 (Left Paddle):**
    * `W`: Move Up
    * `S`: Move Down
* **Player 2 (Right Paddle):**
    * `Up Arrow`: Move Up
    * `Down Arrow`: Move Down

### In-Game (Single Player)
* **Player (Left Paddle):**
    * `W`: Move Up
    * `S`: Move Down
* The right paddle is controlled by the AI.

## Project Structure

The project is organized into several Java classes, each with a specific responsibility:

* `Main.java`: The entry point of the application. It creates the main menu and starts the game loop.
* `MainMenu.java`: Manages and displays the main menu, handling user input for game mode selection, themes, and quitting.
* `Game.java`: Contains the core game logic for both single-player and multiplayer modes, including the game loop, rendering, and collision detection.
* `SimpleGameWindow.java`: A reusable class that provides a simple windowing system for drawing shapes and text, and handling keyboard input.
* `Ball.java`: Defines the properties and behavior of the ball, including its movement and collision logic.
* `Paddle.java`: Defines the properties and behavior of the player paddles.
* `AI.java`: Implements the logic for the computer-controlled opponent in single-player mode. It also handles the difficulty selection menu.
* `Score.java`: Manages the players' scores.
* `Constants.java`: A utility class to store global constants like screen dimensions and the maximum score.
* `Themes.java`: Manages the different color themes for the game.
