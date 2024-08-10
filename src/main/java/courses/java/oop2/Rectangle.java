package courses.java.oop2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class Rectangle extends Shape {

    @Getter @Setter
    private int width;

    @Getter @Setter
    private int height;

    public int getArea() {
        System.out.println("Method from Rectangle called!");
        return width * height;
    }
}
