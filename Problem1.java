class Problem1 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        Map<Character, Integer> pStore = new HashMap<>();
        int count = 0;
        int match = 0;
        // Created a map and now storing the map with the characters and
        // its respective frequency in a map for finding the anagrams.
        for(int i=0; i<p.length(); i++){
            Character c = p.charAt(i);
            pStore.put(c, pStore.getOrDefault(c, 0)+1);
        }
        // Now we need to go through the String and find the anagrams using
        // the sliding window technique for an optimized approach.
        for(int i = 0; i<s.length(); i++){
            // incoming
            char c = s.charAt(i);
            if(pStore.containsKey(c)){
                count = pStore.get(c);
                count-=1;
                if(count == 0){
                    match++;
                }
                pStore.put(c, count);
            }
            //outgoing
            if(i>=p.length() && pStore.containsKey(s.charAt(i-p.length()))){
                c = s.charAt(i-p.length());
                count = pStore.get(c);
                count++;
                if(count==1){
                    match--;
                }
                pStore.put(c, count);
            }
            if(match == pStore.size()){
                result.add((i-p.length())+1);
            }
        }
        return result;
    }
}