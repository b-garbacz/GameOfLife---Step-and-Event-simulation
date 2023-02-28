package sim.core;

import java.util.LinkedList;
import java.util.Random;

public class Manager {

    private double startSimTime = 0.0;
    private double stopSimTime = Double.MAX_VALUE;
    private double currentSimTime = startSimTime;
    private final double timeStep = 1.0;
    private static Manager simMngr; //Singleton
    private boolean simulationStarted = false;
    public static int[][] array = new int[6][6];

    private SimCalendar simCalendarEvents = new SimCalendar();


    private LinkedList<SimStep> simStepWorkers = new LinkedList<>();

    public static Manager getInstance(double startSimTime) {
        if (simMngr == null) {
            simMngr = new Manager(startSimTime);
        }
        return simMngr;
    }

    public Manager(double startSimTime) {
        if (startSimTime > 0.0)
            this.startSimTime = startSimTime;

    }

    public void registerSimStep(SimStep step) {
        if (step != null)
            simStepWorkers.add(step);
    }

    public final double simTime() {
        return currentSimTime;
    }

    public final void stopSimulation() {
        simulationStarted = false;
    }

    public final void startSimulation() {
        simulationStarted = true;
        generateNewArray();
        LifeCycleEvent lifecycleevent = new LifeCycleEvent(this, 0, 1);
        RandomDeathEvent randomDeathEvent = new RandomDeathEvent(this, 1, 0);
        while (!simCalendarEvents.isEmptySimCalendar() && simulationStarted) {
            nextEvent();
        }

    }

    public void setEndSimTime(double endSimTime) {
        this.stopSimTime = endSimTime;
    }

    private final void nextEvent() {
        SimEvent currentEvent = this.simCalendarEvents.getSimCaledar();
        double currentEventRuntime = currentEvent.getRunTime();
        this.currentSimTime = currentEventRuntime;
        currentEvent.stateChange();
        if (!(this.currentSimTime < stopSimTime)) {
            stopSimulation();
        }
    }


    public void registerEvent(SimEvent event) {
        if (event != null)
            this.simCalendarEvents.addSimCalendar(event);
    }

    public void generateNewArray() {
        Random random = new Random();
        int low = 0;
        int high = 1;
        for (int i = 0; i < this.array.length; i++) {
            for (int j = 0; j < this.array[i].length; j++) {
                this.array[i][j] = random.nextInt(high - low + 1) + low;
                System.out.print(this.array[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public void setArray(int[][] newArray) {
        this.array = newArray;
    }
}
