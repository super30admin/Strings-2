// TC : O(n) length of s
// SC : O(1) constant character map 26 
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if(s == null || s.length() == 0 || p == null || p.length() == 0)
            return result;
        
        HashMap<Character, Integer> hMap = new HashMap<>();
        
        for(int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            if(!hMap.containsKey(c))
                hMap.put(c, 1);
            else
                hMap.put(c, hMap.get(c)+1);
        }
        
        int match = 0;
        int left = 0, right = 0;
        
        while(right < s.length()) {
            char cin = s.charAt(right);
            
            if(hMap.containsKey(cin)) {
                int count = hMap.get(cin);
                count--;
                if(count == 0)
                    match++;
                hMap.put(cin, count);
            }
            
            if(right - left == p.length()) {
                char cout = s.charAt(left);
                if(hMap.containsKey(cout)) {
                    int count = hMap.get(cout);
                    count++;
                    hMap.put(cout, count);
                    if(count == 1)
                        match--;
                }
                left++;
            }
            
            if(match == hMap.size())
                result.add(left);
            
            right++;
        }
        
        return result;
    }
}
