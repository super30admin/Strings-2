// Time Complexity : The time complexity is O(m*n) where m is the length of String1 and n is the length of string2
// Space Complexity : The space complexity is O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int strStr(String haystack, String needle) {

        int l1 = haystack.length();
        int l2 = needle.length();

        if(l2 == 0){
            return 0;
        }

        if(l1 == 0){
            return -1;
        }

        if(l1 < l2){
            return -1;
        }

        for(int i=0;i<l1-l2+1;i++){

            char c = haystack.charAt(i);

            if(c == needle.charAt(0)){

                int j=i;

                // Find needle in haystack
                for(int k=0;k<l2;k++){

                    if(needle.charAt(k) == haystack.charAt(j)){
                        j++;
                    }
                    else{
                        break;
                    }
                }

                // needle is present in haystack
                if(j == l2+i){
                    return i;
                }
            }
        }

        return -1;

    }
}