// TC: O(N^2) to loop over and generate substrings
// SC: O(1) for constant space complexity

public class strStr {

	public int strSTR(String haystack, String needle) {
		
		if(haystack == "" || needle == "")  // check if the string is null, return 0
			return 0;
		
		int hl = haystack.length(), nl = needle.length();
		
		for(int i=0; i <= (hl-nl);i++) {  // iterate over the different of length both strings
			if(haystack.substring(i, i+nl).equals(needle))  // calculate the substring of length needle in haystack, check if that length of string 
				// is equal to needle string, if not, we move ahead in haystack string using i pointer and checking another substring of length needle, if we find equal string, return that idnex in haystack
				return i;
		}
		return -1;  // if we traverse entire string and dont find the matching string, return -1;
	}
	
	public int strstr(String haystack, String needle) {
		
		if(haystack == "" || needle == "")
			return 0;
		
		int hl = haystack.length();
		int nl = needle.length();
		for(int i=0;i < hl;i++) {
			for(int j=0;j<nl;j++) {
				if(j==nl)   // loop over and check if the length of the needle matches with the index j for needle, we have reached our character matching, we will return index of haystack
					return i;
				if(i+j == hl)  // if at any point, we find the sum of both index is length of haystack, we return -1 since i+j is larger than needle string length, which is invalid
					return -1;
				if(needle.charAt(j) != haystack.charAt(i+j)) {  // if the characters dont match, we start from the next character in haystack and check for the starting characters in needle and keep comparing until we find the length of needle string as j index
					break;
				}
			}
		}
		return -1;
	}
}
