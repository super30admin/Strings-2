# Time complexity:O(m+n)
# Space complexity: 0(m)
# Did code run successfully on leetcode: yes
# Any problem you faced: No









class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0){
            return 0;
        }

        int n = haystack.length();
        int m = needle.length();

        int[] pi = computePI(needle);

        int i = 0, j = 0;

        while(i < n){
            if(haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;


                if(j == m){
                   return i - j;
                }
            } else {

                if(j == 0){
                    i++;
                }
                else{
                    j = pi[j - 1];

                }
            }
        }
        return -1;

    }



    private int[] computePI(String pattern){

        int n = pattern.length();
        int[] pi = new int[n];
        pi[0] = 0;
        int j = 0;
        int i = 1;
        while(i < n){
            if(pattern.charAt(i) == pattern.charAt(j)){
                j++;
                pi[i] = j;
                i++;
            }

            else {
                if(j == 0){
                     pi[i] = 0;
                     i++;
                }
                else{
                    j =pi[j - 1];
                }


            }
        }
        return pi;

    }
}