package courses.java.oop2;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
public class Shape implements IShape {

    @Getter @Setter
    private String color;

    @Getter @Setter
    private int vertices;

    public int getArea() {
        return 0;
    }

    @Override
    public void draw() {

    }

    @Override
    public void printShape() {

    }

    @Override
    public int countVertices() {
        return 0;
    }
}
