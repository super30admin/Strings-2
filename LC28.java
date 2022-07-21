// Time Complexity : O(n + m)
// Space Complexity : O(m)

class Solution {
    public int strStr(String haystack, String needle) {
        
        if (needle == null || needle.length() == 0) return 0;
		if (haystack == null || haystack.length() == 0 || needle.length() > haystack.length()) return -1;


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