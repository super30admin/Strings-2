// Time Complexity : O(n) -> length of bigger string
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// Store characters and no of occurance in hash map
// Use sliding window to check incoming and outgoing characters
// Update hash map respectively and check number of elements matched 

class AnagramsString {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new ArrayList();
        HashMap<Character,Integer> map = new HashMap(); //map of pattern array
        // contains number of chars of each element

        if(p.length()>s.length()) return result;

        for(int i=0;i<p.length();i++){
            map.put(p.charAt(i), map.getOrDefault(p.charAt(i),0)+1);
        }

        int match =0; //number of matched elements
        for(int i=0;i<s.length();i++){

            if(i>=p.length()) {
                char out = s.charAt(i-p.length());
                if(map.containsKey(out)){
                    map.put(out,map.get(out)+1);
                    if(map.get(out) == 1) match--; 
                    //reduces match only when we require extra char
                    //not when extra char is present -> sliding window takes care of this
                }
            }    

            char in = s.charAt(i);
            if(map.containsKey(in)){
                map.put(in, map.get(in)-1);
                if(map.get(in) == 0) match++; //one char match found
            }

            if(match == map.size())  //number of unique characters (map size) should be matched
                result.add(i-p.length()+1); 
        }

        return result;
    }
}