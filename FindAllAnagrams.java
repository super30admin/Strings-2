// Time Complexity : O(n) where n is size of string s
// Space Complexity : O(m) where p is size of string p
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Create a hashmap where we will store all the characters and frequencies form string p
//Now we will traverse each character from the string s
//If the character is part of the hashmap then we will decrement its count in hashmap
//If we have move past the size of p traversing string we need to increment its frequecies in hashmap since its eleminated
//Whenever a certain char is completely decremented to 0 then it means all its characters are found and we can increment anaCharCount
//Similar way we will do opposite in case of increment. 
//Finally we will check for anaCharCount with the size of hashMap, if they are equal
//We will add it to answer list.

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character, Integer> ana = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        int anaCharCount = 0;
        for(int i = 0; i < p.length(); i++){
            char c = p.charAt(i);
            ana.put(c,(ana.getOrDefault(c,0)+1));
        }
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            //add from end
            if(ana.containsKey(c)){
                ana.put(c,(ana.get(c)-1));
                if(ana.get(c) == 0)
                    anaCharCount++;
            }
            //remove from start
            if(i >= p.length()){
                char c1 = s.charAt(i-p.length());
                if(ana.containsKey(c1)){
                    ana.put(c1,(ana.get(c1)+1));
                    if(ana.get(c1) == 1)
                    anaCharCount--;
                } 
            }  
            //check
            if(anaCharCount == ana.size())
                ans.add(i - p.length() + 1);
        }
        return ans;     
    }
}