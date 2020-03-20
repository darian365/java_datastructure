package lifei;

public abstract class AbsAlgorithmExplain {

    public void run() {

        System.out.println("*******基本介绍****开始****");
        introduce();
        System.out.println("*******基本介绍****结束****");

        System.out.println("*******基本思想****开始****");
        basicIdea();
        System.out.println("*******基本介绍****结束****");

        System.out.println("*******高级思想****开始****");
        extendedIdea();
        System.out.println("*******高级思想****结束****");

        System.out.println("*******测试用例****开始****");
        execute();
        System.out.println("*******测试用例****结束****");
    }

    protected abstract void extendedIdea();

    protected abstract void basicIdea();

    protected abstract void introduce();

    protected abstract void execute();
}
