import java.util.ArrayList;
import java.util.List;

public class TestStrings2Problems {
    public static void main(String[] args) {
        AnagramsInAString anagramsInAString = new AnagramsInAString();
        List<Integer> list = anagramsInAString.findAnagrams("cbaebabacd","abc");
        System.out.println(list);
        //Test if string needle is part of string HayStack
        System.out.println("First Occurance of string is " + new FirstOccuranceOfAString().strStr("sadbutsad","sad"));
    }
}
