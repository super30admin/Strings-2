//Use Rolling Hash Technique to calculate hash value of source window that matches the given pattern's hash
//Keep sliding the window of length of given pattern over the source to test each length of chars if they match the pattern
//TC O(m+n)
//SC O(1)
public class FindNeedleInHaystack {
    private int searchStr(String haystack, String needle) {
            int m = haystack.length();
            int n = needle.length();
            if(m< n) return -1;

            long hashHay = 0, hashNeedle = 0;
            long posFac = (long) Math.pow(26,n-1);

            //hash of needle
            for(int i=0;i<n;i++){
                char c = needle.charAt(i);
                hashNeedle = hashNeedle*26+(c-'a'+1); //+1 is as index is taken from 1 //a=1, b=2
            }
            //check hash of haystack using sliding window
            for(int j=0;j<m;j++){
                char ch = haystack.charAt(j);
                if(j>=n){
                    char out = haystack.charAt(j-n);
                    hashHay = hashHay - (out-'a'+1)*posFac;
                }
                hashHay = hashHay*26+(ch-'a'+1);
                if(hashHay==hashNeedle)
                    return j-n+1;
            }
            return -1;
    }
}
