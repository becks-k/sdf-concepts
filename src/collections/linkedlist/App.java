package linkedlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class App {

    public static void main(String[] args) {
        LinkedList<String> list1 = new LinkedList<>();

        list1.addAll(Arrays.asList("Apple", "Orange", "Pear", "Grapes", "Watermelon"));
        System.out.println(list1);

        // Iterate through list from specified index position
        Iterator p = list1.listIterator(1);
        while (p.hasNext()) {
            System.out.println(p.next());
        }

        // Iterate through list in reverse order
        Iterator d = list1.descendingIterator();
        while (d.hasNext()) {
            System.out.println(d.next());
        }

        // Adding elements to front, middle and end of list
        list1.addFirst("Papaya");
        list1.add(3, "Durian");
        System.out.println(list1);
        list1.addLast("Pineapple");
        System.out.println(list1);

        // Remove first and last element of list
        list1.removeFirst();
        System.out.println(list1);
        list1.removeLast();
        System.out.println(list1);

        // Remove all elements from list
        LinkedList<String> list2 = new LinkedList<>();
        list2.addAll(list1);
        System.out.println(list2);
        list2.clear();
        System.out.println(list2);

        // Convert linkedlist into arraylist
        List<String> arrList = new ArrayList<>(list1);
        System.out.println(arrList);



    }
}
