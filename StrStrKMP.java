/**
 * Time Complexity : O(m+n)  where n is the length of the string 1 and m is the length of string 2
 * Space Complexity : O(1) 
 */

public class StrStrKMP {
    public int strStr(String haystack, String needle) {
        if(needle == "" || needle.length() == 0){return 0;}
        int[] table = new int[needle.length()];                                             
        int start =0;                                                                                             
        int m = haystack.length();
        int i = 1;
        table[start] = 0;                                                               
        while(i < needle.length()){
            if(needle.charAt(start) == needle.charAt(i)){                           
                start++;
                table[i] = start;                                                               
                i++;
            } else 
            if(start > 0 && needle.charAt(start) != needle.charAt(i)){                                  
                start = table[start-1];
            } else 
            if(start == 0 && needle.charAt(start) != needle.charAt(i)){                    
                table[i] =  0;
                i++;
            }
        }
        i=0;
        int j = 0;
        while(i < m){                                                                       
            if(haystack.charAt(i) == needle.charAt(j)){
                i++;                                                                                    
                j++;
            }
            if(j == needle.length()){                                                                   
                return i - needle.length();}
            else
            if(i < m && j > 0 && haystack.charAt(i) != needle.charAt(j)){
                j = table[j-1];                                                                 
            } else
            if(i < m && j == 0 && haystack.charAt(i) != needle.charAt(j)){                          
                i++;
            }
        }
        return -1;                                                                          
}
}