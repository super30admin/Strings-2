package s30.strings.s2;


//Algo: KMP algo -> use automata as hint.
// need to create an array(corresponds to largest prefix array index that matches the suffix)

//TC: O(n+m) n => length of the haystack and m => length of needle
//SC: O(1) fixed characters.
public class strstr {

    public int strStr(String haystack, String needle) {

        int hLength = haystack.length();
        int nLength = needle.length();

        int[] lps = lps(needle);

        int hIndex = 0;
        int nIndex =0;

        while(hIndex < hLength && nIndex < nLength){

            if(haystack.charAt(hIndex) == needle.charAt(nIndex) ){
                hIndex++;
                nIndex++;
            }
            else{
                if(nIndex ==0){
                    hIndex++;
                }
                else {
                    nIndex = lps[nIndex-1];
                }
            }
        }



        if(nIndex == nLength) return hIndex - nLength;

        return -1;
    }


    private int[] lps(String needle){
        int n = needle.length();

        int[]lps = new int[n];

        int index =1, nIndex =0;

        while(index < n){
            if(needle.charAt(index) == needle.charAt(nIndex)){
                ++nIndex;
                lps[index] = nIndex;
                ++index;
            }
            else{
                if(nIndex ==0){
                    index++;
                }
                else{
                    nIndex = lps[nIndex-1];
                }
            }
        }

        return lps;
    }
    public static void main(String[] args) {

    }
}
