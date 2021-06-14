
//Time: O(m) where m =  of s string
//space: O(n) where n = size of p string
//Did it run successfully on leetcode: yes
class FindAllAnagaramsInString {
    public List<Integer> findAnagrams(String s, String p) {
        //list to store our results
        List<Integer> res = new ArrayList<>();
        //map to keep track of count of charcters
        HashMap<Character, Integer> map = new HashMap<>();
        //looping through pattern
        for(int i=0; i<p.length(); i++){
            //fetching current character
            Character c = p.charAt(i);
            //adding count of character to map
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        //variable to store number of characters matched
        int match = 0;
        //looping thorugh query string
        for(int fast=0; fast<s.length(); fast++){
            //getting current character
            Character in = s.charAt(fast);
            //if character exists in map
            if(map.containsKey(in)){
                //get count fo charatcer
                int count = map.get(in);
                //reduce count
                count--;
                //add back to map
                map.put(in, count);
                //if count is zero
                if(count==0){
                    //increement match
                    match++;
                }
            }
            //if we have a window of size of pattern string
            if(fast>=p.length()){
                //get previous character just before the start of window
                Character out = s.charAt(fast-p.length());
                //check if the character exist in map
                if(map.containsKey(out)){
                    //get count fo charatcer
                    int count = map.get(out);
                    //increase count
                    count++;
                    //add back to map
                    map.put(out, count);
                    //if count is one
                    if(count==1){
                        //decreement match
                        match--;
                    }
                }
            }
            //if we found all the match
            if(match == map.size()){
                //add the start index of window to result
                res.add(fast-p.length()+1);
            }
        }
        return res;
    }
}