// Time Complexity : O(m+n) where m is the length of string and n is the length of pattern
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no

class Solution {
    public int strStr(String haystack, String needle) {

        int[] lps = getLps(needle);

        int i=0,j=-1;

        while(i < haystack.length() && j+1<needle.length()){ // need to check if j+1 is in bounds as we are accessing the character at j+1
            char charI = haystack.charAt(i);
            char charJ = needle.charAt(j+1); //get element next to j

            if(charI == charJ){
                i++;j++;
            } else if(j>-1){ // remember to compare agains the -1 not the 0
                j = lps[j]; // move j to the last match
            }
            else{
                i++;
            }
        }

        if(j == lps.length - 1){ // if j is at the last index, then it means it has macthed every chatacter till this point
            return (i- needle.length()); // i  will go one step extra 
        }
        return -1;
        
    }

    private int[] getLps(String pattern){
        int[] lps = new int[pattern.length()];
        lps[0] = -1;
        int i=1;// one step extra
        int j=-1; // we will take an index before 0 because we will be pointing to an element next to j

        while(i<lps.length && j<lps.length){
            // compare both elements
            char charI = pattern.charAt(i);
            char charJ = pattern.charAt(j+1); // always access j's next element'
            if(charI == charJ){
                lps[i] = j+1;
                i++;
                j++;
            } else if(j>-1){
                j = lps[j]; // move back to the last matching position
            }
            else{
               lps[i] = -1; // !!! Very Important !!! , if there is still no match then record the -1 as this position will be where the j is reset to
                i++;
            }
        }

        return lps;
    }
}