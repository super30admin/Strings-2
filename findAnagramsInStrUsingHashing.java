// Time Complexity : O(m+n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

 public  class findAnagramsInStrUsingHashing {

        int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67,
                71, 73, 79, 83, 89, 97, 101};
        public List<Integer> findAnagrams(String s, String p) {

            List<Integer> result = new ArrayList<>();
            int m = s.length();
            int n = p.length();

            BigInteger hashP = BigInteger.valueOf(1);
            BigInteger hashS = BigInteger.valueOf(1);

            for(int i=0; i<n; i++)
            {
                char c = p.charAt(i);
                hashP = hashP.multiply(BigInteger.valueOf(prime[c -'a']));
            }
            System.out.println(hashP);

            for(int i=0; i<s.length();i++)
            {
                char c = s.charAt(i);
                hashS = hashS.multiply(BigInteger.valueOf(prime[c -'a']));
                if(i >= n){
                    char outChar = s.charAt(i-n);
                    int outHash = prime[outChar - 'a'];
                    hashS = hashS.divide(BigInteger.valueOf(outHash));

                }
                if(hashP.equals(hashS))
                {
                    result.add(i-n+1);
                }

            }
            return result;
        }
    }
