//n=length of haystack
//m=length of needle
//c=constant
//Time Complexity: O(n+c) + O(m+c) -> for strStre and calculate LPS
//Space complexity: O(m)
//Did it run on leetcode: yes

class Solution {
    public int strStr(String haystack, String needle) {
        //base case
        if(needle==null || needle.length()==0)
            return 0;
        
        //calculate LPS of needle
        int[] LPSneedle = calculateLPS(needle);
        
        
        //Implement KMP algorithm to find substring
        //Pointer i is for haystack
        //and j is for needle
        int i=0;
        int j=0;
        while(i<haystack.length()){
            char ch1 = haystack.charAt(i);
            char ch2 = needle.charAt(j);
            
            if(ch1==ch2){
                i += 1; 
                j += 1;
            }
            
            if(j >= needle.length() && ch1==ch2)
                return i-j;
            
            else if(j>0 && ch1!=ch2)
                j = LPSneedle[j-1];
            
            else if(j==0 && ch1!=ch2)
                i++;
        }
        
        return -1;
    }
    
    private int[] calculateLPS(String s){
        int[] sLPS = new int[s.length()];
        sLPS[0] = 0;
        int i = 1;
        int j = 0;
        while(i<s.length()){
            char ch1 = s.charAt(i);
            char ch2 = s.charAt(j);
            
            if(ch1==ch2){
                j += 1;
                sLPS[i] = j;
                i += 1;
            }
            
            else if(j>0 && ch1!=ch2)
                j = sLPS[j-1];
            
            else if(j==0 && ch1!=ch2){
                sLPS[i] = 0;
                i += 1;
            }
        }
        
        return sLPS;
    }
}
