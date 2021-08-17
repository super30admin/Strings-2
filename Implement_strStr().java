// Time complexity: O(nm)
// Space complexity: O(1)
// Run on leetcode: Yes
// Issues faced: could not come up with this optimization -> slow < m - n + 1

class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        int slow = 0;
        int fast = 0;
        int i = 0;
        
        while(slow < m - n + 1){
            fast = slow;
            while(i < n && fast < m){
                char c = haystack.charAt(fast);
                char ch = needle.charAt(i);
                if(c != ch)
                    break;
                i++;
                fast++;
            }
            if(i == n)
                return slow;
            else{
                i = 0;
                slow++;
            }
        }
        return -1;
    }
}

// Time complexity: O(m) where m is the length of the haystack
// space complexity: O(n)  where n is the length of the needle
// Run on leetcode: yes
// Issues faced: None

class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0 )
            return 0;
        int[] lps = lps(needle);
        int n = needle.length();
        int m = haystack.length();
        int i=0;
        int j=0;
        while(i<m){
            if(needle.charAt(j) == haystack.charAt(i)){
                j++;
                i++;
                if(j == n)
                    return i-n;
            }
            else if(needle.charAt(j) != haystack.charAt(i) && j>0){
                j = lps[j-1];
            }
            else if(needle.charAt(j) != haystack.charAt(i) && j==0){
                i++;
            }
        }
        return -1;
    }
    
    private int[] lps(String needle){
        int n = needle.length();
        int[] lps = new int[n];
        int i=1;
        int j=0;
        while(i<n){
            if(needle.charAt(i) == needle.charAt(j)){
                j++;
                lps[i] = j;
                i++;
            }
            else if(needle.charAt(i) != needle.charAt(j) && j > 0){
                j = lps[j-1];
            }
            else if(needle.charAt(i) != needle.charAt(j) && j == 0){
                lps[i] = 0;
                i++;
            }
        }       
        return lps;
    }
}
