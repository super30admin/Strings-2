
// Time Complexity : O(N^2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
/*Approach
1) In this we first check if needle belongs to haystack
-> if yes we return the start index
-> if not we return 0
2) thus initially we have a null check
3) we run the loop from m-n+1 (starting at index 0) and haystack length - needle length
4) whenever first character of needle starts with haystack we start the inner while loop and assign k and j 
5) i will run on haystack and j would run on needle
6) j is assigned to 0 as we need to check from start of needle (coz it belongs to haystack)
7) if it belongs we increment k and j both else break. when j == n then we know we have reached end of n (needle length)
8) we return k-n and not i-n, the reason as we move to k with every iteration if we match the further characters of haystack and needle
-> while(j<n && k<m)
                {
                    if(haystack.charAt(k) == needle.charAt(j))
                    {
                        j++;
                        k++;
    we increase k and j each time

*/


public class ImplementStrStr {

    public int strStr(String haystack, String needle) {
        
        if(needle==null || needle.length()==0)
        {
            return 0;
        }
        
        int m = haystack.length();
        int n = needle.length();
        
        for(int i=0;i<m-n+1;i++)
        {
            if(haystack.charAt(i)==needle.charAt(0))
            {
                int k = i;
                int j=0;
                
                while(j<n && k<m)
                {
                    if(haystack.charAt(k) == needle.charAt(j))
                    {
                        j++;
                        k++;
                    }
                    else
                    {
                        break;
                    }
                    
                }
                
                if(j==n)
                {
                    return k-n;
                }
            }
        }
        
        return -1;
    }


}
