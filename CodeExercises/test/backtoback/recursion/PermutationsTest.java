package backtoback.recursion;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.Test;


public class PermutationsTest {
    
    Permutations permutations = new Permutations();
    @Test
    public void happyPath(){
        int[] input = new int[]{1,2,3};
        List<List<Integer>> result = permutations.permute(input);
        System.out.println("result size: " + result.size() + ", result: " + result.toString());
        assertNotEquals(0, result.size());
    }
}
