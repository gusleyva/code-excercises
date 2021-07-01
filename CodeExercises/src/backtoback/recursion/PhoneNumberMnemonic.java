package backtoback.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneNumberMnemonic {

    Map<Character, String> numberMnemonics = new HashMap<>();
    { numberMnemonics.put('0', "");
    numberMnemonics.put('1', "");
    numberMnemonics.put('2', "abc");
    numberMnemonics.put('3', "def");
    numberMnemonics.put('4', "ghi");
    numberMnemonics.put('5', "jkl");
    numberMnemonics.put('6', "mno");
    numberMnemonics.put('7', "pqrs");
    numberMnemonics.put('8', "tuv");
    numberMnemonics.put('9', "wxyz");}

    //43
    public List<String> solution(String input){
        List<String> mnemonics = new ArrayList<>();
        generateMnemonic(0, new StringBuilder(), input, mnemonics);
        return mnemonics;
    }

    //Solve problem down
    public void generateMnemonic(
        int currentDigit,
        StringBuilder partialMnemonics,
        String input,
        List<String> mnemonics
    ){
        if(partialMnemonics.length() == input.length()){ //Base case - Goal
            mnemonics.add(partialMnemonics.toString());
            return;
        }

        Character digit = input.charAt(currentDigit); //4 = 43
        String pad = numberMnemonics.get(digit); //ghi

        for(char letter: pad.toCharArray()){ //Choice: One of our chars posibilities - Exploration
            partialMnemonics.append(letter); //Decision
            generateMnemonic(currentDigit + 1, partialMnemonics, input, mnemonics); //Constraints - state change, currentDigit add 1
            partialMnemonics.deleteCharAt(partialMnemonics.length() - 1); //Undo our decision
        }
    }
}