class Problem1 {
    //TC :O(M+N)
    //SC: O(1)
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        //prime to take modulo and keep the hash in range
        int prime = 100001;
        // each added character to window since it is multiplied by 26
        // for each character in the window we need to use this factor multiplied
        // to the char value befoe we remove it
        int posFactor = 1;
        for (int i = 0; i < n; i++) {
            posFactor = (posFactor * 26) % prime;
        }
        //find hash of the needle
        int pHash = 0 ;
        for(int i=0;i<n;i++){
            pHash = (pHash * 26 + (needle.charAt(i)-'a'+1)) %prime;
        }
        //use sliding window and calculate the hash for the window in haystack
        int currHash = 0;
        for(int j=0;j<m;j++){
            //hash for the incoming string
            currHash = (currHash * 26 + (haystack.charAt(j)-'a'+1))%prime;

            if(j>=n){
                // we need to remove char to match the window size n
                currHash = (currHash - (posFactor*(haystack.charAt(j-n)-'a'+1)))%prime;
            }

            if(currHash<0) currHash+=prime;//edge case because of modulo the hash can become negetive
            if (currHash == pHash) {
                return j - n + 1;
            }
        }

        return -1;
    }
}