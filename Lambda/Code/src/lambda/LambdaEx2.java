package lambda;

public class LambdaEx2 {
    public static void main(String[] args) {
        MyFunctionEx2 f = () -> {};
        Object obj = (MyFunctionEx2)(() -> {});
        String str = ((Object)(MyFunctionEx2)(()->{})).toString();

        System.out.println(f);
        System.out.println(obj);
        System.out.println(str);

        System.out.println((MyFunctionEx2)(()->{}));
        System.out.println(((Object)(MyFunctionEx2)(()->{})).toString());
    }
}

@FunctionalInterface
interface MyFunctionEx2 {
    void myMethod();
}