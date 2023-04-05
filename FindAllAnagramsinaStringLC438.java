class Solution {
    
    
    //Time Complexity: O(m), m= length of s, n= length of p
    //Space Complexity: O(1)
    public List<Integer> findAnagrams(String s, String p) {
       
        List<Integer> result = new ArrayList<>();
        
        if(p.length() > s.length()) return result;
        
        Map<Character, Integer> map = new HashMap<>();
            
        for(int i=0; i< p.length(); i++){
            
            char ch = p.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);   
        }
        
        int i=0; 
        int match = 0;
                 
        while(i < s.length()){
            
            //incoming
            char inChar = s.charAt(i);
            
            if(map.containsKey(inChar)){
                
                int freq = map.get(inChar);
                
                freq--;
                map.put(inChar, freq);
                
                if(freq == 0){
                    match++;
                } 
            }
            
            //outgoing
            if(i>= p.length()){
                
                char outChar = s.charAt(i - p.length());
                
                if(map.containsKey(outChar)){

                    int freq = map.get(outChar);
                    freq++;
                    map.put(outChar, freq);

                    if(freq == 1){
                        --match;
                    }
                }
            }
            
            if(match == map.size()){
                
                result.add(i - p.length() + 1);
            }
            i++;
        }
        return result; 
    }
    
    
    
    //Time Complexity: O(m+n), m= length of s, n= length of p
    //Space Complexity: O(1)
//     public List<Integer> findAnagrams(String s, String p) {
        
//         List<Integer> result = new ArrayList<>();
        
//         int[] pArr = new int[26];
        
//         for(int i=0; i< p.length(); i++){
            
//             ++pArr[p.charAt(i) - 'a'];
            
//         }
        
//         int[] sArr = new int[26];
        
//         for(int i=0; i< s.length(); i++){
            
//             ++sArr[s.charAt(i) - 'a'];
            
//             if(i >= p.length()){
                
//                 --sArr[s.charAt(i - p.length()) - 'a'];
                
//             }
            
//             if(i>=p.length()-1){
//                 if(Arrays.equals(pArr, sArr)){

//                     result.add(i-p.length() + 1);
//                 }
//             }
            
            
//         }
//         return result;
        
//     }
}
