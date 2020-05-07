//TC:O(M+N)
//SC:O(M)
class Solution {
    public int strStr(String haystack, String needle) 
    {
        if(needle.length()==0) return 0;
        
        if(haystack.length()<needle.length()) return -1;
        
       int temp[] =  new int[needle.length()];
       
       int  n1 = needle.length();
       int  n = haystack.length();

        int i=0;
        int j=1;
        temp[0]=0;
        while(j<n1)
        {
          if(needle.charAt(j)==needle.charAt(i))
          {  
              temp[j]=i+1;
              i++;
              j++;
          }
          else if(i!=0 && needle.charAt(j)!=needle.charAt(i))
          {
              i=temp[i-1];   
          }
          else if(i==0 && (needle.charAt(j)!=needle.charAt(i)) )
          {
             temp[j]=0; 
             j++;  
          } 
        
        }
        
       for(int l=0;l<temp.length;l++) 
           System.out.println(temp[l]);
        
        
        i=0;
        j=0;
        
        while(i<n)
        {
           if(haystack.charAt(i)==needle.charAt(j))
           {
              i++;
              j++;
              if(j==n1) return (i-n1);
           }
           else if((j==0) && (haystack.charAt(i)!=needle.charAt(j)) ) 
                 i++;
           else if((haystack.charAt(i)!=needle.charAt(j)) )
           {
               j=temp[j-1]; 
           } 
        }
  
    return -1;    
        
    }
}