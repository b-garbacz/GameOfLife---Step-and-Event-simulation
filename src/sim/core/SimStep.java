package sim.core;

public abstract class SimStep {
    private Manager simMngr;
    public double runTime;

    public SimStep(Manager mngr) {
        if (mngr != null) {
            simMngr = mngr;
            simMngr.registerSimStep(this);
        }
    }

    public double getRunTime() {
        return runTime;
    }

    public final double simTime() {
        if (simMngr != null)
            return simMngr.simTime();
        else
            return 0.0;
    }

    public abstract void stateChange();
}
