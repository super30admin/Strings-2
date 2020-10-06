// Problem 1 - Implement strStr()
// Time Complexity: O(n) where n = length of haystack string
// Space Complexity: O(1)

// Algorithm
// 1 - initialize pointers
// 2 - while condition
// 3 - if the substring equals needle, return the start index
// 4 - else increment pointers
class Solution {
  public int strStr(String haystack, String needle) {
    // 1
    int s = 0;
    int e = needle.length();

    if (e == 0) {
      return s;
    }
    // 2
    while (e <= haystack.length()) {
      // 3
      if (haystack.substring(s, e).equals(needle)) {
        return s;
      }
      // 4
      s++;
      e++;
    }

    return -1;
  }
}

// Problem 2
// Time Complexity: O(n) where n = length of s string
// Space Complexity: O(1)

// Algorithm
// 1 - initialize arrays
// 2 - loop over p array
// 3 - store frequency in both arrays
// 4 - check if both arrays are same
// 5 - if yes, add index to result
// 6 - while condition
// 7 - decrement the frequency of start index char
// 8 - increment the frequency of end index char
// 9 - if arrays same, add to result
class Solution {
  public List<Integer> findAnagrams(String s, String p) {
    // 1
    int[] sArr = new int[26];
    int[] pArr = new int[26];        
    List<Integer> result = new ArrayList<>();

    if(s.length() < p.length())
      return result;
    // 2
    for(int i=0; i<p.length(); i++){
      // 3
      sArr[s.charAt(i)-'a']++;
      pArr[p.charAt(i)-'a']++;
    }

    int start = 0;
    int end = p.length();
    // 4
    if(Arrays.equals(sArr, pArr))
      // 5
      result.add(start);
    // 6
    while(end < s.length()) {
      // 7
      sArr[s.charAt(start) - 'a']--;
      // 8
      sArr[s.charAt(end) - 'a']++;
      // 9
      if(Arrays.equals(sArr, pArr)) {
        result.add(start+1);
      }

      start++;
      end++;
    }

    return result;
  }
}
