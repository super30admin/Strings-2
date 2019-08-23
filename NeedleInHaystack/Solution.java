import java.util.*;

class NeedleInHaystack {
   

    /**KMP*/
    public int strStr(String haystack, String needle){
        if(needle.length() == 0) return 0;
        // form lps array
        int[] lps = calcLpsArray(needle);

        int h = 0;
        int n = 0;

        while(h < haystack.length() && n < needle.length()){
            if(haystack.charAt(h) == needle.charAt(n)){
                h++;
                n++;

                if(n == needle.length()){
                    return h-n;
                }
                
            }
            
            if(h<haystack.length() && haystack.charAt(h) != needle.charAt(n)) {
                if(n == 0){
                    h++;
                }else {
                    n = lps[n-1];
                }
            }
        }

        System.out.println(Arrays.toString(lps));
        return -1;
    }

    public int[] calcLpsArray(String needle){
        int[] lps = new int[needle.length()];

        int j=0;
        int i=1;
        lps[0]=0;
        while(i < needle.length()){
            if(needle.charAt(i) == needle.charAt(j)){
                lps[i] = j+1; // length of prefix
                j++;
                i++;
            }
            else {
                if(j == 0){
                    lps[i] = 0;
                    i++;
                }
                else {
                    j = lps[j-1]; // move j to previous lps's element's prefix position
                }
            }
        }

        return lps;

    }
    
    /**KMP*/



    public int strStrBrute(String haystack, String needle) {

        int hStart=0, hEnd=0;
        int n=0;
        //int start = -1;

        if(needle.length() == 0) return 0;

        while(hStart < haystack.length() && hEnd < haystack.length() && n < needle.length()){
            if(haystack.charAt(hEnd) == needle.charAt(n)){
                hEnd++;
                n++;
                
                if(n == needle.length()){
                    System.out.println(hStart);
                    return hStart;
                }
            }
            else {
                hStart++;
                hEnd = hStart;
                n=0;
            }
        }

        return -1;
    }

}

class Solution {
    public static void main(String[] args){
        System.out.println("Needle In Haystack");
        String haystack = "mississippi";
        String needle="issip";
        NeedleInHaystack obj = new NeedleInHaystack();
       System.out.println(obj.strStr(haystack, needle));
    }
}