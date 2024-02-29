package lambda;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.LongUnaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) throws Exception {

        List<String> strList = Arrays.asList("the", "HUNGRY", "fox", "ate", "tEN", "HENS");
        List<Integer> intList = Arrays.asList(4, 2, 3, 6, 5, 1);
        List<Double> dblList = Arrays.asList(1.22, 6.99, 100.4, 33.35, 67.99);
        String testStr = "This is a random string with a number of words in it hohoho.";
        
        /*
         * Write a Java program to implement a lambda expression to check if a given
         * string is empty.
         */
        // Test cases
        String a = "";
        String b = "Not empty!";
        Predicate<String> isEmptyStr = x -> x.isEmpty();
        System.out.println(isEmptyStr.test(a));
        System.out.println(isEmptyStr.test(b));

        /*
         * Write a Java program to implement a lambda expression to convert a list of
         * strings to uppercase and lowercase.
         */
        // Test cases
        
        strList.replaceAll(str -> str.toLowerCase());
        strList.forEach(str -> System.out.println(str));

        /*
         * Write a Java program to implement a lambda expression to filter out even and
         * odd numbers from a list of integers.
         */
        List<Integer> evenNums = intList.stream()
                .filter(num -> num % 2 == 0)
                .collect(Collectors.toList());

        System.out.println(evenNums);

        List<Integer> oddNums = intList.stream()
                .filter(num -> num % 2 != 0)
                .collect(Collectors.toList());

        System.out.println(oddNums);

        /*
         * Write a Java program to implement a lambda expression to sort a list of
         * strings in alphabetical order.
         */
        strList.sort((str1, str2) -> str1.compareToIgnoreCase(str2));
        System.out.println(strList);

        /*
         * Write a Java program to implement a lambda expression to find the average of
         * a list of doubles.
         */
        double avg = dblList.stream()
                .mapToDouble(Double::doubleValue) // converts each Double object to corresponding primitive double value
                .average() // operates on primitve double values
                .orElse(0.0);

        System.out.println(avg);

        /*
         * Write a Java program to implement a lambda expression to remove duplicates
         * from a list of integers.
         */
        List<Integer> distinct = new ArrayList<>();
        intList.stream()
                .distinct()
                .forEach(distinct::add);

        System.out.println(distinct);

        /*
         * Write a lambda expression to implement a lambda expression to calculate the
         * factorial of a given number.
         */
        //Functional interface whose functional method is applyAsLong. Long-valued operand that produces long-valued result.
        LongUnaryOperator fac = n -> {
            long result = 1;
            for (long i = 1; i <= n; i++) {
                result *= i;
            }
            return result;
        };

        long n = 7;
        System.out.println(fac.applyAsLong(n));

        /*
         * Write a Java program to implement a lambda expression to concatenate two
         * strings.
         */
        String str1 = "Hello cat";
        String str2 = "eats rat has a good nap";
        BiFunction<String,String,String> bif = (x,y) -> x + y;
        System.out.println(bif.apply(str1, str2));
        
        /*Write a Java program to implement a lambda expression to find the maximum and minimum values in a list of integers.*/
        //Optional object returns value if it exist, else returns null
        Optional<Integer> minValue = intList.stream()
        .max((x, y) -> x.compareTo(y));

        Optional<Integer> maxValue = intList.stream()
        .min((x, y) -> x.compareTo(y));
        
        System.out.println("Min value: " + minValue.orElse(null));
        System.out.println("Max value: " + maxValue.orElse(null));
        
        /*Write a Java program to create a lambda expression to multiply and sum all elements in a list of integers.*/
        int sum = intList.stream()
            .reduce(0, (x,y) -> x + y)
            .intValue();

        int multi = intList.stream()
            .reduce(1, (x,y) -> x * y)
            .intValue();
        
        System.out.println("Sum: " + sum);
        System.out.println("Multiply: " + multi);

        /*Write a Java program to implement a lambda expression to count words in a sentence.*/
        String pal1 = "radar";
        String pal2 = "madam";

        String reversed = new StringBuilder(pal1).reverse().toString();
        System.out.println(pal1.equals(reversed));

    }
}
