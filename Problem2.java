package Strings-2;
// TC: O(m)
// SC: O(1)
public class Problem2 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int n = p.length();
        int m = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
          map.put(p.charAt(i), map.getOrDefault(p.charAt(i), 0)+1);
        }
        int match = 0;
        for(int i=0; i<m;i++){
          char in = s.charAt(i);
          if(map.containsKey(in)){
            int keyFreq = map.get(in);
            map.put(in, keyFreq-1);
            if(keyFreq - 1 == 0) match++;
          }

          if(i>=n){
            char out = s.charAt(i-n);
            if(map.containsKey(out)){
              int outFreq = map.get(out);
              map.put(out, outFreq+1);
              if(outFreq == 0) match --;
            }
          }
          if(match == map.size()) result.add(i-n+1);
        }


      return result;
    }
}
