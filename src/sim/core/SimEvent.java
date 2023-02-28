package sim.core;
import sim.core.Manager;
import java.util.Objects;
public abstract class SimEvent {
    private double runTime;
    private int simPriority;
    public Manager simMngr;



    public SimEvent(Manager mngrObj, double delay, int vsimPriority){
        this.simPriority =vsimPriority;
        if (mngrObj != null){
            this.simMngr = mngrObj;
            if (delay >= 0)
                this.runTime = this.simMngr.simTime() + delay;
            else
                this.runTime= this.simMngr.simTime();
            this.simMngr.registerEvent(this);
        }
    }


    public double getRunTime() {
        return this.runTime;
    }


    public abstract void stateChange();

}
