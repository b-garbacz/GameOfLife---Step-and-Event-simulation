package sim.core;

import java.util.PriorityQueue;

public class SimCalendar {

    private PriorityQueue<SimEvent> simEventPriorityQueue;

    public SimCalendar() {
        simEventPriorityQueue = new PriorityQueue<SimEvent>(new SimEventsComparator());
    }


    public void addSimCalendar(SimEvent event) {
        this.simEventPriorityQueue.add(event);
    }

    public SimEvent getSimCaledar() {
        return this.simEventPriorityQueue.poll();
    }

    public boolean isEmptySimCalendar() {
        return this.simEventPriorityQueue.isEmpty();
    }


}
