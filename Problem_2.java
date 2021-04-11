// Time Complexity : O(n-l * l), n = length of s, l = length of p  
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No


class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();

        int S = s.length(); 
        int P = p.length();
        
        if(p == null || p.length() == 0 || P > S)
            return res;
                
        int i = 0, j = P ;
        long pCode = getHashValue(p);
        while(i < S && j <= S ){
            if(getHashValue(s.substring(i,j)) == pCode){
                res.add(i);
            }
            i++; j++;
        }
        return res;
    }
    public long getHashValue(String s){
        int[] primes = { 3, 5 ,7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79,
                       83, 89, 97, 101, 103};
        long code = 1;
        for(char c: s.toCharArray()){
            code *= primes[c - 'a'];
        }
        return code;
    }
}
