class StrStr {
    
    // --------------------------- KMP Algorithm --------------------------------
    // ---------------------- Longest Prefix Suffix -----------------------------
    
    // Time Complexity: O(n+m)    (where n -> haystack length)
    // Space Complexity: O(m)   (where m -> needle length)
    
    public int strStr(String haystack, String needle) {
        // If the needle is empty --> then it is always present in the haystack
        if(needle.length() == 0)
            return 0;
        if(haystack == null || haystack.length() == 0)
            return -1;
        
        int[] lps = LPS(needle);
        
        int i = 0, j = 0;
        while(i < haystack.length()){   // n + m + c
            if(haystack.charAt(i) == needle.charAt(j)){
                i++; j++;
                if(j >= needle.length())
                    return i - j;
            }else if(j != 0 && haystack.charAt(i) != needle.charAt(j)){
                j = lps[j - 1];
            }else if(j == 0 && haystack.charAt(i) != needle.charAt(j))
                i++;
        }
        return -1;
    }
    
    private int[] LPS(String needle){   
        int i = 1;
        int j = 0;
        
        int[] lps = new int[needle.length()];
        while(i < needle.length()){
            if(needle.charAt(i) == needle.charAt(j)){
                j++;
                lps[i] = j;
                i++;
            }else if(j != 0 && needle.charAt(i) != needle.charAt(j)){
                j = lps[j-1];
            }else if(j == 0 && needle.charAt(i) != needle.charAt(j)){
                lps[i] = 0;
                i++;
            }
        }
        return lps;
    }
}