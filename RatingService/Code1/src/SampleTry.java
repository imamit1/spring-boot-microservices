class B1 {
    private int a = 10;
    protected int b = 30;
    protected void sum() {
        new B1().get();
    }
    private void get() {
        System.out.println(a+b);
    }
    protected void add() {
        get();
    }
}
class B2 extends B1 {
    protected int c = 10;
    protected void add() {
        new B1().add();
    }
    private void test() {
        System.out.println("test");
    }
}
public class SampleTry {
    public static void main(String[] args) {
        new B2().add();
    }
}
