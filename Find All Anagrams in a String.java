/*
class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        if s is None or len(s) == 0:
            return []
        
        result = []
        hashmap = dict()
        for c in p:
            hashmap[c] = hashmap.get(c,0) + 1
            
        i = 0
        
        match = 0
        while i < len(s):
            # incoming char
            if s[i] in hashmap:
                hashmap[s[i]] -= 1
                if hashmap[s[i]] == 0:
                    match += 1
                    
            # outgoing char
            if i >= len(p):
                if s[i - len(p)] in hashmap:
                    hashmap[s[i - len(p)]] += 1
                    if hashmap[s[i - len(p)]] > 0:
                        match -= 1
            
            if match == len(hashmap): # dont write len(p) as hashmap will have unique                                         # chars while p may have duplicates
                result.append(i-len(p)+1)
                
            i += 1
        return result
*/
// Time - O(m+n) where m and n are size of s and p
// Space - O(1) because 26 alphabets
// Logic - Sliding window techinique

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0)
            return result;
        
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i=0; i<p.length(); i++){
            char c = p.charAt(i);
            map.put(c, map.getOrDefault(c,0)+1);
        }
        
        int i = 0, match = 0;
        while (i < s.length()){
            char c = s.charAt(i);
            // incoming 
            if (map.containsKey(c)){
                int count = map.get(c);
                count -= 1;
                if (count == 0)
                    match ++;
                map.put(c,count);
            }
            // outgoing
            if (i >= p.length()){
                char outgoing = s.charAt(i-p.length());
                if (map.containsKey(outgoing)){
                    int count = map.get(outgoing);
                    count ++;
                    if (count > 0)
                        match --;
                    map.put(outgoing, count);
                }
                
            }
            // matched
            if (match == map.size()){
                result.add(i-p.length()+1);
            }
            i++;
        }
        return result;
    }
}
            
        