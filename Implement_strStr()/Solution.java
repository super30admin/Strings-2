// Time Complexity : O(n + m) where n = length of haystack and m = length of needle
// Space Complexity : O(m)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/**
 * We use LPS array to keep a track of max length of suffix = prefix for substring starting from 0 to m in needle
 * This array allows us to find substring in haystack which matches needle in one pass
 * While iterating over s, we check if char of haystack == char of needle, if yes we continue
 * If no, we go LPS[j-1] that is last location where we found matching character till j >= 0.
 * This allows us to skip intermediate comparrisons starting from each index which we were doing in bruteforce
*/


class Solution {
    public int strStr(String haystack, String needle) {
		if (needle == null || needle.length() == 0)return 0;
		if (haystack == null || haystack.length() == 0 || needle.length() > haystack.length())return -1;
		
        //bruteforce solution
//         int length = haystack.length() - needle.length() + 1;
		
//         for (int i = 0; i < length; i++) {
// 			if (haystack.charAt(i) == needle.charAt(0)) {
// 				String check = haystack.substring(i, i + needle.length());
// 				if (check.equals(needle))return i;
// 			}
// 		}
        
        
        int[] lps = get_lps(needle);
        int j = 0;
        int i = 0;
        
        while(i < haystack.length()){
            if(haystack.charAt(i) == needle.charAt(j)){
                j++;
                i++;
                if(j == needle.length()){
                    return i - needle.length();
                }
            }
            else if(haystack.charAt(i) != needle.charAt(j) && j > 0){
                j = lps[j-1];
            }
             else{
                i++;
            }
        }
        
		return -1;
    }
    
    private int[] get_lps(String needle){
        int[] arr = new int[needle.length()];
        int i = 1;
        int j = 0;
        
        while(i < needle.length()){
            if(needle.charAt(i) == needle.charAt(j)){
                j++;
                arr[i] = j;
                i++;
            }
            else if(needle.charAt(i) != needle.charAt(j) && j > 0){
                j = arr[j-1];
            }else{
                arr[i] = j;
                i++;
            }
        }
        
        return arr;
    }
}