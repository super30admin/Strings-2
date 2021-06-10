public class ImplementStrStrBruteForce2 {
    public int strStr(String haystack, String needle) {
        int hayStackLength = haystack.length();
        int needleLength = needle.length();
        if(needleLength==0)
            return 0;
        int i=0; int j=0; 
        while(i<= hayStackLength-needleLength)
        {
            int k = i;
            j = 0;
            if(haystack.charAt(i)==needle.charAt(j))
            {
                while(j<=needleLength-1 && k<= hayStackLength-1 && haystack.charAt(k)==needle.charAt(j))
                {
                    j++;
                    k++;
                }
                if(j == needleLength)
                    return i;
            }
            i++;
        }
        return -1;
    }
}
