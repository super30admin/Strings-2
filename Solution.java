import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    //TC: O(m * n) Bruteforce
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        int i=0; //haystack and needle ptrs resp
        if(m < n)   return -1;
        while(i <= m-n){
            int j = 0;
            if(haystack.charAt(i) == needle.charAt(j)){
                int k = i;
                while(haystack.charAt(k) == needle.charAt(j)){
                    k++; j++;
                    if(j == n){
                        //match found
                        return i;
                    }
                }
            }
            i++;
        }
        return -1;
    }

    //TC: O(m)  SC: O(1)
    public int strStr_2(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        if(n>m) return -1;
        BigInteger hash = BigInteger.ZERO;
        BigInteger t = BigInteger.valueOf(26);
        for(int i=0; i<n; i++){
            char c = needle.charAt(i);
            hash = hash.multiply(t).add(BigInteger.valueOf(c - 'a' + 1)) ;
        }
        BigInteger hash2 = BigInteger.ZERO;
        for(int i=0; i<m; i++){
            if(i>=n){
                // char a = haystack.charAt(i-n);
                hash2 = hash2.mod(t.pow(n-1));
            }
            char b = haystack.charAt(i);
            hash2 = hash2.multiply(t).add(BigInteger.valueOf(b - 'a' + 1)) ;
            if(hash.equals(hash2)) return i-n+1;
        }
        return -1;
    }

    //TC: O(0m+n)  SC: O(1)
    public List<Integer> findAnagrams(String s, String p) {

        int n = p.length(); //pattern len
        int m = s.length();  //string len
        List<Integer> result = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();

        //load pattern chars with freq
        for (int i = 0; i < n; i++) {
            char c = p.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        //start matching
        int match = 0;
        for (int i = 0; i < m; i++) {

            //incoming char
            char incoming = s.charAt(i);
            if (map.containsKey(incoming)) {
                int freqCount = map.get(incoming);
                freqCount--;
                map.put(incoming, freqCount);
                if (freqCount == 0) match++;
            }

            if (i >= n) {
                //outgoing char
                char outgoing = s.charAt(i - n);
                if (map.containsKey(outgoing)) {
                    int freqCount = map.get(outgoing);
                    freqCount++;
                    map.put(outgoing, freqCount);
                    if (freqCount == 1) match--;
                }
            }
            if (match == map.size()) {
                result.add(i - n + 1);
            }
        }
        return result;
    }

}
