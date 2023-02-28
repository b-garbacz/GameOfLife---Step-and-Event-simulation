package sim.core;

public class LifeCycleEvent extends SimEvent {
    public int[][] oldArray;

    public int[][] newArray;


    public LifeCycleEvent(Manager mngrObj, double delay, int vsimPriority) {
        super(mngrObj, delay, vsimPriority);
        this.oldArray = mngrObj.array;
        this.newArray = oldArray;


    }

    public void genNewArray() {
        for (int i = 0; i < this.oldArray.length; i++) {
            for (int j = 0; j < this.oldArray[i].length; j++) {
                int aliveNeighbours = calcTheNumberOfNeighbors(i, j);

                if (oldArray[i][j] == 1) {
                    if (aliveNeighbours == 2 || aliveNeighbours == 3) {
                        newArray[i][j] = 1;
                    } else {
                        newArray[i][j] = 0;
                    }

                } else {
                    if (aliveNeighbours == 3) {
                        newArray[i][j] = 1;
                    } else {
                        newArray[i][j] = 0;
                    }
                }
            }

        }

    }


    public int calcTheNumberOfNeighbors(int x, int y) {
        int neighbors = 0;
        for (int i = x - 1; i <= x + 1; i++) {
            if (i < 0 || i > this.oldArray.length - 1) {
                continue;
            }
            for (int j = y - 1; j <= y + 1; j++) {
                if (j < 0 || j > this.oldArray.length - 1 || (i == x && j == y)) {
                    continue;
                }
                if (oldArray[i][j] == 1) {
                    neighbors++;
                }

            }
        }
        return neighbors;
    }

    public void printNewArray() {


        for (int i = 0; i < newArray.length; i++) {
            for (int j = 0; j < newArray[i].length; j++) {
                System.out.print(newArray[i][j] + " ");
            }
            System.out.println("");
        }

    }

    @Override
    public void stateChange() {
        System.out.println("---------------------------------------------------");
        System.out.println("LifeCycleEvent= " + getRunTime());
        genNewArray();
        printNewArray();
        simMngr.setArray(newArray);
        LifeCycleEvent lifeCycleEvent = new LifeCycleEvent(simMngr, 1, 1);
        System.out.println("---------------------------------------------------");

    }
}
