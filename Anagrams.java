class Solution {
    public List<Integer> findAnagrams(String s, String p) 
    {
        List<Integer> result = new ArrayList<>(); // Create a list to store final result.
        Map< Character , Integer> map = new HashMap<>(); // create map to keep count of characters in string p.
        
        int match = 0;
    
    for(char a : p.toCharArray())   
        {
            if(!map.containsKey(a))map.put(a,1); // Keep a count of the characters in P string.
            else
                map.put(a,map.get(a)+1);
        }
        
        for( int i=0;i<s.length();i++)  // to check for each character in String S.
        {
            // For IN : // Check if the element present in HashMap. Adjust Match variable if found in String S.
            char a = s.charAt(i);
            if(map.containsKey(a))
            {
                map.put(a,map.get(a)-1);
              if(map.get(a)==0)
                {
                match++;
                }
            }
            
            //for OUT :
            if(i>=p.length())
            {
                a=s.charAt(i-p.length());
                 if(map.containsKey(a))
                 {
                     map.put(a,map.get(a)+1);
                     if(map.get(a)==1)
                     {
                        match--;
                     }
                 }
            }
            if(match==map.size()) result.add(i-p.length()+1); // If map size is same as match size, that is all elements have matched, add the starting index.
        }
        
        
       return result; 
    }
}
        