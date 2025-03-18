public class Solution
{
    public int StrStr(string haystack, string needle)
    {
        int result = -1;
        if (needle.Length > haystack.Length)
        {
            return -1;
        }
        int m = haystack.Length;
        int n = needle.Length;
        int i = 0;
        while (i <= m - n)
        {
            if (haystack[i] == needle[0])
            {
                int j = 0;
                int k = i;
                while (haystack[k] == needle[j])
                {
                    k++;
                    j++;
                    if (j == n)
                    {
                        return i;
                    }
                }
            }
            i++;
        }
        return -1;

        // for(int i=0;i<haystack.Length;i++)
        // {
        //     int j=0;
        //     while((i+j)<haystack.Length && j<needle.Length)
        //     {
        //         if(haystack[i+j] != needle[j])
        //         {
        //             break;
        //         }
        //         j++;
        //     }
        //     if(j==needle.Length)
        //     {
        //         result = i;
        //         break;
        //     }
        // }
        // return result;
    }
}