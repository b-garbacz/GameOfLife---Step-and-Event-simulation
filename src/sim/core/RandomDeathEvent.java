package sim.core;

import sim.random.SimGenerator;


public class RandomDeathEvent extends SimEvent {
    public RandomDeathEvent(Manager mngrObj, double delay, int vsimPriority) {
        super(mngrObj, delay, vsimPriority);
    }

    public void annihilationOfRandomCells() {
        SimGenerator generator = new SimGenerator();
        int numberOfCellsToKill = generator.uniformInt(1, 3);

        for (int i = 0; i < numberOfCellsToKill; i++) {
            int x = generator.uniformInt(0, 6);
            int y = generator.uniformInt(0, 6);
            simMngr.array[x][y] = 0;
            System.out.println(x + "," + y);
        }
    }

    @Override
    public void stateChange() {
        System.out.println("---------------------------------------------------");
        SimGenerator generator = new SimGenerator();
        int randomTime = generator.uniformInt(2, 3);

        System.out.println("RandomeDeathEvent: " + getRunTime() + ", The random event kill will take place in: " + randomTime);
        simMngr.generateNewArray();
        annihilationOfRandomCells();
        new RandomDeathEvent(simMngr, randomTime, 1);
        System.out.println("---------------------------------------------------");
    }
}
