//Problem 1: First occurrence of a String
// Time Complexity : O(m+n) Best case
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no
//Brute force : O((m-n)*n) SC: O(1) check for all substrings of size needle and check if needle exists
//Optimized : O(m+n) SC: O(1) create hashvalue of needle and check if that particular hashvalue exists in big string in one pass.
import java.math.BigInteger;
class Solution {
    public int strStr(String haystack, String needle) {
        //return haystack.indexOf(needle);
        //TC: O((m-n)*n) SC: (1)
        int m=haystack.length(),n=needle.length();
        if(n>m) return -1;

        // int i=0;

        // while(i<=m-n){ //O(m-n)
        //     int j=0;
        //     if(haystack.charAt(i)==needle.charAt(j)){
        //         int k=i;

        //         while(haystack.charAt(k)==needle.charAt(j)){ //O(n)
        //             k++;
        //             j++;

        //             if(j==n){ //match found
        //                 return i;
        //             }
        //         }
        //     }
        //     i++;
        // }
        // return -1;


        //rolling hash
        //find hash of needleString
        // long needleHash=0;
        // for(int i=0;i<n;i++){
        //     char c=needle.charAt(i);

        //     needleHash = needleHash*26 + (c-'a'+1);
        // }

        //hash of patternString
        // long curHash=0;
        // long outgoingreduction= (long)Math.pow(26,n);
        // for(int i=0;i<m;i++){
        //     //incoming char
        //     char in=haystack.charAt(i);
        //     curHash= curHash*26 + (in-'a'+1);

        //     if(i>=n){
        //         char out= haystack.charAt(i-n);

        //         curHash = curHash - (out-'a'+1)*outgoingreduction;
        //     }

        //     if(curHash==needleHash){ //pattern found
        //         return i-n+1;
        //     }
        // }
        // return -1; //pattern not found

        BigInteger needleHash = BigInteger.ZERO;
        for (int i = 0; i < n; i++) {
            char c = needle.charAt(i);
            needleHash = needleHash.multiply(BigInteger.valueOf(26)).add(BigInteger.valueOf(c - 'a' + 1));
        }

        // hash of patternString
        BigInteger curHash = BigInteger.ZERO;
        BigInteger outgoingReduction = BigInteger.valueOf(26).pow(n);
        for (int i = 0; i < m; i++) {
            // incoming char
            char in = haystack.charAt(i);
            curHash = curHash.multiply(BigInteger.valueOf(26)).add(BigInteger.valueOf(in - 'a' + 1));

            if (i >= n) {
                char out = haystack.charAt(i - n);
                curHash = curHash.subtract(BigInteger.valueOf(out - 'a' + 1).multiply(outgoingReduction));
            }

            if (curHash.equals(needleHash)) { // pattern found
                return i - n + 1;
            }
        }
        return -1; // pattern not found
    }
}


//Problem 2: Find starting index of all anagrams in String
// Time Complexity : O(n)
// Space Complexity : O(26)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
//keep String p character and frequency in hashmap, then iterate over the array to check whether our hashmap all frequencies is 0, if yes, we found a anagram.
//TC: O(m) SC: O(26)
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res=new ArrayList<>();
        HashMap<Character, Integer> map= new HashMap<>();
        int n=p.length(), m=s.length();

        for(int i=0;i<p.length();i++) //O(n)
            map.put(p.charAt(i),map.getOrDefault(p.charAt(i),0)+1);

        int match=0;
        for(int i=0;i<m;i++){
            char in=s.charAt(i);

            
            //in
            if(map.containsKey(in)){
                int cnt=map.get(in);
                cnt--;
                // if(cnt<0) continue;
                map.put(in,cnt);
                if(cnt==0) match++;
                else if(cnt<0) match--;
            }

            //out
            if(i>=n){
                char out=s.charAt(i-n);
                if(map.containsKey(out)){
                    int cnt=map.get(out);
                    cnt++;

                    map.put(out,cnt);
                    if(cnt==1) match--;
                    else if(cnt<=0) match++;
                }
            }

            //check if anagram found
            if(match==map.size())
                res.add(i-n+1);
        }
        return res;
    }
}