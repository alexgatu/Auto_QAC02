package courses.java.intro;

public class Exercises {

    public static void main(String[] args) {
//        Compute the average of first N numbers from 1
        if (args.length > 0) {
            int n = Integer.parseInt(args[0]);
            int sum = 0;
            for (int i = 1; i <= n; i++) {
                sum = sum + i;
            }
            System.out.println("Average is:" + ((float) sum / n));
        } else {
            System.out.println("Please provide N as argument");
        }

        int[] numbers = {23, 56, 43, 8, 59, 36};
        System.out.println(numbers[2]);

//        Find the minimum number of a list of numbers
        int min = numbers[0];
        for (int i = 1; i <= numbers.length - 1; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
            }
        }
        System.out.println("Min number is:" + min);

//        Find the number of occurrences of a specific letter in a word
        String word = "Ana are mere si pere multe";
        char c = 'e';
        int nrApp = 0;
        for (int i = 0; i < word.length(); i++) {
            if (c == word.charAt(i)) {
                nrApp++;
            }
        }
        System.out.println("Number of appearances of " + c + " is:" + nrApp);
    }
}
