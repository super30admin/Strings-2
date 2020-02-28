// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if(p.length() > s.length() || s.length() == 0 || s == ""){
            return result;
        }
        Map<Character, Integer> map = new HashMap<>();
        int match = 0;
        
        for(int i = 0; i < p.length(); i++){
            map.put(p.charAt(i), map.getOrDefault(p.charAt(i),0) + 1);
        }
        
        int mapSize = map.size();
        char in = ' ';
        char out = ' ';
        int j = 0;
        for(int i = 0; i < s.length(); i++){
            in = s.charAt(i);
            if(map.containsKey(in)){
                map.put(in, map.get(in) - 1);
                if(map.get(in) == 0){
                    match++;
                }
            }
            
            if(i >= p.length()){
                    out = s.charAt(i - p.length());
                    if(map.containsKey(out)){
                    map.put(out, map.get(out) + 1);
                    if(map.get(out) == 1){
                        match--;
                    }
                }
            }
            
            if(match == mapSize){
                result.add(i-p.length() + 1);
            }
            
        }
        return result;
    }
        
        
        
        //brute force
        /*for(int i = 0; i < s.length() - p.length() + 1; i++){
            String str =  "";
            for(int j = i; j < i + p.length(); j++){
                str += s.charAt(j);
            }
            
            System.out.println(str);
            if(isAnagram(str,p)){
                result.add(i);
            }
        }
        
        return result;
    }
    
    private boolean isAnagram(String str, String comp){
        char temp[] = str.toCharArray();
        char temp2[] = comp.toCharArray();
        
        Arrays.sort(temp);
        Arrays.sort(temp2);
        
        if(Arrays.equals(temp,temp2)){
            return true;
        }
        
        return false;
    }*/
}