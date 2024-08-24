package courses.java.oop2;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Utils {

    public static int value = 100;

    // Static - needs to be called from the class
    public static void printCircleStatic(Circle c) {
        System.out.println("Color: " + c.getColor());
        System.out.println("Vertices count: " + c.getVertices());
        System.out.println("Radius: " + c.getRadius());
        System.out.println("---------");
    }

    public static void printList(Collection c) {
        for (Object o : c) {
            System.out.println(o);
        }
    }

    public static void printMap(Map m) {
        for (Object o : m.keySet()) {
            System.out.println("Key " + o + " Value: " + m.get(o));
        }
    }

    public static HashMap<Character, Integer> countCharsInText(String text) {
        HashMap<Character, Integer> charMap = new HashMap<>();
        for (char c : text.toLowerCase().toCharArray()) {
            if (charMap.containsKey(c)) {
                charMap.put(c, charMap.get(c) + 1);
            }
            else {
                charMap.put(c, 1);
            }
        }
        return charMap;
    }

}
