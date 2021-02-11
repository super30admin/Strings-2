// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :
// Three line explanation of solution in plain english

// Your code here along with comments explaining your approach
class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack.length()==0 && needle.length()!=0){
            return -1;
        }
        if(haystack.length()==0 || needle.length()==0){
            return 0;
        }
        if(haystack.equals(needle)){
            return 0;
        }
        for(int i=0;i<haystack.length();i++){
            if(haystack.charAt(i)==needle.charAt(0)){
                if(checkValidity(haystack,i,needle)){
                    return i;
                }
            }
        }
            
        return -1;
    }
    
    public boolean checkValidity(String haystack,int index,String needle){
        int len=index+needle.length();
        if(len<=haystack.length() && haystack.substring(index,len).equals(needle)){
            return true;
        }
        return false;
    }
}