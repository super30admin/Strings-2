//Time complexity O(n)
//Space complexity O(n)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

//Logic is to store the pattern in the hashmap with 1 count. Now we check for incoming and outgoing characters in the s string. if it's in character, we
//decrease the count in HashMap and if it's out character we increase the count in hashmap. If the count is 1 we increment the match and if the match is equal to the
//size of hashmap, we have found the pattern

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        
        HashMap<Character,Integer> map1 = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        
        for(int i = 0; i < p.length(); i ++){
            
            char ch = p.charAt(i);
            
            map1.put(ch, map1.getOrDefault(ch,0) + 1);
        }
       // System.out.println(map1);
        int match = 0;
        for(int i = 0; i < s.length(); i ++)
        {   
            char in = s.charAt(i);
            if(map1.containsKey(in)){//for incoming characters
                
                int count = map1.get(in);
                count = count - 1;
                map1.put(in,count);
                if(count == 0){
                    
                    match ++;
                   
                }
            }
            
            if(i >= p.length()){//for outgoing characters
                
                char out = s.charAt( i - p.length());
              if(map1.containsKey(out)){
                //match --;    
                int count = map1.get(out);
                count = count + 1;
                map1.put(out,count);
                      if(count == 1){
                          
                          match --;
                      }
                       
                   }
                
            }
          //  System.out.println("match"+ match);
            if(match == map1.size()){
                      //  System.out.println("hitting");
                        result.add(i + 1 - p.length());
                        //slwPtr = fastPtr + 1;
                    }
             
            
        }        
        return result;
    }
}