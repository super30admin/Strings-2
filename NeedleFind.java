class Solution {
    public int strStr(String haystack, String needle) {
        if(needle == "" || haystack == "") return 0;
        int n = needle.length();
        int h = haystack.length();
        for(int i = 0; i <= h - n; i++){
            if(haystack.substring(i, i + n ).equals(needle)){
            return i;
            }
        }
        return -1;
    }
}


//TC:O(h)
//SC:O(1)

//Here first we will calcualte the length of the two strings, then we will traverse till haystack-needle and compare the substring from the beginning index to the size of needle with  the needle.
