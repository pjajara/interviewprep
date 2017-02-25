package edu.sjsu.java.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pjajara on 2/17/17.
 */
public class MapUtils {

    public static void main(String[] args) {

        // sumEqualsK(new Integer[]{3, 5, 1, 6, 2, 4}, 5);

        Map<String, String> map = new HashMap<>();
        map.put("CA", "California");
        map.put("TX", "Texas");
        map.put("GA", "Georgia");

        System.out.println(map.put("GA", "Georgia123"));

        //System.out.println(map.values());

        map.forEach((k,v) -> System.out.println("Key: " + k + " Value: " + v));

    }

    // [3,5,6,1,2] k=5
    public static void sumEqualsK(Integer[] array, Integer k) {

        if (array == null) {
            return;
        }

        Map<Integer, Integer> result = new HashMap<>();

        // k-i
        for (int i : array) {
            result.put(k - i, i);
        }

        for (int i : array) {
            if (result.containsKey(i)) {
                System.out.println(i + " " + result.get(i));
            }
        }

//        Iterator iterator = result.entrySet().iterator();
//
//        while (iterator.hasNext()) {
//            Map.Entry<Integer, Integer> entry = ((Map.Entry<Integer, Integer>) iterator.next());
//            System.out.println(entry.getKey() + " " + entry.getValue());
//        }
//

//        for (Map.Entry<Integer, Integer> entry: result.entrySet()){
//            System.out.println(entry);
//            System.out.println(entry.getKey() +":"+ entry.getValue());
//        }

        result.forEach((key,value) -> System.out.println(key + "::" + value));


        System.out.println(result.isEmpty());
        System.out.println(result.size());
        System.out.println(result.values());
        result.clear();

    }
}
