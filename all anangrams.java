//Timecomplexity:-O(m+n);
//spacecomplexity:- O(m);
//Did it run on leetcode:- yes;
//What problems did you face?:- missed many edge cases.
//Your code with explanation:- simle sliding window but updation of hashmaps at end pointer incrementering and slow pointer incrementing accordingly.



class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> output=new ArrayList<Integer>();
        if(p.length()==0 || p==""){
            return output;
        }
        HashMap<Character,Integer> cache=new HashMap<>();
        for(char ch:p.toCharArray()){
            cache.put(ch,cache.getOrDefault(ch,0)+1);
            
        }
        int start=0;
        int end=0;
        int formed=0;
        while(end<s.length()){
            if(cache.containsKey(s.charAt(end))){
                cache.put(s.charAt(end),cache.get(s.charAt(end))-1);
                if(cache.get(s.charAt(end))==0){
                    formed++;
                }
            }
            if(end-start+1>p.length()){
                if(cache.containsKey(s.charAt(start))){
                    cache.put(s.charAt(start),cache.get(s.charAt(start))+1);
                    if(cache.get(s.charAt(start))==1){
                        formed--;
                }
           
            }
                start++;
            }
        
            if(formed==cache.size()){
                output.add(start);
            }
            end++;
        }
        
   return output; }
}