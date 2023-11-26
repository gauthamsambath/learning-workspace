package Blind75;

import java.util.*;

/**
 * The type Word break.
 */
public class WordBreak {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        String s = "catsandog";
        List<String> wordDict = Arrays.asList("cats", "dog", "sand", "and", "cat");
        WordBreak wordBreak = new WordBreak();
        System.out.println("The word " + s + " " + (wordBreak.wordBreak(s, wordDict) ? "can be " : "cannot be ") + "segmented by the words in the dictionary");
    }

    /**
     * Word break boolean.
     *
     * @param s        the s
     * @param wordDict the word dict
     * @return the boolean
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        Map<Integer, HashSet<String>> wordLengthMap = createWordLengthMap(wordDict);
        boolean[] dp = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j >= 0; j--) {
                int subLength = s.substring(j, i + 1).length();
                if (wordLengthMap.containsKey(subLength) && wordLengthMap.get(subLength).contains(s.substring(j, i + 1))) {
                    if (j == 0)
                        dp[i] = true;
                    else if (dp[j - 1]) {
                        dp[i] = true;
                    }

                }
            }
        }
        return dp[s.length() - 1];
    }

    /**
     * Create word length map map.
     *
     * @param wordDict the word dict
     * @return the map
     */
    private Map<Integer, HashSet<String>> createWordLengthMap(List<String> wordDict) {
        Map<Integer, HashSet<String>> wordLengthMap = new HashMap<>();
        for (String word : wordDict) {
            int lengthOfWord = word.length();
            if (wordLengthMap.containsKey(lengthOfWord)) {
                wordLengthMap.get(lengthOfWord).add(word);
            } else {
                wordLengthMap.put(lengthOfWord, new HashSet<>());
                wordLengthMap.get(lengthOfWord).add(word);
            }
        }
        return wordLengthMap;
    }
}
