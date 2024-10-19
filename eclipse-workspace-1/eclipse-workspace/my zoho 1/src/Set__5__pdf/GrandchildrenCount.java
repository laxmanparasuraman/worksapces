package Set__5__pdf;

//public class lll {
//
//}
//import java.util.*;
//import java.util.*;
//import java.util.*;
//
//import java.util.*;
////
//import java.util.*;

import java.util.*;
import java.util.Map.Entry;

public class GrandchildrenCount {
    public static void main(String[] args) {
        Map<String, String> relationshipMap = new HashMap<>();
        relationshipMap.put("luke", "shaw");
        relationshipMap.put("wayne", "rooney");
        relationshipMap.put("rooney", "ronaldo");
        relationshipMap.put("shaw", "rooney");

        String valueToFind = "ronaldo";
        String keyForValue = getKeyForValue(relationshipMap, valueToFind);

        if (keyForValue != null) {
          //  int rooneyCount = countValueOccurrences(relationshipMap, "rooney");keyForValue
        	   int rooneyCount = countValueOccurrences(relationshipMap, keyForValue);//keyForValue
            System.out.println("Key associated with value " + valueToFind + ": " + keyForValue);
            System.out.println("Number of times 'rooney' appears as a value: " + rooneyCount);
        } else {
            System.out.println("Value not found in the map.");
        }
    }

    public static <K, V> K getKeyForValue(Map<K, V> map, V valueToFind) {
        for (Entry<K, V> entry : map.entrySet()) {
            if (entry.getValue().equals(valueToFind)) {
                return entry.getKey();
            }
        }
        return null; // Value not found in the map
    }

   public static <K,V>int countValueOccurrences(Map<K, V> map, V valueToCount) {
    	//public static int countValueOccurrences(Map map,  String valueToCount) {// <K, V>Map<K, V>
    	    
        int count = 0;
        for (V value : map.values()) {
            if (value.equals(valueToCount)) {
                count++;
            }
        }
        return count;
    }
}

/*public class GrandchildrenCount {
    public static void main(String[] args) {
        String[][] relationships = {
            {"luke", "shaw"},
            {"wayne", "rooney"},
            {"rooney", "ronaldo"},
            {"shaw", "rooney"}
        };
        String personToFind = "ronaldo";

        Map<String, String> childToParent = new HashMap<>();
        for (String[] relation : relationships) {
            childToParent.put(relation[0], relation[1]);
        }

        int grandchildrenCount = countGrandchildren(childToParent, personToFind);
        System.out.println("Number of grandchildren of " + personToFind + ": " + grandchildrenCount);
    }

    static int countGrandchildren(Map<String, String> childToParent, String person) {
        int count = 0;
        if (childToParent.containsKey(person)) {
            String parent = Interperson.getkey();
            for (String grandchild : childToParent.keySet()) {
                if (childToParent.get(grandchild).equals(person)) {
                    count += countGrandchildren(childToParent, grandchild) + 1;
                }
            }
        }
        return count;
    }
}

public class GrandchildrenCount {
    public static void main(String[] args) {
        String[][] relationships = {
            {"luke", "shaw"},
            {"wayne", "rooney"},
            {"rooney", "ronaldo"},
            {"shaw", "rooney"}
        };
        String personToFind = "ronaldo";

        Map<String, List<String>> childToGrandchildren = new HashMap<>();
        for (String[] relation : relationships) {
            childToGrandchildren.putIfAbsent(relation[0], new ArrayList<>());
            if (childToGrandchildren.containsKey(relation[1])) {
                childToGrandchildren.get(relation[1]).add(relation[0]);
            }
        }

        int grandchildrenCount = countGrandchildren(childToGrandchildren, personToFind);
        System.out.println("Number of grandchildren of " + personToFind + ": " + grandchildrenCount);
    }

    static int countGrandchildren(Map<String, List<String>> childToGrandchildren, String person) {
        int count = 0;
        if (childToGrandchildren.containsKey(person))
        {
        	 Map<String, List<String>> childToParent;
			String parent = childToParent.get(person);
            for (String child : childToGrandchildren.get(person)) {
                count += countGrandchildren(childToGrandchildren, child) + 1;
            }
        }
        return count;
    }
}

public class GrandchildrenCount {
    public static void main(String[] args) {
        String[][] relationships = {
            {"luke", "shaw"},
            {"wayne", "rooney"},
            {"rooney", "ronaldo"},
            {"shaw", "rooney"}
        };

        String personToFind = "ronaldo";
        int grandchildrenCount = findGrandchildrenCount(relationships, personToFind);
        System.out.println("Number of grandchildren of " + personToFind + ": " + grandchildrenCount);
    }

    static int findGrandchildrenCount(String[][] relationships, String person) {
        Map<String, Integer> childToGrandchildrenCount = new HashMap<>();
        Map<String, String> childToParent = new HashMap<>();

        for (String[] relation : relationships) {
            String child = relation[0];
            String parent = relation[1];
            childToParent.put(child, parent);
        }

        for (String[] relation : relationships) {
            String child = relation[0];
            String parent = relation[1];
            int parentCount = childToGrandchildrenCount.getOrDefault(parent, 0);
            int childCount = childToGrandchildrenCount.getOrDefault(child, 0);
            childToGrandchildrenCount.put(child, parentCount + childCount + 1);
        }

        return childToGrandchildrenCount.getOrDefault(person, 0);
    }
}
*/