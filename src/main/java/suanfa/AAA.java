package suanfa;

/**
 * @author lj
 * @createDate 2019/7/26 14:28
 **/
public class AAA {
    static class A {
        private int a = 1;
    }

    static class  B extends A{
        private int a = 2;

    }

    public static void main(String[] args) {
        A a= new B();
        System.out.println(a.a);

    }
}
