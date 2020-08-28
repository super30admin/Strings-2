/****************************************Brute Force*****************************************/
// Time Complexity : O(m * n), length of haystack and needle
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**Find the substring of needle's length in haystack 
 * and check if it's equal to needle */

  class Solution {
    public int strStr(String haystack, String needle) {
        for(int i=0; i<haystack.length() - needle.length() + 1; i++){
            if(haystack.substring(i, i + needle.length()).equals(needle))
                return i;
        }
        return -1;
    }
}

/***************************************Brute Force********************************************/
//Time Complexity : O(m * n), length of haystack and needle
//Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Implement_strStr_BruteForce {
	public int strStr(String haystack, String needle) {
		if(needle.length() == 0) 
			return 0;
		int m = haystack.length();
		int n= needle.length();
		if(m < n)
			return -1;
		int i=0, j =0;
		while(i < m){
			if(haystack.charAt(i) == needle.charAt(j)){ //if we find a match 
				int temp = i;   //initialize temp at i and move temp to find the rest of match
				while(temp < m && j < n){   // till both are within the length of strings
					if(haystack.charAt(temp) == needle.charAt(j)){  // if matches
						temp++;
						j++;
					}
					else
						break;
				}
				if(j == n)  // if j's last character matched and then j has increased one more than that
					return i;   //return the start of string denoted by i
			}
			i++;     //incraese i to start checking for another substring
			j=0;    //reset j
		}
		return -1;
	}
}

/***************************************KMP Algorithm********************************************/
//Time Complexity : O(m + n), length of haystack and needle
//Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class Implement_strStr {
	public int strStr(String haystack, String needle) {
		if(needle.length() == 0) 
			return 0;
		int m = haystack.length();
		int n= needle.length();
		if(m < n)
			return -1;
		int i=0, j =0;
		int[] lps=lps(needle);  //O(n)
		while(i < m){   //till i has traversed the whole haystack string, same as lps
			if(haystack.charAt(i) == needle.charAt(j)){ // if there is match with needle 
				i++;
				j++;

				if(j == n)  // if needle has been traversed fully
					return i-n; // return the starting index
			}
			else if(i < m && j > 0 && haystack.charAt(i) != needle.charAt(j))   // if they dont match and there is a prefix suffix 
				j= lps[j-1];    // move j to position till where we have a match
			else if(i < m && j == 0 && haystack.charAt(i) != needle.charAt(j))  // if no match and j is zero i.e no match previously
				i++;    //move to next character of haystack
		}
		return -1;
	}
	private int[] lps(String needle){
		int[] lps = new int[needle.length()];   //longest prefix suffix matched array
		lps[0] = 0; // for one character prefix, suffix matched are zero
		int i=1, j=0;   // start i at one to compare, both i and j on needle
		while(i < needle.length()){  //till i has traversed the whole needle string
			//case1
			if(needle.charAt(i) == needle.charAt(j)){    // if characters match
				j++;    //increase the prefix suffix window
				lps[i] = j; // put j value in lps array for ith character
				i++;    //increment i
			}
			//case2
			else if(j > 0 && needle.charAt(i) != needle.charAt(j)){ // if they dont match and there is a prefix suffix
				j=lps[j-1]; // move j to position till where we have a match
			}
			//case3
			else if(j == 0 && needle.charAt(i) != needle.charAt(j)){     // if no match and j is zero i.e no match previously
				lps[i] = 0;  // put match as zero
				i++;    // go to next character
			}
		}
		return lps;
	}
}