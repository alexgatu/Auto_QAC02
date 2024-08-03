package courses.java.oop1;

public class Main {
    public static void main(String[] args) {
//      instantiere obiect de tip pixuri
        Pixuri pixulVerdeGri = new Pixuri();
//      initializare atribute
        pixulVerdeGri.culoare = "verde";
        pixulVerdeGri.culoarePasta = "albastru";
        pixulVerdeGri.tip = "gel";
        pixulVerdeGri.grosime = 2;
        pixulVerdeGri.lungime = 12;

        System.out.println(pixulVerdeGri.scrie());
        pixulVerdeGri.scrie("Primul meu obiect in java");

        MathNew math = new MathNew();
        System.out.println("Suma:" + math.suma(2, 3));
        System.out.println("Diferenta:" + math.diferenta(3, 2));
        System.out.println("Numarul 5 este impar:" + math.isOddNumber(5));
        System.out.println("Numarul 4 este impar:" + math.isOddNumber(4));

        System.out.println("-------------------------------------------------");
//       aplelare metoda statica dintr-o clasa
           Draw.drawFullShape(3, 2);
        System.out.println("-------------------------------------------------");
        Draw.drawShapeOutline(7,8);
        Draw.drawSquare(5);
        System.out.println("-------------------------------------------------");
//        constructor custom
        Square square = new Square(7);
        square.draw();
        System.out.println("Aria patratului este:"+square.getArea());
        System.out.println("-------------------------------------------------");
        //        constructor default with set method
        Square square1 = new Square();
        square1.setSide(5);
        System.out.println("Square side:" + square1.getSide());
        square1.draw();
        System.out.println(square1.getArea());
//       protected values
        System.out.println("Perimeter:" + square1.getPerimeter());
        System.out.println("-------------------------------------------------");
        Circle circle = new Circle(5.4);
        System.out.println("Circle area:" + circle.getArea());
    }
}
