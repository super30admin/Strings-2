//TC = O(N+M) where M is haystack.length();
//SC = O(N) where N is needle.length();

/*
    

    This is a classic example of KMP(Knuth Morris Pratt Algorithm) where
    we try to maintain index of longest proper prefix and longest proper suffix.
    


*/
import java.util.*;

public class ImplementStr
{
    public static int index(String haystack, String needle)
    {

        if(needle == null || needle.length() == 0)
        {
            return 0;
        }

        int n = needle.length();
        int m = haystack.length();
        
        int[] lps = lps(needle);

        int i =0,j=0;
        

        while(i < m)
        {
            if(haystack.charAt(i) == needle.charAt(j))
            {
                i++;
                j++;
                if(j==n)
                {
                    return i - n;
                }
                else if(haystack.charAt(i)!=needle.charAt(j) && j>0)
                {
                    j = lps[j-1];

                }
                else if(haystack.charAt(i)!=needle.charAt(j) && j==0)
                {
                    i++;
                }
            }
        }

        return -1;
    }


    private static int[] lps(String needle)
    {
        int lps[] = new int[needle.length()];
        int i = 1;
        int j = 0;

        while( i< needle.length())
        {
            if(needle.charAt(i) == needle.charAt(j))
            {
                j++;
                lps[i]=j;
                i++;
            }
            else if(needle.charAt(i)!=needle.charAt(j) && j>0)
            {
                j = lps[i-1];
            }
            else if(needle.charAt(i)!=needle.charAt(j) && j==0)
            {
                lps[i]=0;
                i++;
            }
        }

        return lps;

    }

    public static void main(String args[])
    {
        String haystack = "hello";
        String needle  = "ll";

        System.out.println(index(haystack, needle));
    }
}