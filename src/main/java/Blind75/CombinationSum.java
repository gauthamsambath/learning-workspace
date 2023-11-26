package Blind75;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Combination sum.
 */
public class CombinationSum {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        CombinationSum combinationSum = new CombinationSum();
        System.out.println("Unique combinations of the number summing up to the target " + target + " is equal to " + combinationSum.combinationSum(candidates, target));
    }

    /**
     * Combination sum list.
     *
     * @param candidates the candidates
     * @param target     the target
     * @return the list
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> listOfCombinations = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        dfs(candidates, target, listOfCombinations, 0, combination, 0);
        return listOfCombinations;
    }

    public int[][] returnArray(){
        return new int[2][3];
    }

    /**
     * Dfs.
     *
     * @param candidates         the candidates
     * @param target             the target
     * @param listOfCombinations the list of combinations
     * @param i                  the
     * @param currentList        the current list
     * @param total              the total
     */
    private void dfs(int[] candidates, int target, List<List<Integer>> listOfCombinations, int i, List<Integer> currentList, int total) {
        if (total == target) {
            listOfCombinations.add(new ArrayList<>(currentList));
            return;
        }

        if (total > target || i > candidates.length-1)
            return;

        currentList.add(candidates[i]);
        dfs(candidates, target, listOfCombinations, i, currentList, total + candidates[i]);
        currentList.remove(currentList.size() - 1);
        dfs(candidates, target, listOfCombinations, i + 1, currentList, total);
    }
}
