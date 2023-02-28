package sim.core;

import java.util.Comparator;

public class SimEventsComparator implements Comparator<SimEvent> {
    @Override
    public int compare(SimEvent o1, SimEvent o2) {
        double delta = o1.getRunTime() - o2.getRunTime();
        if (delta > 0)
            return 1;
        else if (delta < 0)
            return -1;
        else
            return 0;
    }
}