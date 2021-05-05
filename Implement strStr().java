//Time Complexity : O(m+n).m is the length of haystack and n is the length of needle
//Space Complexity : O(n). lps array takes O(n) space.
class Solution {
    public int strStr(String haystack, String needle) {
        if(needle==null||needle.length()==0){
            return 0;
        }
        //build the longest prefix and suffic array
        int[] lps = buildLPS(needle);
        //iterate through haystack
        int i=0,j=0;
        while(i<haystack.length()){
             //if matching
            if(haystack.charAt(i)== needle.charAt(j)){
                i++;
                j++;
                if(j == needle.length()){
                    return i-needle.length();
                }
            }
            //not matching
             else if(j>0 && haystack.charAt(i) != needle.charAt(j)){
                //use the next largerst index
                j = lps[j-1];
            }
            //if nothing is matched and j is at the begining set the logest prefix as zero for thr current character
             else if(j==0 && haystack.charAt(i) != needle.charAt(j)){
                j = 0;
                i++;
            }
        }
        return -1;
    }
    private int[] buildLPS(String needle){
        int lps[] = new int[needle.length()];
        int i=1,j=0;
        while(i<needle.length()){
            //if matching
            if(needle.charAt(i)== needle.charAt(j)){
                j++;
                lps[i] = j;//so far matched prefix characters from the current char
                i++;
            }
            //if not matched try going to the next largest prefix index
            else if(j>0 && needle.charAt(i) != needle.charAt(j)){
                //use the next largerst index
                j = lps[j-1];
            }
            //if nothing is matched and j is at the begining set the logest prefix as zero for thr current character
            else if(j==0 && needle.charAt(i) != needle.charAt(j)){
                lps[i] = 0;
                i++;
            }
        }
        return lps;
    }
}