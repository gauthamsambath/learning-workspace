package Leetcode;

import java.util.*;

public class WordBreak {

    public static void main(String[] args) {
        String[] listOfDictinoryWords = new String[]{"cat", "and", "dog", "an"};
        String wordTarget = "catanddog";
        boolean truthFlag = findIfTargetWordCanBeMadeFromDictionaryOfWords(listOfDictinoryWords, wordTarget);
        System.out.println("The Word " + wordTarget + (truthFlag ? " can be " : " cannot be ") + "made from the words in dictionary");

    }

    private static boolean findIfTargetWordCanBeMadeFromDictionaryOfWords(String[] listOfDictinoryWords, String wordTarget) {
        Map<Integer, List<String>> wordLengthMap = new HashMap<>();
        for (String word : listOfDictinoryWords) {
            if (!wordLengthMap.containsKey(word.length())) {
                wordLengthMap.put(word.length(), new ArrayList<>());
                wordLengthMap.get(word.length()).add(word);
            } else {
                wordLengthMap.get(word.length()).add(word);
            }
        }
        return true;

//        List<Integer> listOfIntToFormTarget = (List<Integer>) wordLengthMap.keySet();
//        ArrayList<ArrayList<Integer>> combinations = getAllCombinations((ArrayList<Integer>) listOfIntToFormTarget,wordTarget.length());
//        for (ArrayList<Integer> combination:combinations){
//            for (Integer keyvalue:
//                 ) {
//
//
    }

    public static ArrayList<ArrayList<Integer>> getAllCombinations(ArrayList<Integer> arr, int sum) {
        ArrayList<ArrayList<Integer> > ans
                = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();

        // first do hashing since hashset does not always
        // sort
        //  removing the duplicates using HashSet and
        // Sorting the arrayList

        Set<Integer> set = new HashSet<>(arr);
        arr.clear();
        arr.addAll(set);
        Collections.sort(arr);

        findNumbers(ans, arr, sum, 0, temp);
        return ans;
    }

    private static void findNumbers(ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> arr, int sum, int index, ArrayList<Integer> temp) {
        if (sum == 0) {

            // Adding deep copy of list to ans

            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i = index; i < arr.size(); i++) {

            // checking that sum does not become negative

            if ((sum - arr.get(i)) >= 0) {

                // adding element which can contribute to
                // sum

                temp.add(arr.get(i));

                findNumbers(ans, arr, sum - arr.get(i), i,
                        temp);

                // removing element from list (backtracking)
                temp.remove(arr.get(i));
            }
        }
    }
}
