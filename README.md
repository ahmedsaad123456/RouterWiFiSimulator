# Router WIFI Simulator

This Java program simulates a Wi-Fi router's functionality using threading and semaphores to limit the number of concurrent connections. The router is designed to have a maximum of N connections at any given time. When N connections are active, the router will not accept additional incoming connections until an existing connection is released.

## Problem Definition

The problem involves simulating a limited number of devices connected to a router's Wi-Fi using Java threading and semaphore. The following rules should be applied:

- The Wi-Fi initially has no connected devices.
- When a client logs in and can be served, the client should perform the following activities:
  - Connect to the Wi-Fi
  - Perform online activity
  - Log out
- There is a random waiting time between the printed messages when a client connects, performs online activities, and logs out.
- If a client arrives and all connections are occupied, the client must wait until one of the currently available clients finishes their service.
- After a client finishes their service, they leave, and one of the waiting clients (if any) will connect to the internet.

## Implementation

The implementation uses Java threading and semaphores to achieve the desired behavior. Semaphores are used to control access to the limited resources (connections) provided by the router.

## Program Structure

The program is organized into four classes: Network , Semaphore , Router and Device. These classes serve distinct purposes:


### 1. Network Class

Entry point managing user input, device initialization, and thread execution.

### 2. Semaphore Class

Basic semaphore implementation for controlling access to limited resources.

### 3. Router Class

Manages Wi-Fi connections, allocates and releases permits using semaphores.

### 4. Device Class

Represents a client device, extends Thread, and simulates connecting, performing activities, and disconnecting.

## Usage

To use the program, follow these steps:

1- Run the program.

2- The prgram will start and display a prompt, awaiting your input.

3- Enter the number of the connections. 

4- Enter the number of the devices want to connect.

5- For each device, Enter the information of it (name and type).

6- The program will simulate clients connecting, performing online activities, and disconnecting.

7- Once the simulation is complete, you can terminate the program.

Enjoy simulating your Wi-Fi Router scenario!

## Contributors

We would like to thank the following contributors to this project:


- [Ahmed Saad](https://github.com/ahmedsaad123456).

- [Shahd Osama](https://github.com/shahdosama10).

- [Shahd Mostafa](https://github.com/ShahdMostafa30).
  
- [Maryam Osama](https://github.com/maryamosama33).

Special thanks to everyone who has helped make this project better.







