package lambda;

public class LambaEx1 {
    static void execute(MyFunctionEx1 f) {
        f.run();
    }

    static MyFunctionEx1 getMyFunction() {
        MyFunctionEx1 f = () -> System.out.println("f3.run");
        return f;
    }

    public static void main(String[] args) {
        MyFunctionEx1 f1 = () -> System.out.println("f1.run");

        MyFunctionEx1 f2 = new MyFunctionEx1() {
            @Override
            public void run() {
                System.out.println("f2.run");
            }
        };

        MyFunctionEx1 f3 = getMyFunction();

        f1.run();
        f2.run();
        f3.run();

        execute(f1);;
        execute( () -> System.out.println("run"));
    }
}

@FunctionalInterface
interface MyFunctionEx1 {
    void run();
}