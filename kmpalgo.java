/*Time Complexity: o(2*max(m,n))
 *Space Complexity : o(n) n is the length of the needle
 *Expln: Used Kmp algorithm to store the prefix and suffix location and iterate through
 *the haystack by moving prefix length in needle if the char doesnt match and returning first location
 */
 class Solution {
    //Using Kmp Algorithm
    int[] arr;
    public int strStr(String haystack, String needle) {
        arr = new int[needle.length()];
        if(needle.length() ==0) return 0;
        arr = kmpArray(needle);
        int k = 0;
        int l = 0;
        while(l < haystack.length() && k < needle.length())
        {
            if(haystack.charAt(l) == needle.charAt(k))
            {
                k++;
                l++;
            }
            else
            {
                if(k >= 1){
                    k = arr[k-1];
                }
                else
                    l++;
            }
        }
        if(k == needle.length())
            return (l - needle.length());
        else 
            return  -1;
    }
    private int[] kmpArray(String needle)
    {
        int i = 0; int j =1;
        arr[i] = 0;
        while (j < needle.length())
        {  
            if(needle.charAt(i) == needle.charAt(j))
            {
                i++;
                arr[j] = i;
                j++;
            }
            else if(needle.charAt(i) != needle.charAt(j) && i != 0)
            {
                i = arr[i-1];
            }
            else if(needle.charAt(i) != needle.charAt(j) && i == 0)
            {
                arr[j] = 0;
                j++;
            }
        }
        return arr;
    }
}