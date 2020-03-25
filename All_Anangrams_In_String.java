//Time Complexity: O(l(s)+l(p))
//Space Complexity: Constant => O(26)+O(26)
class Solution {
    
    public List<Integer> findAnagrams(String s, String p) {
        
        List<Integer> result = new ArrayList<>();
        
        int[] p_array = new int[26];
        int[] s_array = new int[26];
        
        //counting the frequencies of each char for String p
        for(char ch: p.toCharArray())
        {
            p_array[ch-'a']++;
        }
        
      
        int np = p.length();
        
        for(int i=0; i<s.length(); i++)
        {
            //populate S_array
            s_array[s.charAt(i) -'a']++;
            
            if(i>=np)
                s_array[s.charAt(i-np) - 'a']--;
            
            if(Arrays.equals(p_array, s_array))
                result.add(i-np+1);
        }
        
        return result;
    
    }
    
}
