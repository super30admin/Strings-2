class Solution {
    public int strStr(String haystack, String needle) {
        int lps[] = new int[needle.length()];

        int m = 0;
        int i = 1;
        while(i<needle.length())
            if(needle.charAt(i) == needle.charAt(m))
                lps[i++] = ++m;
            else if (m!=0){
                m = lps[m-1];
            }
            else
                lps[i++] = 0;


        int j = 0;
        i = 0;
        while(i<haystack.length()&&j<needle.length()){
            if(haystack.charAt(i) == needle.charAt(j)){
                j++;
                i++;
            }
            else if (j!=0){
                j = lps[j-1];
            }
            else{
                i++;
            }
        }
        if(j==needle.length())
            return i-needle.length();
        return -1;
    }
}