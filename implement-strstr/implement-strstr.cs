public class Solution {
    public int StrStr(string haystack, string needle) {
        int l = haystack.Length - needle.Length;
        
        for(int i=0;i<=l;i++)
        {
            int j=i;
            foreach(var ch in needle)
            {
                if(ch!=haystack[j])
                {
                    break;
                }
                j++;
            }
            if(j-i != needle.Length)
            {
                continue;
            }
            return i;
        }
        return -1;
        
    }
}
