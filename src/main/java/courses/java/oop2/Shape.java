package courses.java.oop2;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
public class Shape {

    @Getter @Setter
    private String color;

    @Getter @Setter
    private int vertices;

    public int getArea() {
        return 0;
    }
}
