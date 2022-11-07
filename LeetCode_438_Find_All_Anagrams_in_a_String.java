import java.util.Map;

/*
 *approach - 1 
 Prime number attached to each individual! 
TC -O(N)
SC -O(1)
 */


 /*approach -2 
  * using Map of Charcter , Integer
  take  variable match = 0; and we will comapre it with size of HashMap!
  - construct map from p. 
  - pointer slow and fast starts at 0. , slow stays and fast moves. 
  - if the map contains char at fast - incoming character ; decrement the value of that in map, and if that becomes 0 then match++ 
  - if not move fast . . cause then thre is no anagram but we have to update the outgoing character into map, 
  so slow will not jump, it will move.
  - let say if we find match == map.size(); we return index of slow! then we go and increment fast - and check if length
  is greater than size of p; then just increment slow; which we mark as outgoing charcter.
  let say outgoing char was one of them in map - then we just increcese it's value ; if it becomes 1 ; we decrement match--
 
 - and so on . . we keep traversing!!  */
 
 class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if(s.length() ==0 || s == null || p.length() ==0 || p == null) return new ArrayList<>();
        
        Map<Character, Integer> map = new HashMap<>();
        List<Integer> result  = new ArrayList<>();
        
        int match =0; 
        int len=0;
        int slow =0;
        int plen = p.length();
        
        //built map
        for(int i=0; i<plen; i++)
        {
            char c = p.charAt(i);
            map.put(c , map.getOrDefault(c, 0)+1 );
        }

        int size = map.size();

        for(int fast=0; fast <s.length(); fast++)
        {
            char in = s.charAt(fast);
            

            if(map.containsKey(in))
            {
                int cnt = map.get(in);
                cnt--;
                if(cnt ==0) match++;
                map.put(in, cnt);
            }

            if(fast-slow+1 > plen)
            {
                //outgoing charcter
                char out = s.charAt(slow);
                slow++;
                if(map.containsKey(out))
                {
                    int cnt = map.get(out);
                    cnt++;
                    if(cnt ==1) match--;
                    map.put(out, cnt);
                }
            }

            if(match == size)
                result.add(slow);
        }
        return result;

    }
}