// O(n) time, n is length of s
// O(1), since traverse at most k elements which is fixed

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length()) return new ArrayList();
        
        Map<Character, Integer> pCount = new HashMap();
        Map<Character, Integer> sCount = new HashMap();
        
        for (char ch : p.toCharArray()){
            if (pCount.containsKey(ch)){
                pCount.put(ch, pCount.get(ch) + 1);
            }
            else{
                pCount.put(ch, 1);
            }
        }
        
        List<Integer> output = new ArrayList();
        for (int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if (sCount.containsKey(ch)){
                sCount.put(ch, sCount.get(ch) + 1);
            }
            else{
                sCount.put(ch, 1);
            }
            
            if (i >= p.length()){
                ch = s.charAt(i - p.length());
                if (sCount.get(ch) == 1){
                    sCount.remove(ch);
                }
                else{
                    sCount.put(ch, sCount.get(ch) - 1);
                }
            }
            
            if (pCount.equals(sCount)){
                output.add(i - p.length() + 1);
            }
        }
        return output;
    }
}