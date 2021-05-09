//Approach - Sliding window - window of size (p's length) - to check if the characters inside the window is an anagram of string p
//Time Complexity - O(s+p) - s is length of s, p is length of p
//Space Complexity - O(p) - length of p
class Solution {
  public List<Integer> findAnagrams(String s, String p) {
    List<Integer> result = new ArrayList<>();

    HashMap<Character, Integer> map = new HashMap<>();

    for(char c: p.toCharArray()){
      map.put(c, map.getOrDefault(c, 0)+1);
    }

    int match = 0;

    for(int i=0; i<s.length(); i++){
      char in = s.charAt(i);

      if(map.containsKey(in)){
        int count = map.get(in);
        count--;

        map.put(in, count);
        if(count == 0){
          match++;
        }
      }

      if(i >= p.length()){
        char out = s.charAt(i-p.length());

        if(map.containsKey(out)){
          int count = map.get(out);
          count++;

          map.put(out, count);
          if(count == 1){
            match--;
          }
        }
      }

      if(match == map.size()){
        result.add(i-p.length()+1);
      }
    }

    return result;
  }
}
