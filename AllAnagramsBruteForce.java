                                        *****METHOD 1******
//TC : O(m nlog n) where m and n are length of the string
//SC : O(1)

//TIME LIMIT EXCEEDED

//ALGO : Sort the character and compare each time if they are equal
class Solution {
    

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        
        if(p.length() == 0 || p == null)
            return result;
     
      
        for(int i=0;i<s.length()-p.length()+1;i++){
            String window = s.substring(i,i+p.length());
            if(isAnagram(window,p)){
               // System.out.println(window);
                result.add(i);
            }

        }
        
        return result;
    }
   
    private boolean isAnagram(String str,String p){
       
        char[] s1 = str.toCharArray();
        char[] s2 = p.toCharArray();
        
        Arrays.sort(s1);
        Arrays.sort(s2);


        if(Arrays.equals(s1,s2))
            return true;
        return false;
        
    }
}

                                        *****METHOD 2******
//Create two hashmaps
