import java.util.TreeMap;

public class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        // Build up the alphabet
        TreeMap<Character, Integer> index = new TreeMap<>();
        for(int i = 0; i < order.length(); i++) {
            index.put(order.charAt(i), i);
        }

        // Compare each word.
        search: for(int k = 0; k < words.length - 1; k++) {
            String words1 = words[k];
            String words2 = words[k+1];

            // Find the first difference
            for(int i = 0; i < Math.min(words1.length(), words2.length()); i++) {
                if(words1.charAt(i) != words2.charAt(i)) {
                    if(index.get(words1.charAt(i)) > index.get(words2.charAt(i))) {
                        return false;
                    }
                    continue search;
                }
            }
            // If we didn't find a first difference, the words are like ("app", "apple")
            if (words1.length() > words2.length()) {
                return false;
            }
        }
        return true;
    }
}
// Note: It's faster to use array, though it may be more intuitive to use value-key hash map.
