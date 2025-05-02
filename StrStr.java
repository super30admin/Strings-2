
public class StrStr {

}


/*
TC O(m*n)
class Solution {
    public int strStr(String haystack, String needle) {
        int m=haystack.length();
        int n=needle.length();
        int i=0;
        while(i<=m-n){
            int j=0;
            int k=i;
            while(haystack.charAt(k)==needle.charAt(j)){
                k++;
                j++;
                if(j==n){
                    return i;
                }
            }
            i++;
        }
        return -1;
    }
}

*/

/*
import java.math.BigInteger;

O(m+n)
class Solution {
    public int strStr(String haystack, String needle) {
        int m =haystack.length();
        int n=needle.length();
        BigInteger nhash=BigInteger.ZERO;
        for(int i=0;i<n;i++){
            nhash=nhash.multiply(26).add(BigInteger.valueOf(needle.charAt(i)-'a'+1));
        }
        BigInteger sourcehash=BigInteger.ZERO;

        //start processing source
        for(int i=0;i<m;i++){
            if(i>=n){
                char out = haystack.charAt(i-n);
                //sourcehash=sourcehash- (out-'a'+1)*Math.pow(26,n-1);
                sourcehash=sourcehash.mod(Math.pow(26,n-1));
            }
            char in = haystack.charAt(i);
            sourcehash=sourcehash.multiply(26).add(BigInteger.valueOf(in-'a'+1));
            if(sourcehash==nhash){
                return i-n+1;
            }
        }
        return -1;
    }
}

*/

//KMP
//TC: O(m+n)
//SC:O((n))
class Solution {
    public int strStr(String haystack, String needle) {
        int m=haystack.length();
        int n=needle.length();
        int[] lps=lps(needle,n);
        int i=0;  //haystack
        int j=0;  //needle
        while(i<m){
            if(haystack.charAt(i)==needle.charAt(j)){
                i++;
                j++;
                if(j==n){
                    return i-n;
                }
            }else if(j!=0 && haystack.charAt(i)!=needle.charAt(j)){
                j=lps[j-1];
            }else if(j==0 && haystack.charAt(i)!=needle.charAt(j)){
                i++;
            }
        }
        return -1;
    }

    private int[] lps(String needle,int n){
        int[] res=new int[n];
        res[0]=0;
        int i=1;
        int j=0;
        while(i<n){
            if(needle.charAt(i)==needle.charAt(j)){
                j++;
                res[i]=j;
                i++; 
            }else if(j!=0 && needle.charAt(i)!=needle.charAt(j)){
                j=res[j-1];
            }else if(j==0 && needle.charAt(i)!=needle.charAt(j)){
                res[i]=0;
                i++;
            }
        }
        return res;
    }
}


