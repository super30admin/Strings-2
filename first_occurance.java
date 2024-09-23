    // time complexity:O(n)
//space complexity:O(1)
class Solution {
    public int strStr(String haystack, String needle) 
    {
        for(int i=0, j=needle.length();j<=haystack.length(); i++,j++)
        {   
            if(haystack.substring(i,j).equals(needle))
            {
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        String haystack="sadbutsad";
        String needle="sad";
        Solution s= new Solution();
        int ans=s.strStr(haystack, needle);
        System.out.println(ans);
    }
}

