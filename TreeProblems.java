/*
 * *** BEN FLOWERS / COMP 272/400C 002 ***
 *
 * This java file contains several simple tree problems that need to be
 * codified. These routines  must use the TreeMap and TreeSet library
 * classes from the Java Collection Framework.
 *
 */

import java.util.*;

public class TreeProblems {

    /**
     * Method different()
     *
     * Given two TreeSets of integers, return a TreeSet containing all elements
     * that are NOT in both sets. In other words, return a TreeSet of all the
     * elements that are in one set but not the other.
     */

    public static Set<Integer> different(Set<Integer> setA, Set<Integer> setB) {

        Set<Integer> result = new TreeSet<>();
        Set<Integer> tempSetA = new TreeSet<>(setA);
        Set<Integer> tempSetB = new TreeSet<>(setB);

        // add all elements from both sets to result
        result.addAll(tempSetA);
        result.addAll(tempSetB);

        Set<Integer> intersection = new TreeSet<>(tempSetA);
        intersection.retainAll(tempSetB);


        result.removeAll(intersection);

        return result;
    }


    /**
     * Method removeEven()
     *
     * Given a treeMap with the key as an integer, and the value as a String,
     * remove all <key, value> pairs where the key is even.
     */

    public static void removeEven(Map<Integer, String> treeMap) {
        // create a set of keys to remove to avoid exception
        Set<Integer> keysToRemove = new HashSet<>();

        for (Integer key : treeMap.keySet()) {
            if (key % 2 == 0) {
                keysToRemove.add(key);
            }
        }

        for (Integer key : keysToRemove) {
            treeMap.remove(key);
        }
        // return;
    }


    /**
     * Method treesEqual()
     *
     * Given two treeMaps, each with the key as an integer, and the value as a String,
     * return a boolean value indicating if the two trees are equal or not.,
     */

    public boolean treesEqual(Map<Integer, String> tree1,Map<Integer, String> tree2 ) {

        if (tree1.size() != tree2.size()) {
            return false;
        }

        for (Map.Entry<Integer, String> entry : tree1.entrySet()) {
            // get key + value from tree1
            Integer key = entry.getKey();
            String value = entry.getValue();

            // check if tree2 has the same key
            if (!tree2.containsKey(key)) {
                return false;
            }

            if (!value.equals(tree2.get(key))) {
                return false;
            }
        }

        return true;

    }

} // end treeProblems class
