// Leetcode : 28 - Implement strStr()

class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack.length() == 0 && needle.length() == 0){
            return 0;
        }
        String cur = "";
        int lt = needle.length();
        for(int i=0; i<haystack.length() - lt+1; i++){
            cur = haystack.substring(i, i+lt);
            if(cur.equals(needle)){
                return i;
            }
        }
        return -1;
    }
}