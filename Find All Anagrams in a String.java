// Time Complexity : O(m+n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        //create the result array
        List<Integer> res = new ArrayList<>();
        //create the hash map to hold the string p
        HashMap<Character, Integer> hash = new HashMap<>();
        //start a for loop that will iterate through p and populate the hashmap with instance of each character
        for(int i = 0; i < p.length(); i++){
            //get char
            char c = p.charAt(i);
            hash.put(c,hash.getOrDefault(c,0) + 1);
        }
        //create a count to check if hash size is same as number of char gone to 0
        int count = 0;
        //start a for loop to iterate through s
        for(int i = 0; i < s.length(); i++){
            //check incoming
            char in = s.charAt(i);
            if(hash.containsKey(in)){
                //get the count of the char 
                int c = hash.get(in);
                //reduce the count and add first check if it equals to 0 if so increase the count by 1
                c--;
                if(c == 0) count++;
                //add the count back into the map
                hash.put(in,c);
            }
            //out bound
            //check if the bounds of window is less than ith index
            if(i >= p.length()){
                //get the out going char
                char out = s.charAt(i - p.length());
                if(hash.containsKey(out)){
                    //get count of the char
                    int c = hash.get(out);
                    //increment count cause we alraedy used this char and it is going out
                    c++;
                    //if the count == 1 then decrase our match by one because a letter has been added back into the hash
                    if(c == 1) count--;
                    hash.put(out,c);
                }
            }
            //now finally check if count is the same size as the hash then put in the slow pointer index into the result list
            if(count == hash.size()) res.add(i-p.length() + 1);
        }
        //return list
        return res;
    }
}