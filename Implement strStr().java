//Time:O(n)
//Space: O(1)_
class Solution {
    public int strStr(String haystack, String needle) {
        int ans=-1;
        for( int i=0;i<haystack.length();i++)
        {
            char c= haystack.charAt(i);
            if(c==needle.charAt(0)){
                
                if(haystack.substring(i).length()<needle.length()){
                    return -1;
                }
                int p=0;
                
                while(p<needle.length()){
                    
                   if(needle.charAt(p)!=haystack.charAt(i+p)){
                       break;
                   }//System.out.println(p+" "+(p+i));
                    p++;
                    if(p==needle.length()){return i;}
                }
                
            }
            
            
        }
        return ans;
        
    }
}
