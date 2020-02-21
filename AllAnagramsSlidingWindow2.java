//TC : O(m+n)
//SC : O(n)
class Solution {
    HashMap<Character,Integer> map = new HashMap<>();
    HashMap<Character,Integer> map2 = new HashMap<>();

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        
        if(p.length() == 0 || p == null)
            return result;
     
        if(s.length() < p.length())
            return result;

        //Create a hashmap for pattern     
        for(Character c : p.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        
        
        for(int i=0;i<s.length();i++){
            Character c = s.charAt(i);

            //Until window size, keep adding to map2
            if(i < p.length()){
                
                map2.put(c,map2.getOrDefault(c,0)+1);
                if(map.equals(map2))
                    result.add(i-p.length()+1);

            }
            else{
                //Remove the prev character from hashmap
                Character prev = s.charAt(i-p.length());
               
                if(map2.get(prev) == 1){  
                    map2.remove(prev);
                }
                else{
                    map2.put(prev,map2.get(prev)-1);
                }
                
                //Add character at i into map2
                map2.put(c,map2.getOrDefault(c,0)+1);
              
                //Compare two maps
                if(map.equals(map2))
                    result.add(i-p.length()+1);
            }
          

        }
        
        return result;
    }

}