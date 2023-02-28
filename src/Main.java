import sim.core.LifeCycleEvent;
import sim.core.Manager;


public class Main {
    public static Manager menager = Manager.getInstance(0);

    public static void main(String[] args) {

        menager.setEndSimTime(30);
        menager.startSimulation();
    }
}
