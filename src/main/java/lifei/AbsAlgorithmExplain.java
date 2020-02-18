package lifei;

public abstract class AbsAlgorithmExplain {

    public void run() {
        execute();

        introduce();

        basicIdea();

        extendedIdea();
    }

    protected abstract void extendedIdea();

    protected abstract void basicIdea();

    protected abstract void introduce();

    protected abstract void execute();
}
