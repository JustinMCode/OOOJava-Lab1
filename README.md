# Register Lab - Java Lab One

## Overview
This project has been enhanced with patterns from the previous version of the lab.

## Design Patterns Implemented

### 1. Observer Pattern
**Description**
The Observer Pattern establishes a one-to-many dependency between objects, where a change in one object notifies and updates its dependents

**Implementation**
- **Observer Interface:** Defines the 'update()' method. 
- **Subject ('Purse' Class):** Maintains a list of observers and notifies them upon state changes. 
- **Observer ('PursePanel' Class):** Implements the 'Observer' interface and updates the UI when notified.
- 
### 2. Command Pattern
**Description:**
The Command Pattern encapsulates a request as an object, thereby allowing for parameterization of clients with queues, requests, and operations.

**Advantages:**
- **Encapsulates Requests:** Actions are encapsulated as command objects, promoting separation of concerns.
- **Extensibility:** Easily add new commands without modifying existing code.
- **Supports Undo/Redo:** Facilitates implementing undo and redo functionalities (future enhancement).

**Implementation:**
- **Command Interface:** Defines the `execute()` method.
- **Concrete Commands:** `AddMoneyCommand`, `RemoveMoneyCommand`, and `MakeChangeCommand` implement the `Command` interface.
- **Invoker (`InputListener` Class):** Creates and executes command objects based on user interactions.

## Old Project Structure
- **MakingChange.java:** Contains the main method to run the GUI-based version of the application.
- **Purse.java:** Represents the purse holding various denominations and notifies observers upon changes.
- **PursePanel.java:** A Swing panel that displays the contents of the purse and updates automatically when notified.
- **Register.java:** Handles the logic for making change and maintains the purse instance as a Singleton.
- **RegisterPanel.java:** The main GUI panel that interacts with the user, accepting input and displaying results.


## New Project Structure
- **MakingChange.java:** Contains the main method to run the GUI-based version of the application.
- **Purse.java:** Represents the purse holding various denominations and notifies observers upon changes.
- **PursePanel.java:** A Swing panel that displays the contents of the purse and updates automatically when notified.
- **Register.java:** Handles the logic for making change and maintains the purse instance as a Singleton.
- **RegisterPanel.java:** The main GUI panel that interacts with the user, accepting input and displaying results.
- **Command Interfaces and Classes:**
  - `Command.java`
  - `AddMoneyCommand.java`
  - `RemoveMoneyCommand.java`
  - `MakeChangeCommand.java`
- **Observer Interface:**
  - `Observer.java`

