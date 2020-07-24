// Time complexity - O(n^4(logn)), O(n) - For loop, O(n) - substring operation, O(nlogn) for sorting, and O(n) for Arrays.equal()
// Space complexity - O(1)

// Check isAnagram for all pairs using sorting

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int n = s.length();
        int k = p.length();
        for(int i = 0; i <= (n-k); i++){
            String sub = s.substring(i,i+k);
            if(checkAnagram(sub,p)){
                result.add(i);
            }
        }
        
     return result;   
    }
    
    private boolean checkAnagram(String s, String t){
    if (s.length() != t.length()) {
        return false;
    }
    char[] str1 = s.toCharArray();
    char[] str2 = t.toCharArray();
    Arrays.sort(str1);
    Arrays.sort(str2);
    return Arrays.equals(str1, str2);
    }
}
