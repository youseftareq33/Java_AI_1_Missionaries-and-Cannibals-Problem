# Missionaries and Cannibals Problem

The Missionaries and Cannibals problem is a classic example in Artificial Intelligence, used to illustrate graph search methods such as Breadth-First Search (BFS) and Depth-First Search (DFS).

## Problem Description

Three missionaries and three cannibals need to cross a river using a boat that can carry at most two people. However, on either side of the river, if the number of missionaries is outnumbered by the number of cannibals, the cannibals will eat the missionaries. The boat cannot cross the river without any people on board.

## Problem Formulation

### States

The state is represented by:
- The number of missionaries on the left side of the river.
- The number of cannibals on the left side of the river.
- The boat's position (left or right).
- The number of missionaries on the right side of the river.
- The number of cannibals on the right side of the river.

### Initial State

Standard initial state: `(3, 3, 1, 0, 0)`

Our initial state: `(3, 3, new Boat("Empty", "Empty", "Left"), 0, 0)`

### Successor Function

Possible actions involve moving missionaries and cannibals from one side to the other using the boat. The actions must ensure that missionaries are not outnumbered by cannibals on either side of the river.

### Goal Test

All missionaries and cannibals are on the right side of the river.

Goal state: `(0, 0, new Boat("Empty", "Empty", "Right"), 3, 3)`

### Path Cost

Each step (crossing) costs 1.

### Solution

A sequence of actions leading from the initial state to the goal state.

Example solution path:
- `[3, 3, new Boat("Empty", "Empty", "Left"), 0, 0]`
- `...`
- `[0, 0, new Boat("Empty", "Empty", "Right"), 3, 3]`

## Solving the Problem

The problem can be solved using graph search methods like BFS and DFS, which will explore the state space and find a sequence of actions that leads from the initial state to the goal state.

## Note:

- there is app_photo folder

- this work done by yousef sharbi and anas karakra
