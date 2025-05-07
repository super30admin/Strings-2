// TC => O(m*n)
// SC => O(1)
public class Solution
{
    public int StrStr(string haystack, string needle)
    {
        if (needle == null || needle.Length == 0 || haystack.Length < needle.Length)
        {
            return -1;
        }
        int firstIndex = -1;
        for (int i = 0; i < haystack.Length; i++)
        {
            if (haystack[i] == needle[0])
            {
                if (i + needle.Length > haystack.Length)
                {
                    return firstIndex;
                }
                var k = i + 1;
                firstIndex = i;
                for (int j = 1; j < needle.Length && k < haystack.Length; j++, k++)
                {
                    Console.WriteLine($"haystack[{k}] --> {haystack[k]}");
                    Console.WriteLine($"needle[{j}] --> {needle[j]}");
                    if (haystack[k] != needle[j])
                    {
                        firstIndex = -1;
                        break;
                    }
                }
                if (firstIndex != -1)
                {
                    return firstIndex;
                }
            }
        }
        return firstIndex;
    }

    //DifferentSolution

        // lps ==> longest prefix suffix
    // TC => O(m+n)
    // SC => O(n)
    public int StrStr(string haystack, string needle){
        if(needle == null || needle.Length == 0 || haystack.Length < needle.Length){
            return -1;
        }

        int m = haystack.Length;
        int n = needle.Length;
        int i = 0, j = 0;
        int[] lps = Lps(needle);
        while(i < m){
            if(haystack[i] == needle[j]){
                i++;
                j++;
                if(j == n){
                    return i - n;
                }
            }
            else{
                if(j > 0){
                    j = lps[j-1];
                }
                else if(j == 0){
                    i++;
                }
            }
        }
        return -1;
    }

    public int[] Lps(string needle){
        int n = needle.Length;
        int[] lps = new int[n];
        int i = 1, j= 0;
        lps[0] = 0;
        while(i < n){
            if(needle[i] == needle[j]){
                j++;
                lps[i] = j;
                i++;
            }
            else{
                if(j > 0){
                    j = lps[j-1];
                }
                else if(j == 0){
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}

