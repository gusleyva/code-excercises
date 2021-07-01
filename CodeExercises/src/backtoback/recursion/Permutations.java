package backtoback.recursion;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    
    public List<List<Integer>> permute(int[] originalArray) {
        List<List<Integer>> allPermutations = new ArrayList<>();

        generateAllPermutations(new ArrayList<>(), originalArray, allPermutations);
        return allPermutations;
    }

    public void generateAllPermutations(
        List<Integer> runningChoices,
        int[] originalArray,
        List<List<Integer>> allPermutations
    ){

        if(runningChoices.size() == originalArray.length){
            allPermutations.add(new ArrayList<>(runningChoices));
            System.out.println("allPermutations: " + allPermutations.toString());
            return;
        }

        for(int i = 0; i < originalArray.length; i++){
            int choice = originalArray[i];
            System.out.println("New iteration choice: " + choice);

            if(runningChoices.contains(choice)){
                continue;
            }

            //1) Add
            runningChoices.add(choice);
            System.out.println("choice: " + choice + ", runningChoices: " + runningChoices.toString());
            //2) Explore - Recurse the choice
            generateAllPermutations(runningChoices, originalArray, allPermutations);

            // 3.) Unchoose - We have returned from the recursion, remove the choice we made.
            // The next iteration will try another item in the "slot" we are working on.
            System.out.println("runningChoices before remove: " + runningChoices.toString() + ", size: " + runningChoices.size());
            runningChoices.remove(runningChoices.size() - 1);
            System.out.println("runningChoices after remove: " + runningChoices.toString() + ", size: " + runningChoices.size());
        }
    }

}
