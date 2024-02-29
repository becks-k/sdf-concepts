public class App {
    public static void main(String[] args) throws Exception {
        int count = 11;
        while (count < 11) {
            System.out.println("Count is: " + count);
            count++;
        }

        int count2 = 11;
        do {
            System.out.println("Count2 is: " + count2);
            count2++;
        } while (count2 < 11);
    }
}
