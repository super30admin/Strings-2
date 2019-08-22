// idea is to  chek all combinations of substrings of length second string present in first string or not . if yes then store starting index of substring into list.
//used int array to store characters of first string as index and no of occurances as value.
//iterate over second string and check weather character is present in array or not . 
//and reduce occurrence by 1 . if occurrence is less than 0 it means character not present.

//tc:o(m*n) where m is length of first string and n is length of p
//sc:o(n)
import java.util.ArrayList;
import java.util.List;

public class FindAllAnagram {
	    public static List<Integer> findAnagrams(String s, String p) {
	        List<Integer> res = new ArrayList<>();
	        if (p == null || s == null || s.length() < p.length()) return res;
	        int m = s.length(), n = p.length();
	        //iterate over first string and checking substring is equal to second string or not
	        for (int i = 0; i < m-n+1; i++) {
	            String cur = s.substring(i, i+n);
	            if (helper(cur, p)) res.add(i); // helper function to check equality
	        }
	        return res;
	    }
	    public static boolean helper(String a, String b) {
	        if (a == null || b == null || a.length() != b.length()) return false;
	        int[] dict = new int[26];
	        
	        //put characters of first string into array as index and its' value as no of occurances
	        for (int i = 0; i < a.length(); i++) {
	            char ch = a.charAt(i);
	            dict[ch-'a']++;
	        }
	        for (int i = 0; i < b.length(); i++) {
	            char ch = b.charAt(i);
	            dict[ch-'a']--;  //reduce occurrences by 1 in array
	            if (dict[ch-'a'] < 0) return false;
	        }
	        return true;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "cbaebabacd";
		String p = "abc";
		List<Integer> result = findAnagrams(s, p);
		System.out.print(result);
		
	}

}


