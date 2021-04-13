//TC: O(n+m)
//SC: O(m) hashmap size

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> output = new ArrayList<>();
        if(s.length()==0 || p.length()==0)
           return output;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0;i<p.length();i++)
            map.put(p.charAt(i),map.getOrDefault(p.charAt(i),0)+1);
        
        int start = 0, end = 0; int match = 0;
        while(end<s.length())
        {
            char ch = s.charAt(end);    //Adding the target string to hashmap with it's count.
            if(map.containsKey(ch))     //Traversing through each value of the search string if the char is available in hashmap reduce the count of the char value.
            {
                map.put(ch , map.get(ch)-1);
                if(map.get(ch)==0)      //After reducing if the value is 0, increase match count
                    match++;
            }                           //If the window of string is more than the target string increase the start value, if map contains the start index increment the hashmap value of particular char.
                
            if(end-start+1>p.length())  //After increment the value reachs 1 decrement match value. If match and hashmap size matches add the index to output list;
            {
                char sChar = s.charAt(start);
                if(map.containsKey(sChar))
                {
                    map.put(sChar , map.get(sChar)+1);
                    if(map.get(sChar)==1)
                        match--;
                }    
                start++;
            }
            if(match==map.size())
            {
                output.add(start);
            }
            end++;
        }
        return output;
    }
}