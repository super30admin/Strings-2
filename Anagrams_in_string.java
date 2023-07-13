//sol 1. using prime multiples: the prime number multiplication of all the anagrams are same: So we iterate over the string with two pointers to find the substring which has equivalent prime multiplication.
//Time Complexity = O(M) + O(N)
//Space complexity = O(1)
// 1 testcase wasn't passing and it happened the same thing in class too becuase the product might be going out of bounds.

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int n = p.length();
        LinkedList<Integer> result = new LinkedList<>();

        //base
        if(s.length() < p.length())return result;

        //allcate prime numbers
        int[] primes = { 2,3,5,7,11, 13,17,19,23,29,
                31,37,41,43,47, 53,59,61,67,71, 73,79,83,89,97,101};

        //prime multiplication of p
        long primeProduct = 1l;


        for(int i=0; i< p.length(); i++){
            char c = p.charAt(i);
            primeProduct *= primes[c-'a'];

        }


        //check substrings whose prime multiplication is p
        long product = 1l;

        for(int i =0; i < s.length() ; i++){
            char in = s.charAt(i);
            product *= primes[in - 'a'];

            if(i >= n){
                char out = s.charAt(i-n);
                product = product/primes[out - 'a'];
            }

            if(product == primeProduct){ result.add(i-n +1);}

        }
        return result;
    }
}