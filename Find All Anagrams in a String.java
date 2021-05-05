//TimeComplexity : O(m)+O(n). n is the size of string p and m is the size of string s
//Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no
// Your code here along with comments explaining your approach
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if(s==null||s.length()==0){
            return result;
        }
        //use a hash map to store all the characters in the p initially
        HashMap<Character,Integer> map = new HashMap<>();
        int match =0;//keep track of matched characters
        for(int i=0;i<p.length();i++){
            char c = p.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        //iterate through the string s
        for(int i=0;i<s.length();i++){
            //incoming character
            char in = s.charAt(i);
            //if this is present in the map then a match has been found
            if(map.containsKey(in)){
                //decrement its occurence in map
                int count = map.get(in);
                count--;
                //update the count in the map
                map.put(in,count);
                //if the count is zero then this character is matched from p string
                if(count==0){
                    match++;
                }
            }
            //check for not matching characters
            if(i >= p.length()){
                //outgoing character is dound at index i-p.length()
                char out = s.charAt(i-p.length());
                //if the outgoing character is present in the map, then unmatch it
                if(map.containsKey(out)){
                    int count = map.get(out);
                    count++;
                    //update the count in the map
                    map.put(out,count);
                //if the count is one then this character is unmatched from string p
                    if(count==1){
                        match--;
                    }
                }
            }
            //if the match count is equal to length of map, then the substring is found in string s 
            if(match==map.size()){
                //i-p.length()+1 will have the starting index of the anaagram
                result.add(i-p.length()+1);
            }
        }
        return result;
    }
}