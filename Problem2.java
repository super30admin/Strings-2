//Time complexity-O(n+m)
//Space complexity-O(m)
//Ran on leetcode-Yes
//Solution with comments-
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<p.length();i++)
            map.put(p.charAt(i),map.getOrDefault(p.charAt(i),0)+1);
        List<Integer> output= new ArrayList<>();
        int start=0, end=0;
        int match=0;
        while(end<s.length()){
            char ch= s.charAt(end);
            //Incoming
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)-1);
                
                if(map.get(ch)==0){
                    match++;
                }
            }
            //Outgoing
             if(end-start+1>p.length()){
                char out= s.charAt(start);
                if(map.containsKey(out)){
                    map.put(out,map.get(out)+1);
                    
                    if(map.get(out)==1){
                        match--;
                    }
                }
              start++;
             }
             if(match==map.size()){
                 output.add(start);
             }
            end++;
        }
        return output;
    }
}