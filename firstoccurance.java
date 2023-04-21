class Solution {
    public int strStr(String haystack, String needle) {
        // robin karp algorithm to calculate hash
        //TC-O(n+m), SC-O(1)
        //find hash of the needle
        // use sliding window to find hash of the haystack and check if both are same hashes
        int m = haystack.length();
        int n = needle.length();
        if(m<n) return -1;
        // hash of needle
        long needlehash = 0l;
        long hayhash =0l;
        int k=26;
        // abc = 1*26*26 + 2*26 + 3
        for(int i =0;i<n;i++){
            char ch = needle.charAt(i);
            needlehash = needlehash*k+(ch - 'a' +1);
        }

        for(int j=0;j<m;j++){
            //in
            char cl = haystack.charAt(j);
            hayhash =hayhash*k +(cl-'a'+1);

            if(j>=n){
                //out
                char c = haystack.charAt(j-n);
                hayhash = hayhash - (long)Math.pow(k,n)*(c-'a'+1);
            }
            if(hayhash==needlehash){
                return (j-n+1);
            }

        }
        return -1;
        
    }
}