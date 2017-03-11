package inheritance;

/**
 * Created by pjajara on 3/11/17.
 */
public class TestInheritance {

    public static void main(String[] args) {
        GenericShape genericShape = new GenericShape() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }

            @Override
            public boolean equals(Object obj) {
                return super.equals(obj);
            }

            @Override
            protected Object clone() throws CloneNotSupportedException {
                return super.clone();
            }

            @Override
            public String toString() {
                return super.toString();
            }

            @Override
            protected void finalize() throws Throwable {
                super.finalize();
            }
        };

        genericShape.counter= 100;
        System.out.println(genericShape.counter);
    }
}
