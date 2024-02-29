import java.util.HashMap;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        HashMap<String, String> todo = new HashMap<>();

        // try with resources to auto close resource
        try (Scanner sc = new Scanner(System.in)) {
            String day = sc.next().toLowerCase();
            // good practice to use variable as param; avoids null exception error if
            // variable is null
            while (!"stop".equals(day)) {
                // trim removes empty spaces after day
                String action = sc.nextLine().trim().toLowerCase();
                todo.put(day, action);

                day = sc.next().toLowerCase();
            }

            System.out.println(todo);
        }

    }
}
