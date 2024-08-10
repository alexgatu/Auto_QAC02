package courses.java.oop2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class Square extends Rectangle {

    public Square(int length) {
        super(length, length);
    }

    public void setLength(int length) {
        super.setHeight(length);
        super.setWidth(length);
    }

    public int getLength() {
        if (super.getHeight() != super.getWidth()) {
            System.out.println("There is an error in the square");
        }
        return super.getWidth();
    }

    @Override
    public int getArea() {
        System.out.println("Method called from Square !");
        return super.getWidth() * super.getWidth();
    }

}
