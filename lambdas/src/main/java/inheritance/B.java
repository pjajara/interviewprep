package inheritance;

/**
 * Created by pjajara on 2/6/17.
 */

//Replace inheritance with delegation
public class B extends A {

    public static void main(String args[]) {

        A a1 = new B();
       // A a2 = new A();

        a1.f1();
        a1.f2();
        a1.f3();


//        a2.f1();
//        a2.f2();
//        a2.f3();
    }

    private final A a = new A();

    public void f3() {
        System.out.println("B.f3()");
    }

    public void f1() {
        a.f1();
        System.out.println("Additional junk: Class B");
    }

    public void f2() {
        a.f2();
        System.out.println("Additional junk: Class B");
    }

    public void f4(){

    }
}
