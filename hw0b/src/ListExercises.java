import edu.princeton.cs.algs4.In;

import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.math.MathContext;


public class ListExercises {

    /**
     * Returns the total sum in a list of integers
     */
    public static int sum(List<Integer> L) {
        // TODO: Fill in this function.
        int sum = 0;

        if (L.size() != 0) {
            for (var num : L)
                sum += num;
        }
        return sum;
    }

    /**
     * Returns a list containing the even numbers of the given list
     */
    public static List<Integer> evens(List<Integer> L) {
        // TODO: Fill in this function.
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < L.size(); i++) {
            if ((i & 1) != 0)
                res.add(L.get(i));
        }
        return res;
    }

    /**
     * Returns a list containing the common item of the two given lists
     */
    public static List<Integer> common(List<Integer> L1, List<Integer> L2) {
        // TODO: Fill in this function.

        //Using set to compute the common value of 2 list
//        List<Integer> res = new ArrayList<>(new HashSet<>(L1)&new HashSet<>(L2));
        List<Integer> res = new ArrayList<>(L1);
        res.retainAll(L2);
        return res;
    }


    /**
     * Returns the number of occurrences of the given character in a list of strings.
     */
    public static int countOccurrencesOfC(List<String> words, char c) {
        // TODO: Fill in this function.
        int res = 0;

        res = (int) words.stream()
                .flatMapToInt(String::chars)
                .filter(ch -> ch == c)
                .count();

        return res;
    }
}
