class Solution {// Time of O(S+P) and space of O(P)
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new LinkedList<>();
        
        //Anagrams size greater than the string
        if(s.length() < p.length())
            return result;
        
        // Build the hashmap
        HashMap<Character, Integer> hmap = new HashMap<>();
        for(char c:p.toCharArray()){
            hmap.put(c, hmap.getOrDefault(c,0)+1);
        }
        int counter = hmap.size() ;
        int begin = 0, end = 0;
        
        while(end < s.length()){
            char c = s.charAt(end);
            if(hmap.containsKey(c)){
                hmap.put(c, hmap.get(c) - 1);
                if(hmap.get(c) == 0) counter-- ;
            }
            while(counter == 0){
                char temp  = s.charAt(begin);
                if(hmap.containsKey(temp)){
                    hmap.put(temp,hmap.get(temp) + 1);
                    if(hmap.get(temp) > 0)
                        counter++ ;
                }
                if(end - begin + 1 == p.length()){
                    result.add(begin);
                }
                begin++;
            }
            end++;
        }
        return result ;
    }
}