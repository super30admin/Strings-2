// Time Complexity : o(n) n=s.length 
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

//slidingwindow in out matching problem matching size of hash map when in became 0 match++ and out became 1 do match--


// Your code here along with comments explaining your approach

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
     List<Integer> result= new ArrayList<>();   
        HashMap<Character,Integer> map = new HashMap<>();
        int match =0;
        for(int i=0;i<p.length();i++){
            char c=p.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        
        for(int i=0;i<s.length();i++){
            char in=s.charAt(i);
            if(map.containsKey(in)){
                int value=map.get(in)-1;
                map.put(in,value);
                if(value==0){
                    match++;
                }
            }
            if(i>=p.length()){
                char out=s.charAt(i-p.length());
                if(map.containsKey(out)){
                    int value=map.get(out)+1;
                    map.put(out,value);
                    if(value==1){
                    match--;                       
                    }
                }
            }
            if(match==map.size()){
                result.add((i-p.length())+1);
            }
        }
        return result;
    }
}