
// Time Complexity : O(m+n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach



public int StrStr(string haystack, string needle) {
        
    if(String.IsNullOrEmpty(needle))
        return 0;
    
    int[] lps = lpsNeedle(needle);
    int m = haystack.Length;
    int n = needle.Length;
    int i = 0; //index in haystack
    int j = 0; //index in needle
    
    while(i < m)
    {
        if(haystack[i] == needle[j])
        {
            i++;
            j++;
            
            if(j == n)
                return i - n;                                
        }
        else if(haystack[i] != needle[j] && j > 0)
            j = lps[j-1];
        else if(haystack[i] != needle[j] && j == 0)
            i++;
    }
    
    //nothign matches, return -1
    return -1;

}

private int[] lpsNeedle(string needle)
{
    int[] lps = new int[needle.Length];

    int i = 1, j = 0;

    while(i < needle.Length)
    {

        //prefix and suffix matvhes, keep increment unitl char match and set lps value
        //lps value teells max prefix and suffix matched between index i and j
        if(needle[i] == needle[j])
        {
            j++;
            lps[i] = j;
            i++;
        }
        else if(needle[i] != needle[j] && j > 0)
        {
            //we can just take lps value of previous index of j, because we already know the lps value so far
            //we could decrement j one by one but there is no need.
            j = lps[j-1];
        }
        //j is start of string, prefix and suffix doesnt match, set lps to 0
        else if(needle[i] != needle[j] && j == 0)
        {
            lps[i] = 0;
            i++;
        }
    }
    return lps;
}








//TC: O(m*n)
public int StrStr(string haystack, string needle) {
        
    if(String.IsNullOrEmpty(needle))
        return 0;
    
    int m = haystack.Length;
    int n = needle.Length;
    int i = 0;
    
    //we can check upto length of m-n, because once we rach index m-n, we just need to check next
    //ncharcters in m if it match or not
    while(i <= m - n)
    {
        if(haystack[i] == needle[0]){
            int j = 0; //index in needle
            int k = i; //temp index in haystack to compare to needle length
            while(j < n && k < m && haystack[k] == needle[j])
            {
                k++;
                j++;
            }
            
            //it means we rached end of needle, all chars matched in haystack
            if(j == n)
                return i;
        }
        i++;
    }
    //nothign matches, return -1
    return -1;
}