package lifei;

public abstract class AbsAlgorithmExplain {

    public void run() {
        execute();

        coreIdea();

        extendedIdea();
    }

    protected abstract void extendedIdea();

    protected abstract void coreIdea();

    protected abstract void execute();
}
