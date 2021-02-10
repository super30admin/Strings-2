/*
method1 - take every possiblem substring of size p is string s. Check if its an anagram by making use of HM.
if yes, add index i to the result list.
Time complexity : O(m xn) 


method 2: 
will use hashmap to store occurence of string p. then use 2 pointers to keep track of incoming and outgoing character from the string.
for evey incoming character, if the count from map becomes 0 then we incease match. 
for every outgoing character, if char thr is map, we increase the count by 1  and then check if count == 1, then decrease match

when match == map.size, then add index i to result.

Time complextiy: O(m+n)
space complexity: O(1)

*/

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0;i < p.length();i++){
            char c = p.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        
        List<Integer> result = new ArrayList<>();
        int match =0;
        
        for(int i = 0;i < s.length();i++){
            char in = s.charAt(i);
            
            //increasing window
            if(map.containsKey(in)){
                int count = map.get(in);
                count--;
                if(count == 0) match ++;
                map.put(in,count);
            }
            //when current window reaches size p
            if(i >= p.length()){
                char out = s.charAt(i - p.length());
                if(map.containsKey(out)){
                    int count = map.get(out);
                    count++;
                    if(count == 1) match --;    //reduce match since we lost the matching character
                    map.put(out,count);
                }
            }
            
            if(match == map.size()){
                result.add(i - p.length() +1);
            }
            
        }
        return result;
    }
}