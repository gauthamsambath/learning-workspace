package Blind75;

import java.util.*;

/**
 * The type Course schedule.
 */
public class CourseSchedule {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        int[][] prerequisites = {{1, 4}, {2, 4}, {3, 1}, {3, 2}};
        int numCourses = 20;
        CourseSchedule courseSchedule = new CourseSchedule();
        System.out.println("The student " + (courseSchedule.canFinish(numCourses, prerequisites) ? "can" : "cannnot") + " complete all the courses");
    }

    /**
     * Can finish boolean.
     *
     * @param numCourses    the num courses
     * @param prerequisites the prerequisites
     * @return the boolean
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> mapOfRequirements = createMapOfRequirements(prerequisites);
        Set<Integer> setOfDuplicates = new HashSet<>();
        boolean canComplete = true;
        for (int i = 0; i < prerequisites.length; i++) {
            if (prerequisites[i][0] == 5){
                System.out.println("I am here");
            }
            setOfDuplicates.add(prerequisites[i][0]);
            canComplete = !isCyclic(setOfDuplicates, mapOfRequirements, prerequisites[i][0]);
            if (!canComplete)
                break;
            setOfDuplicates.remove(prerequisites[i][0]);
        }
        return canComplete;
    }

    /**
     * Is cyclic boolean.
     *
     * @param setOfDuplicates   the set of duplicates
     * @param mapOfRequirements the map of requirements
     * @param value             the value
     * @return the boolean
     */
    private boolean isCyclic(Set<Integer> setOfDuplicates, Map<Integer, List<Integer>> mapOfRequirements, int value) {
        if (!mapOfRequirements.containsKey(value)) {
            return false;
        }
        boolean isCylic = false;
        List<Integer> listOfRequirements = new ArrayList<>();
        for (int i = 0; i < mapOfRequirements.get(value).size(); i++) {
            listOfRequirements = new ArrayList<>(mapOfRequirements.get(value));
            if (setOfDuplicates.add(listOfRequirements.get(i))) {
                isCylic = isCyclic(setOfDuplicates, mapOfRequirements, listOfRequirements.get(i));
                if (!isCylic) {
                    setOfDuplicates.remove(listOfRequirements.get(i));
                    listOfRequirements.remove(i);
                } else {
                    return true;
                }
            } else {
                return true;
            }
        }
        mapOfRequirements.put(value, listOfRequirements);
        return isCylic;
    }

    /**
     * Create map of requirements map.
     *
     * @param prerequisites the prerequisites
     * @return the map
     */
    private Map<Integer, List<Integer>> createMapOfRequirements(int[][] prerequisites) {
        Map<Integer, List<Integer>> mapOfRequirements = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            if (mapOfRequirements.containsKey(prerequisites[i][0])) {
                mapOfRequirements.get(prerequisites[i][0]).add(prerequisites[i][1]);
            } else {
                List<Integer> listOfRequirements = new ArrayList<>();
                listOfRequirements.add(prerequisites[i][1]);
                mapOfRequirements.put(prerequisites[i][0], listOfRequirements);
            }
        }
        return mapOfRequirements;
    }
}
