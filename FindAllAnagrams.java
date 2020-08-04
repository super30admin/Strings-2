//Time Complexity : O(N(s) +N(p))
//Space Complexity : O(1)
//Did it run on leetcode  : yes

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
     
        if(s == null || s.length() == 0)
            return new ArrayList<>();
        
        List<Integer> list = new ArrayList<>();
        HashMap<Character,Integer> map = new HashMap<>();
        int match = 0;
        for(int i = 0; i < p.length(); i++){
             char c = p.charAt(i);
            map.put(c, map.getOrDefault(c,0)+1);
        }
        
        int in = 0;
        
        for(int i = 0 ; i < s.length() ;i++){
            
            char c = s.charAt(i);
            
            if(map.containsKey(c)){
                int count =  map.get(c);
                map.put(c, map.get(c)-1);
                count--;
                if(count == 0)
                    match++;
            }
            if( i >= p.length()){
                in = i - p.length();
                char d= s.charAt(in);
                if(map.containsKey(d)){
                  int count = map.get(d);
                  map.put(d,map.get(d)+1);
                  count++;
                  if(count == 1)
                      match--;
                }
            }
            
            if(match == map.size())
            {
                list.add(i - p.length()+1);
            }
            
        }
        
        return list;
    }
}