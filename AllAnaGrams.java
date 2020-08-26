/*
  Time: O(n)
  Space: O(1) in case we are storing only 26 chars.
  Run on LeetCode: yes
*/
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ret = new ArrayList<>();
        if(s.length() == 0 || p.length() == 0)
            return ret;

        int need = p.length();
        HashMap<Character, Integer> hmp = new HashMap<>();

        for(int i = 0 ; i < p.length(); i++){
            hmp.put(p.charAt(i), hmp.getOrDefault(p.charAt(i), 0)+1);
        }

        int st = 0;
        int en = 0;
        //use sliding window.
        while(st < s.length() && en < s.length()){
            //keep adding till en > end of str and still elems are needed.
            while(en < s.length() && need > 0){
                //in case val == 0 or elem not in map. do not increment en.
                int val = hmp.getOrDefault(s.charAt(en), 0);
                if(val > 0){
                    hmp.put(s.charAt(en), val-1);
                    need--;
                }
                else
                    break;
                en++;
            }

            //if need = 0 we know we found contigious anagram.
            if(need == 0)
                ret.add(st);

            //on each itr. reduce string by moving st one at a time.
            // in case elem is what we need also increase the its count in map
            //and need count.
            if(hmp.containsKey(s.charAt(st))){
                hmp.put(s.charAt(st), hmp.get(s.charAt(st))+1);
                need++;
            }
            st++;

            //possible in case en is at an elem not in map.
            //then move en so that st and en are same, till we encounter an
            //elem we are intrested in.
            if(st > en)
                en = st;
        }
        return ret;
    }
}
