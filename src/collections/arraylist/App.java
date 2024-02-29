package arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        List<String> myList = Arrays.asList("Red", "Orange", "Green", "White", "Black");
        List<String> list2 = new ArrayList<>();

        // Sort list
        Collections.sort(myList);
        System.out.println(myList);

        // Reverse List
        Collections.reverse(myList);
        System.out.println(myList);

        // Extract a portion of elements in the list
        list2.addAll(myList.subList(0,3));
        System.out.println(list2);
        
        // Compare between 2 lists
        List<Boolean> list3 = new ArrayList<>();
        for (String s:myList){
            list3.add(list2.contains(s) ? true : false);
        }
        System.out.println(list3);

        // Swap elements in a list
        Collections.swap(list2, 0, 2);
        System.out.println(list2);

        // Combine 2 lists
        list2.addAll(myList);
        System.out.println(list2);

        // Change element in a list
        list2.set(1, "Cyan");
        System.out.println(list2);

        //Iterate through list
        for (String element:myList) {
            System.out.println(element);
        }

        for (int k = 0; k < myList.size(); k++) {
            System.out.println(myList.get(k));
        }
    }
}
