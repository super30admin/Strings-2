//Rabin - Karp Algorithm
//TC - O(m + n)
//SC - O(1)

class Solution {
    int prime = 101;
    
    public int strStr(String haystack, String needle) {
        if(haystack == null || needle == null) return -1;
        
        int ndHash = 0;
        for(int i = 0; i < needle.length(); ++i)
        {
            ndHash += (needle.charAt(i) -'a' + 1) * Math.pow(prime, i);
        }
        
        int n = needle.length();
        int currHash = 0;
        for(int i = 0; i + n - 1 < haystack.length(); ++i)
        {
            if(i == 0)
            {
                for(int j = 0; j < n; ++j)
                {
                    currHash += (haystack.charAt(j) - 'a' + 1) * Math.pow(prime, j);
                }
            }
            else
            {
                currHash -= (haystack.charAt(i-1) - 'a' + 1);
                currHash /= prime;
                currHash += (haystack.charAt(i + n - 1) - 'a' + 1) * Math.pow(prime, n-1);
            }
            
            if(currHash == ndHash)
            {
                String sub = haystack.substring(i, i + n);
                boolean flag = false;
                for(int k=0; k < n; ++k)
                {
                    if(sub.charAt(k) != needle.charAt(k))
                    {
                        flag = true;
                        break;
                    }
                }
                
                if(flag == false)
                    return i;
            }
        }
        
        return -1;
    }
}

//KMP
//TC - O(m + n)
//SC - O(1)

class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack == null || needle == null) return -1;
        
        //building LPS array
        int[] LPS = new int[needle.length()];
        
        int j = 0, i = 1;
        
        while(i < needle.length())
        {
            if(needle.charAt(i) == needle.charAt(j))
            {
                ++j;
                LPS[i] = j;
                ++i;
            }
            else if(needle.charAt(i) != needle.charAt(j) && j > 0)
            {
                j = LPS[j-1];
            }
            else if(needle.charAt(i) != needle.charAt(j) && j == 0)
            {
                LPS[i] = 0;
                ++i;
            }
        }
        
        
        i = 0;
        j = 0;
        
        while(i < haystack.length() && j < needle.length())
        {
            if(haystack.charAt(i) == needle.charAt(j))
            {
                ++i;
                ++j;
            }
            else if(haystack.charAt(i) != needle.charAt(j) && j > 0)
            {
                j = LPS[j-1];
            }
            else if(haystack.charAt(i) != needle.charAt(j) && j == 0)
            {
                ++i;
            }
        }
        
        if(j == needle.length())
            return i - j;
        return -1;
    }
}

//Brute Force
//TC - O(mn)
//SC - O(1)

class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack.length() == 0 && needle.length() == 0) return 0;
        
        int start = 0;
        
        while(start < haystack.length())
        {
            int i = start;
            int j = 0;
            
            while(j < needle.length() && i < haystack.length())
            {
                if(haystack.charAt(i) == needle.charAt(j))
                {
                    ++i;
                    ++j;
                }
                else
                {
                    break;
                }
            }
            
            if(j == needle.length())
            {
                return start;
            }
            else
            {
                ++start;
                j = 0;
            }
        }
        
        return -1;
    }
}
