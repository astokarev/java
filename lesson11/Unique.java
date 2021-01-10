package lesson11;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class Unique {
    public static void main(String[] args) {
        String[] words = {"груша", "яблоко", "банан", "ананас", "яблоко", "персик", "ананас",
                "киви", "банан", "апельсин", "персик", "груша" };
        Set<String> uniqKeys = new TreeSet<String>();
        uniqKeys.addAll(Arrays.asList(words));
        System.out.println("uniqKeys: " + uniqKeys);
    }
}
