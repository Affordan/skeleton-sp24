import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapExercises {
    /** Returns a map from every lower case letter to the number corresponding to that letter, where 'a' is
     * 1, 'b' is 2, 'c' is 3, ..., 'z' is 26.
     */
    public static Map<Character, Integer> letterToNum() {
        // TODO: Fill in this function.
        Map<Character,Integer> mp = new HashMap<>();
        for(int i=0;i< 26;i++)
        {
            mp.put((char) ('a'+i),i+1);
        }

        return mp;
    }

    /** Returns a map from the integers in the list to their squares. For example, if the input list
     *  is [1, 3, 6, 7], the returned map goes from 1 to 1, 3 to 9, 6 to 36, and 7 to 49.
     */
    public static Map<Integer, Integer> squares(List<Integer> nums) {
        // TODO: Fill in this function.
        Map<Integer,Integer> mp =new HashMap<>();
        for(var n:nums)
        {
            mp.put(n,n*n);
        }
        return mp;
    }

    /** Returns a map of the counts of all words that appear in a list of words. */
    public static Map<String, Integer> countWords(List<String> words) {
        // TODO: Fill in this function.
       Map<String,Integer> mp =new HashMap<>();
       for(var w:words)
       {
           mp.put(w,mp.getOrDefault(w,0)+1);
       }

        return mp;
    }
}
