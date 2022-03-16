class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        HashMap< Character, Integer> map = new HashMap<>();
        List<Integer> result= new ArrayList<>();
        int a=0;
        int count1=0;
        for(int i=0; i<p.length();i++){
            //in
            char in= p.charAt(i);
            if(map.containsKey(in)){
                map.put(in, map.get(in)+1);
            }
               else{
                 map.put(in,1);
               } 
        }
        for(int i=0; i<s.length(); i++){
            //in
            char in= s.charAt(i);
              if(map.containsKey(in)){
                 map.put(in, map.get(in)-1);
                if( map.get(in) == 0 ) count1++;
               
            } 
            //out
             if(i >= p.length()) {
                  char out= s.charAt(a);
                if(map.containsKey(out)){
                  map.put(s.charAt(a), map.get(s.charAt(a))+1); 
                     if( map.get(out) == 1 ) count1--;
                } 
                a++;  
            }
            if(count1== map.size()) {
                result.add(a);
            }    
        }
        return result;
    }
}

// Time complexity- O(s.length)
// Space complexity- O(1) since p can be max 26