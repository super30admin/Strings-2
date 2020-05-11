class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        List<Integer> output = new ArrayList<>();
        
        int[] p_array = new int[26];
        int[] s_array = new int[26];
        
        for (int x = 0; x < p.length(); x++){
            p_array[p.charAt(x) - 'a']++;
        }
        
        int start = 0;
        int end = 0;
        
        while (end < s.length()){
            int curr_size = end - start + 1;
            
            char char_s = s.charAt(start);
            char char_e = s.charAt(end);
            
            if (curr_size < p.length()){
                s_array[char_e - 'a']++;
                end++;
            } else if (curr_size == p.length()){
                s_array[char_e - 'a']++;
                if (check_anagram(s_array,p_array)){
                    output.add(start);
                }
                end++;
            } else {
                s_array[char_s - 'a']--;
                start++;
            }
        }
        
        return output;
        
    }
    
    private boolean check_anagram(int[] s_array, int[] p_array){
        for (int x = 0; x < 26; x++){
            if (s_array[x] != p_array[x]){
                return false;
            }
        }
        
        return true;
    }
}