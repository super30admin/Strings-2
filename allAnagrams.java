// TC: O(n*m) where n is length of s and m is length of p
// SC: O(1)
import java.util.*;

public class allAnagrams {
    public List<Integer> findAnagrams(String s, String p){        
        List<Integer> l = new ArrayList<>();
        int[] sum = new int[27];
        // credit a array which relects each character of p based on its ASCII value
        for(int i=0; i<p.length(); i++){
            sum[p.charAt(i)-96]++;
        }
        
        // Creating sub arrays from s of size p
        for (int i=0; i<(s.length()-p.length()+1); i++){
            int[] temp = new int[27];
            for(int j=i; j<(i+p.length()); j++){
                temp[s.charAt(j)-96]++;
            }
            // if both arrays are equal we add start index of the substring in s 
            if(Arrays.equals(temp, sum))
                l.add(i);
        }        
        return l;
    }
}