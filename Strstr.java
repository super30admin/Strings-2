
class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length()==0) return 0;
        int m = haystack.length(); int n=needle.length();
        int i=0;
        while(i<haystack.length()- needle.length()+1){
            if(haystack.charAt(i) == needle.charAt(0)){
                int k=i;
                int j=0;
                while(j<needle.length() && k<haystack.length() && haystack.charAt(k) == needle.charAt(j)){
                    k++; j++;
                    if(j==needle.length()) return i;
                }
            }
            i++;
        }
        return -1;
    }
}
