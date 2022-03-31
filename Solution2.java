class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        
        int[] pFreq = new int[26];
        for(int i=0; i<p.length(); i++){
            pFreq[p.charAt(i) - 'a']++;
        }
        
        int[] sWindowFreq = new int[26];
        int i=0;
        
        while(i < s.length()){
            ++sWindowFreq[s.charAt(i) - 'a'];
            
            if(i>=p.length()){
                --sWindowFreq[s.charAt(i - p.length()) - 'a'];
            }
            
            if(Arrays.equals(pFreq, sWindowFreq)){
                result.add(i - p.length() + 1);
            }
            
            ++i;
        }
        
        return result;
    }
}
