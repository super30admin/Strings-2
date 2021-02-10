class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if(s.length()==0)
            return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        HashMap<Character, Integer> hm = new HashMap<>();
        HashMap<Character, Integer> hm1 = new HashMap<>();
        for(int i=0;i<p.length();i++){
            hm.put(p.charAt(i), hm.getOrDefault(p.charAt(i),0)+1);
        }
        int index = 0;
        
        for (int i = 0; i < s.length(); ++i) {
          // add one more letter 
          // on the right side of the window
          char ch = s.charAt(i);
          if (hm1.containsKey(ch)) {
            hm1.put(ch, hm1.get(ch) + 1);
          }
          else {
            hm1.put(ch, 1);
          }
          // remove one letter 
          // from the left side of the window
          if (i >= p.length()) {
            ch = s.charAt(i - p.length());
            if (hm1.get(ch) == 1) {
              hm1.remove(ch);
            }
            else {
              hm1.put(ch, hm1.get(ch) - 1);
            }
          }
          if (hm.equals(hm1)) {
            res.add(i - p.length() + 1);
          }
        }
        return res;
    }
}

//Time complexity : O(P+S) where P is length of string p and N is length of string n
//Space complexity : O(1) since there can be only 26 entries at max
