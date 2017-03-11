package inheritance;

/**
 * Created by pjajara on 3/11/17.
 */
// Class that has all basic characteristics of a Shape
public class Shape extends GenericShape{

    protected String name;
    protected String color;
    protected float length;
    protected float width;

    public Shape() {
        name = this.getClass().getName().toString();
        color = "Black";
        length = 0.1f;
        width = 0.1f;
    }

    public Shape(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    protected float calculateArea(final float l, final float w) {
        return l * w;
    }
}
