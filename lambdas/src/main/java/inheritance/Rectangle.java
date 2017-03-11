package inheritance;

/**
 * Created by pjajara on 3/11/17.
 */
public class Rectangle extends Shape {

    public static void main(String[] args) {
        //Shape s = new Rectangle();
//        Shape rectangle = new Rectangle();
//        rectangle.setColor("RectColor");
//        rectangle.setLength(1.0f);
//        rectangle.setWidth(1.0f);
//        // rectangle.setName(rectangle.getClass().getName().toString());
//
//        System.out.println(rectangle.name);
//        System.out.println(rectangle.color);
//        System.out.println(rectangle.length);
//        System.out.println(rectangle.width);
//        System.out.println(rectangle.calculateArea(rectangle.length, rectangle.width));

        Shape s1 = new Shape();
        System.out.println(s1.getName());

        Shape s2 = new Rectangle();
        System.out.println(s2.getName());

        Shape s3 = new Square();
        System.out.println(s3.getName());

        GenericShape s4 = new GenericShape() {
        };
        System.out.println((s4.getClass().getName()));
    }

    @Override
    protected float calculateArea(float length, float width){
        return length * width;
    }
}
