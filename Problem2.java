class Solution {
    
    public List<Integer> findAnagrams(String s, String p) {
        
        Map<Character, Integer> freqMap = findFreq(p);

        List<Integer> returnList = new ArrayList<>();

        int start = 0, end = 0;
        int matches = 0;

        while (end<s.length()) {
            
            char c = s.charAt(end);
            
            if (freqMap.containsKey(c)) {
                // reduce freqMap, update matches. if matches is good store start location
                int currFreq = freqMap.get(c);
                
                if (currFreq == 1) matches++; // we have right amount of b
                if (currFreq == 0) matches--; // we have 1 extra character of b

                freqMap.put(c, currFreq - 1); // update freq
                

                if (matches == freqMap.size()) returnList.add(start);
                
            } 
            end++;
            if ((end-start + 1) > p.length()) {
                char charS = s.charAt(start);
                if (freqMap.containsKey(charS)) {
                    int currFreq = freqMap.get(charS);
                    
                    if (currFreq == -1) matches++;
                    else if (currFreq == 0) matches--;
                    
                    freqMap.put(charS, currFreq + 1);
                    
                }
                start++;
            }

        }

        return returnList;
        
    }

    private Map<Character, Integer> findFreq(String p) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (int i=0; i<p.length(); i++) {
            char c = p.charAt(i);
            freqMap.putIfAbsent(c, 0);
            freqMap.put(c, freqMap.get(c) + 1);
        }
        return freqMap;

    }

}
