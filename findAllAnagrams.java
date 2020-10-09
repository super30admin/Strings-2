// TC: O(N+M) where M is length of p String and N is length of s String
// SC: O(1) for constant space
// We are storing the count of p array so that we can compare the count of character Integer value with the s string.
// We are storing the count of the s characters array integer value. If index of i is greater than length of p array, we need to remove the characaters from the start
// we compare the count of both the array, if its equal, we will update our result with the index of i and length of p string.
import java.util.*;

public class findAllAnagrams {

	public List<Integer> findAnagrams(String s, String p){
		
		int ns = s.length();
		int np = p.length();
		int[] pCnt = new int[26];
		int[] sCnt = new int[26];
		if(ns < np)
			return new ArrayList<>();
		
		List<Integer> res = new ArrayList<>();
		
		for(char ch: p.toCharArray()) {
			pCnt[(int)ch-'a']++;
		}
		
		for(int i =0;i < ns;i++) {
			sCnt[(int)s.charAt(i)-'a']++;
			if(i >= np) {
				sCnt[(int)(s.charAt(i-np)-'a')]--;
			}
			
			if(Arrays.equals(pCnt, sCnt)) {
				res.add(i-np+1);
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		
		findAllAnagrams faa = new findAllAnagrams();
		String s = "cbaebabacd";
		String p = "abc";
		System.out.println(faa.findAnagrams(s, p));
		
	}
}
