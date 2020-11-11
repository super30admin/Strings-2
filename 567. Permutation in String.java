class Solution {// same as 438 find all anagrams
    public boolean checkInclusion(String s1, String s2) {
         List<Integer> result = new LinkedList<>();
        
        //Anagrams size greater than the string
        if(s2.length() < s1.length())
            return false;
        
        // Build the hashmap
        HashMap<Character, Integer> hmap = new HashMap<>();
        for(char c:s1.toCharArray()){
            hmap.put(c, hmap.getOrDefault(c,0)+1);
        }
        int counter = hmap.size() ;
        int begin = 0, end = 0;
        
        while(end < s2.length()){
            char c = s2.charAt(end);
            if(hmap.containsKey(c)){
                hmap.put(c, hmap.get(c) - 1);
                if(hmap.get(c) == 0) counter-- ;
            }
            while(counter == 0){
                char temp  = s2.charAt(begin);
                if(hmap.containsKey(temp)){
                    hmap.put(temp,hmap.get(temp) + 1);
                    if(hmap.get(temp) > 0)
                        counter++ ;
                }
                if(end - begin + 1 == s1.length()){
                    return true;
                }
                begin++;
            }
            end++;
        }
        return false ;
    }
}