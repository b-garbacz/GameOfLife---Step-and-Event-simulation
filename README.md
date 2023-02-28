# GameOfLife-Step and Event simulation
## Introduction
Game of life is a celluar automation which relies on interaction on the inital state through evolution.
## Objectives
![image](https://user-images.githubusercontent.com/45511879/221962451-3d3b448a-6dc0-4775-8b4f-9f81424c236e.png)

1. Cells live on a grid - 6x6.
2. Each cell has its own state where 1 means a living cell and 0 means a dead cell.
3. Each cell has neighbors that surround it.
4. Initial state is random.
5. Cells are evulating in generations. Each generation consists of calculating the new state of a cell is a function of all the states of neighboring cells at the previous moment in time.
6. Cell comes alive when he has 3 neighbors.
7. Cell survives when it has two or three living neighbors.
8. Cell dies when it has less than 2 neighbors and greater than 4(overpopulation).
9. Every step of time a new state is determined(Step Sim)
10. Along with the random time for the event there is a random destruction of cells(Event Sim)
## Result
![image](https://user-images.githubusercontent.com/45511879/221963572-6de84a69-d782-4f68-8af5-cf93c4f491a4.png)
