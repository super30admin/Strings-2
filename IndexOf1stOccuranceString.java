// Time Complexity : O(M+N) where M is haystack size and N is needle size
// Space Complexity: O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach:
/*
Kuth morris pratt algorithm. First using the needle String, form the lps (longest prefix equal to suffix) array
next, match the characters of needle and haystack. if not matched, move jth pointer based on lps array
* */
public class IndexOf1stOccuranceString {
    public int strStr(String haystack, String needle) {
        //O(N) Kuth morris pratt

        //calculate the lps (longest prefix==suffix) array
        int n=needle.length(), m=haystack.length();
        int i=1,j=0;
        int[] lps= new int[n];
        while(i<n){
            if(needle.charAt(i)==needle.charAt(j)){
                j++;
                lps[i]=j;
                i++;
            } else if(needle.charAt(i)!=needle.charAt(j) && j!=0){
                j=lps[j-1];
            }else if(needle.charAt(i)!=needle.charAt(j) && j==0){
                lps[i]=0;
                i++;
            }
        }

        i=0;
        j=0;
        //check between needle and haystack
        while(i<m){
            if(needle.charAt(j)==haystack.charAt(i)){
                i++;
                j++;
                if(j==n) return i-n;
            }else if(j!=0){
                j=lps[j-1];
            }else{
                i++;
            }
        }

        return -1;
    }
}
