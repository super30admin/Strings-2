// Time Complexity : O(m)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
  public List<Integer> findAnagrams(String s, String p) {
    int m = s.length();
    int n = p.length();

    List<Integer> result = new ArrayList<>();
    Map<Character, Integer> hashmap = new HashMap<>();
    // Edge cases:
    if(m < n || m == 0 || n == 0) return result;

    for(int i = 0; i<n; i++) {
      char c = p.charAt(i);
      hashmap.put(c, hashmap.getOrDefault(c,0)+1);
    }

    int left = 0;
    int right = 0;
    int matched = hashmap.size(); // Number of unique characters we need to match

    while(right < m) {
      char c = s.charAt(right);
      if(hashmap.containsKey(c)) {
        hashmap.put(c, hashmap.get(c)-1);
        if(hashmap.get(c) == 0) matched--; // If frequency is zero, one unique character is completely matched
      }
      right++;
      while(matched == 0) {
        if(right - left == n) result.add(left);
        char temp = s.charAt(left);
        // Start shrinking the window from the left
        if(hashmap.containsKey(temp)) {
          hashmap.put(temp, hashmap.get(temp)+1);
          if(hashmap.get(temp) > 0) matched++;
        }
        left++;
      }
    }
    return result;
  }
}