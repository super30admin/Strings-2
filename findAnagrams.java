//TC - O(nm);
//SC - O(m) - length of p;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character,Integer>  map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        
        for(int i=0;i<p.length();i++){
            map.put(p.charAt(i),map.getOrDefault(p.charAt(i),0)+1);
        }
        int match=0;
        for(int i=0;i<s.length();i++){
            
            char c = s.charAt(i);
            if(map.containsKey(c)){
                int count = map.get(c);
                count--;
                if(count==0) match++;
                map.put(c,count);
            }
            
            if(i>=p.length()){
                char out = s.charAt(i-p.length());
                if(map.containsKey(out)){
                    int cnt = map.get(out);
                    cnt++;
                    if(cnt==1) match--;
                    map.put(out,cnt);
                }
            }
            
            if(match==map.size()) list.add(i-p.length()+1);
            
            
        }
        
        return list;
    }
    
}