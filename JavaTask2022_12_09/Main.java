package JavaTask2022_12_09;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("a", "hi");
        map.put("b", "there");
        map.put("c", "hello");
        map.put("d", "world");

        System.out.println(ab(map, "a", "b"));
    }

    public static Map<String, String> ab(Map<String, String> map, String firstKey, String secondKey) {
        if (map.containsKey(firstKey) && map.containsKey(secondKey)) {
            map.put(firstKey + secondKey, map.get(firstKey) + " " + map.get(secondKey));
        }

        return map;
    }
}
