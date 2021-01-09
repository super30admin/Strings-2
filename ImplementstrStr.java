// Time Complexity : O(m) for computing LPS O(n) for traversing the haystack. m = length of needle. n = length of haystack.
// Space Complexity :O(m)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :  No


// Your code here along with comments explaining your approach:
class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack==null && needle==null)
            return 0;
        int hl = haystack.length();
        int nl = needle.length();
        if( nl==0)
            return 0;
        int j=0;int result=-1;
        int[] lps = new int[nl];
        compute(needle,lps);
        int i=0;
        while(i<hl){            
                    //System.out.println(i+" "+j);
            if(haystack.charAt(i)==needle.charAt(j)){
                if(j==nl-1){
                    result=i-nl+1;
                    break;
                }
                //lps[j]=j;
                   // System.out.println(j+"  lps[j]="+lps[j]);
                j++;
                i++;
            }
            else if(j==0){
                i++;
            }
            else{
                j=lps[j-1];
                //i--;
            }
        }
        return result;
    }
    private void compute(String needle,int[] lps){
        int i=1,j=0;
        while(i< needle.length()){
            if(needle.charAt(i)==needle.charAt(j)){
                j++;
                lps[i]=j;
                i++;
            }
            else if(j==0){
                lps[i]=0;
                i++;
            }
            else{
                j=lps[j-1];
            }
        }
    }
}