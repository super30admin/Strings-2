package s30.strings.s2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Algo: optimizing the bruteforce approach of finding substrings start with all characters of the string
//Add the incoming character count and remove the outgoing character count.
//match with the original anagram characters count

//TC: O(n) length of the input string.
//SC: O(1)
public class FindAllAnagrams {

    public List<Integer> findAnagrams(String s, String p) {

        int[] anagram = new int[26];
        int[] input = new int[26];

        for(int i =0; i < p.length(); i++){
            char ch = p.charAt(i);
            anagram[ch - 'a'] +=1;
        }

        int end =0;

        List<Integer> res = new ArrayList();

        while(end < s.length()){
            char ch = s.charAt(end);

            if(end >= p.length()){
                char c = s.charAt(end - p.length());
                input[ c - 'a'] -= 1;
            }

            input[ch - 'a'] +=1;

            if(Arrays.equals(input, anagram)) res.add( end - p.length() +1);

            end++;
        }


        return res;
    }
    public static void main(String[] args) {

    }
}
