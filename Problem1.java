// TC: O(n x m)
// SC: O(1)
class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack == null || needle == null || haystack.length() < needle.length()) return -1;
        int start = 0;
        int end = 0;
        while(end <= haystack.length() - needle.length()){
            if(match(haystack, needle, end)){
                return end;
            }
            end++;
        }
        return -1;
    }
    public boolean match(String haystack, String needle, int index){
            for(int i = 0; i < needle.length(); i++){
                if(haystack.charAt(index + i) != needle.charAt(i)){
                    return false;
                }
            }
            return true;
        }
}
