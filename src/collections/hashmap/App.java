package hashmap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        // Add values to HashMap if it does not exist, if not increment count by 1
        for (int i = 0; i < 11; i++) {
            if (!hm.containsKey(i)) {
                hm.put(i, 1);
            } else {
                hm.put(i, hm.get(i) + 1);
            }
        }
        System.out.println(hm.keySet());

        // Filtering keys of hashmap to a list
        List<Integer> filteredhm = hm.entrySet().stream()
            .filter(x -> x.getKey() % 2 == 0)
            .map(Map.Entry::getKey)
            .collect(Collectors.toList());

        System.out.println(filteredhm);
    }
}
