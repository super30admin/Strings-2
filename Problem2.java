
// Time Complexity: O(m + n) where m is the length of s and n is the length of p
// Space Complexity: O(1)

// We will use sliding window technique to find all anagrams of p in s
// We will use a hashmap to store the frequency of characters in p
// We will then slide the window over s and update the frequency of characters in the current window
// If the frequency of characters in the current window matches the frequency of characters in p, 
// we will add the starting index of the window to the result list
// We will use a match variable to keep track of the number of characters that have matched
// If the frequency of a character becomes zero, we will increment the match variable
// If the frequency of a character becomes one, we will decrement the match variable
// If the match variable is equal to the size of the hashmap, we have found an anagram

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res=new ArrayList<>();
        HashMap<Character,Integer> map=new HashMap<>();
        int n=s.length(),m=p.length(),match=0;

        for(char c:p.toCharArray())
            map.put(c,map.getOrDefault(c,0)+1);
        
        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            if(map.containsKey(c)){
                int freq=map.get(c);
                freq--;
                map.put(c,freq);
                if(freq==0)
                    match++;
            }
            if(i>=m){
                char out=s.charAt(i-m);
                if(map.containsKey(out)){
                int freq=map.get(out);
                freq++;
                map.put(out,freq);
                if(freq==1)
                    match--;
                }
            }
            if(match==map.size())
                res.add(i-m+1);
        }
        return res;
    }
}