package lifei;

public abstract class AbsAlgorithmExplain {

    public void run() {

        introduce();

        basicIdea();

        extendedIdea();

        execute();
    }

    protected abstract void extendedIdea();

    protected abstract void basicIdea();

    protected abstract void introduce();

    protected abstract void execute();
}
