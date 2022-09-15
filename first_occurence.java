//TC: O(h*n)
//SC: O(1)
//leetcode : successful
class Solution {
    public int strStr(String haystack, String needle) {
        int h = haystack.length();
         int n = needle.length();
        int k =-1;
        int i=0;
        while(i<= h-n){
            int j=0;
            if(haystack.charAt(i)==needle.charAt(j)){
                k = i;
            while(haystack.charAt(k)==needle.charAt(j) )
            {
                k++;
                j++;
                if(j==n)
                    return i;
            }
        }
            i++;
        }
        return -1;
    }
}
//using functions:
class Solution {
    public int strStr(String haystack, String needle) {
       int h = haystack.length();
        int n = needle.length();
        int res=-1;
        String sb = "";
        for(int i=0;i<h-n+1;i++){
            sb = haystack.substring(i,i+n);
            System.out.println(sb);
            if(sb.equals(needle))
                return i;
        }
            return res;
    }
}
