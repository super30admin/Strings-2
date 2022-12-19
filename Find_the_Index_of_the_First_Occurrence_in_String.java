// TC : O(n) (needle.length * needle.length)
// SC : O(1)
// Method : sliding window

class Solution {
    
    private boolean isPrime(int n) {
         if(n==1||n==0) return false;
  
        for(int i=2; i*i<=n; i++) {
            if(n%i==0) return false;
        }
        return true;
    }
    
    public int strStr(String haystack, String needle) {
        
        if(haystack == null || haystack.length() == 0 ||
            needle == null || needle.length() == 0 || 
          needle.length() > haystack.length()) return -1;
        
        int[] values = new int[26];
        int i = 2, k = 0;
        while(k < 26) {
            if(isPrime(i)) {
                values[k] = i;
                k++;
            }
            i++;
        }
        long prod = 1, check = 1;
        i = 0;
        while(i < needle.length()) {
            prod = prod * values[needle.charAt(i) - 'a'];
            check = check * values[haystack.charAt(i) - 'a'];
            i++;
        }
        int left = 0;
        int right = needle.length() - 1;
        while(right < haystack.length()) {
            if(check == prod) {
                int left1 = left;
                int right1 = right;
                int count = 0;
                int idx = 0;
                while(left1 <= right1) {
                    if(needle.charAt(idx) == haystack.charAt(left1))
                        count++;
                    left1++;
                    idx++;
                }
                if(count == needle.length())
                    return left;
            }
            
            check = check/values[haystack.charAt(left) - 'a'];
            left++;
            right++;
            if(right == haystack.length())
                break;
            check = check * values[haystack.charAt(right) - 'a'];
            
        }
        
        return -1;
    }
}
