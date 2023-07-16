
// Any problem you faced while coding this :
import java.util.LinkedList;
import java.util.Queue;

public class NeedleInHayStack {

    /// Time Complexity : O(m*n) where m is the length of the string haystack and n is the length of  the needle
    //// Space Complexity :O(1) as no auxiliary space is used
    //// Did this code successfully run on Leetcode : Yes
    public int strStr(String haystack, String needle) {

        int m = haystack.length();
        int n = needle.length();

        if(m < n) return -1;

        int i =0;
        while(i < m-n+1){
            if(haystack.charAt(i) == needle.charAt(0)){
                int j =0; int k = i;
                while(haystack.charAt(k) == needle.charAt(j)){
                    k++; j++;
                    if(j == n){
                        return i;
                    }
                }
            }
            i++;
        }
        return -1;
    }

    /// Time Complexity : O(m+n) where m is the length of the string haystack and n is the length of  the needle
    //// Space Complexity :O(1) as no auxiliary space is used
    //// Did this code successfully run on Leetcode : Yes
    public int strStr2(String haystack, String needle) {

        int m = haystack.length();
        int n = needle.length();
        int k = 26;
        long factor = (long)(Math.pow(k, n));

        if(m < n) return -1;

        long needleHash = 0l;
        for(int i =0; i< n; i++){
            needleHash = needleHash*k + (needle.charAt(i)-'a'+1);
        }

        long currentHash = 0;
        for(int i =0; i< m; i++){
            //in
            Character in = haystack.charAt(i);
            currentHash = currentHash*k + (in-'a'+1);
            if(i >= n){
                //out
                Character out = haystack.charAt(i-n);
                currentHash = currentHash - (factor * (out-'a'+1));
            }

            if(currentHash == needleHash){
                return i - n +1;
            }
        }
        return -1;
    }

}
