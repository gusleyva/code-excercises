package backtoback.recursion;

import java.util.ArrayList;
import java.util.List;

public class PermutationsV2 {

    public List<String> permute(String input){
        List<String> result = new ArrayList<>();

        permutation(new ArrayList<>(), input, result);

        return result;
    }

    protected void permutation(
        List<Character> partialPermutation,
        String input,
        List<String> result
    ){
        //Goal
        if(partialPermutation.size() == input.length()){
            result.add(partialPermutation.toString());
            return;
        }

        for(int idx = 0; idx < input.length(); idx++){
            Character letter = input.charAt(idx);

            //Without duplicate chars - aaa, aab, aba... bbb.. ccc
            if(partialPermutation.contains(letter)){
                continue;
            }

            partialPermutation.add(letter); //choose
            permutation(partialPermutation, input, result);
            partialPermutation.remove(partialPermutation.size() - 1);
            //partialPermutation.deleteCharAt(partialPermutation.length() - 1);
        }
    }
    
}
