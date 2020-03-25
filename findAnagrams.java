class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList();
        
        if(s == null || s.length() == 0){
            return result;
        }
        
        int[] char_count = new int[26];
        
        for(char c:p.toCharArray()){
            char_count[c - 'a']++;
        }
        
        int start = 0;
        int end = 0;
        int count = p.length();
        
        while(end < s.length()){
            if(char_count[s.charAt(end++)-'a']-->=1)count--;
            
            if(count == 0){
                result.add(start);
            }
            
            if(end - start == p.length() && char_count[s.charAt(start++)-'a']++ >=0){
                count++;
            }
        }
        return result;
    }
}