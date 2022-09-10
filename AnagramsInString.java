//Approach-3 : HaspMap, Two Pointers, Sliding Window
//Time Complexity : O(m)
//Space : Complexity : O(1) // In worst case O(26) alphabets
class Solution { 
    
    
    public List<Integer> findAnagrams(String s, String p) {
        

        List<Integer> result = new ArrayList<>();
        
        if(p.length() > s.length()) return result;
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        
        
        for(int i=0; i< p.length(); i++){
            char c = p.charAt(i);
            map.put(c, map.getOrDefault(c,0)+1); 
        }
        
        int slow=0;
        int match = 0;
        for(int i=0; i<s.length(); i++){
            char ic = s.charAt(i); //incoming Character

            
            if(map.containsKey(ic)){ 
                int count = map.get(ic);
                count --;
                if(count == 0) match ++;
                map.put(ic, count);   
            }
            
            if(i >= p.length()){
                char oc = s.charAt(i-p.length());// outgoing Character
                if(map.containsKey(oc)){
                    
                  int count = map.get(oc);
                  count++;
                  if(count == 1) match--;
                  map.put(oc, count);
              }
            }
            
            if(map.size() == match){
                result.add(i-p.length()+1);   
            }
            
        }
    return result;
    }
}


//Approach-1 : Brute Force, sort and compare
//Time Complexity :  O(m*nlogn)
//Space : Complexity : O(1)

//Approach-2 : HaspMaps and compare them
//Time Complexity : O(mn)
//Space : Complexity : O(1)

