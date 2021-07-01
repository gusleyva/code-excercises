package backtoback.recursion;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

public class PermutationV2Test {
    
    PermutationsV2 permutations = new PermutationsV2();
    @Test
    public void happyPath(){
        List<String> result = permutations.permute("abc");
        System.out.println("result: " + result.toString());
        assertTrue(result.size() > 3);
    }
}
