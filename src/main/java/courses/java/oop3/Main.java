package courses.java.oop3;

import courses.java.oop2.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] values = {1,5,7};
        System.out.println(values[2]);

        Shape[] shapes = {
                new Square(),
                new Triangle(),
                new Circle()
        };

        Shape[] sh2 = new Shape[5];
        sh2[0] = new Circle(5);
        sh2[0].setColor("Blue");
        System.out.println(sh2[0].getColor());
        ((Circle)sh2[0]).printCircle();

        Circle[] circ2 = { new Circle(1), new Circle(2)};
        circ2[0].printCircle();

        for (Circle s : circ2) {
            s.printShape();
        }

        for(int i = 0; i< circ2.length ; i++) {
            circ2[i].printShape();
        }

        ArrayList l = new ArrayList();
        l.add("Ana");
        l.add("are");
        l.add("mere");
        System.out.println(circ2);
        System.out.println(l);

        ArrayList<String> myList2 = new ArrayList<>();
        myList2.add("java");

        ArrayList<String> myList = new ArrayList<>();
        myList.add("alex");
        myList.add(1, "alex");
        myList.addAll(myList2);
        //myList.clear();
        System.out.println(myList.size());
        //myList.remove(1);
        Iterator it = myList.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        ArrayList<Circle> circleList = new ArrayList<>();
        circleList.add(new Circle(7));
        for(Circle c : circleList) {
            c.printCircle();
        }

        HashSet<String> hasSet1 = new HashSet<>();
        hasSet1.add("alex");
        hasSet1.add("alex"); // will not be added since it is duplicated
        System.out.println(hasSet1.size());

        hasSet1.addAll(myList);
        Utils.printList(hasSet1);

        HashMap<Integer, String> myHashmap = new HashMap<>();
        myHashmap.put(1, "alex");
        myHashmap.put(2, "Java");
        myHashmap.put(3, "intelliJ");
        Utils.printMap(myHashmap);

        String text = "Ana are mere si pere si caise si coacaze. Este sezonul, deci vor fi foarte gustoase!";
        Utils.printMap(Utils.countCharsInText(text));
        System.out.println(Browsers.FIREFOX);

        Catalogue myCatalogue = new Catalogue();
        myCatalogue.addStudent("Alex G", 7.0);
        myCatalogue.addStudent("Bogdan T", 9.0);
        myCatalogue.addStudent("Miruna C", 9.5);
        myCatalogue.addStudent("Andrei A", 4.0);

        myCatalogue.printStudents();
        myCatalogue.searchStudent("Alex A");
        myCatalogue.searchStudent("Alex G");

        myCatalogue.deleteStudent("Alex G");
        myCatalogue.orderStudentsName();
        myCatalogue.orderStudentsGrade();
    }
}
