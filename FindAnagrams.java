// Time Complexity : The time complexity is O(n) where n is the length of String s
// Space Complexity : The space complexity is O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> output = new ArrayList<>();

        Map<Character,Integer> map = new HashMap<>();

        int count = 0;

        // store the frequency of each character
        for(int i=0;i<p.length();i++){
            char c = p.charAt(i);

            // Each unique character
            if(!map.containsKey(c)){
                count++;
            }

            map.put(c,map.getOrDefault(c,0)+1);
        }

        int start = 0;
        int end = 0;

        while(end < s.length()){

            char c = s.charAt(end);

            if(map.containsKey(c)){
                map.put(c,map.get(c)-1);
                if(map.get(c) == 0){
                    count--;
                }
            }

            while(count == 0){

                char ch = s.charAt(start);
                if(map.containsKey(ch)){

                    map.put(ch,map.get(ch)+1);

                    if(map.get(ch) == 1){
                        count++;
                    }
                }

                // If the length of p is equal to length of sub string of s then, its an anagram
                if(end-start+1 == p.length()){
                    output.add(start);
                }

                start++;
            }

            end++;
        }

        return output;

    }
}