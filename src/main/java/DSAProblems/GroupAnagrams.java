package DSAProblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    public static void main(String[] args) {
        long timeAtStartingMillis = System.currentTimeMillis();
        long timeAtStartingNanoSeconds = System.nanoTime();
        String[] wordsToGroupAnagrams = {"eat","tea","tan","ate","nat","bat"};
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        System.out.println("Anagram Groups = " + groupAnagrams.groupAnagrams(wordsToGroupAnagrams));
        long timeAtEndingMillis = System.currentTimeMillis();
        long timeAtEndingNanoSeconds = System.nanoTime();
        System.out.println("Time taken to run the program in milli seconds = " + (timeAtEndingMillis - timeAtStartingMillis));
        System.out.println("Time taken to run the program in nano seconds = " + (timeAtEndingNanoSeconds - timeAtStartingNanoSeconds));
    }
    public static Map<Character, Integer> findCharacterCountMap(String word) {
        Map<Character, Integer> characterCountMap = new HashMap<>();
        char[] charArray = word.toCharArray();

        for (int i = 0; i < word.length(); i++) {
            if (!characterCountMap.containsKey(charArray[i])) {
                characterCountMap.put(charArray[i], 0);
            } else {
                characterCountMap.put(charArray[i], characterCountMap.get(charArray[i]) + 1);
            }
        }

        return characterCountMap;


    }

    public static boolean checkIfAnagram(Map<Character, Integer> mainWordMap, Map<Character, Integer> testWordMap, int lengthMainWOrd, int lengthTestWord) {

        if (lengthMainWOrd != lengthTestWord)
            return false;

        for (Character letter : testWordMap.keySet()) {
            if (!mainWordMap.containsKey(letter)) {
                return false;
            } else {
                if (mainWordMap.get(letter) != testWordMap.get(letter))
                    return false;
            }
        }
        return true;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        int[] visitedArray = new int[strs.length];
        List<List<String>> listOfGroupedAnagrams = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            if (visitedArray[i] == 1)
                continue;
            visitedArray[i] = 1;
            List<String> anagramList = new ArrayList<>();
            anagramList.add(strs[i]);
            Map<Character, Integer> mainWordMap = findCharacterCountMap(strs[i]);
            for (int j = i; j < strs.length; j++) {
                if (visitedArray[j] != 1 && checkIfAnagram(mainWordMap, findCharacterCountMap(strs[j]), strs[i].length(), strs[j].length())) {
                    visitedArray[j] = 1;
                    anagramList.add(strs[j]);
                }
            }
            listOfGroupedAnagrams.add(anagramList);
        }

        return listOfGroupedAnagrams;
    }

    public List<List<String>> groupAnagrams2(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if(strs.length==0) return res;
        HashMap<String, List<String>> map = new HashMap();
        for(String s: strs){
            char[] hash = new char[26];
            for(char c: s.toCharArray()){
                hash[c-'a']++;
            }
            String str=new String(hash);
            if(map.get(str)==null){
                map.put(str, new ArrayList<>());
            }
            map.get(str).add(s);
        }
        res.addAll(map.values());
        return res;
    }
}
