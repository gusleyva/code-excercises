package backtoback.recursion;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

public class PhoneNumberMnemonicTest {
    PhoneNumberMnemonic phoneMnemonics = new PhoneNumberMnemonic();
    @Test
    public void happyPath(){
        List<String> result = phoneMnemonics.solution("43");
        System.out.println("Result size: " + result.size() + ", result: " + result.toString());
        assertNotEquals(0, result.size());

        result = phoneMnemonics.solution("239");
        System.out.println("Result size: " + result.size() + ", result: " + result.toString());
        assertNotEquals(0, result.size());
    }
}
