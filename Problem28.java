package problems.string;
//TC=O(m+n)
//SC=O(n) 
public class Problem28 {
    public int strStr(String haystack, String needle) {
        int i = 0;
        int j = 0;
        int h = haystack.length();
        int n = needle.length();
        if (n == 0)
            return 0;
        int[] lps = lps(needle);
        while (i < h) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
                if (j == n)
                    return i - j;
            }
            else if (haystack.charAt(i) != needle.charAt(j) && j>0) {
                j = lps[j - 1];
            }
            else if(haystack.charAt(i) != needle.charAt(j) && j==0){
                i++;
            }
        }
        return -1;
    }

    private int[] lps(String needle) {
        // len of prev longest prefix
        int j = 0;
        int i = 1;
        int n=needle.length();
        int[] lps = new int[n];
        lps[0] = 0;
        while (i < n) {
            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
                lps[i] = j;
                i++;
            } else if (needle.charAt(i) != needle.charAt(j) && j>0) {
                j = lps[j - 1];
            } else if (needle.charAt(i) != needle.charAt(j) && j == 0) {
                    lps[i] = 0;
                    i++;
            }
        }
        return lps;
    }

    public static void main(String[] args) {
        Problem28 problem=new Problem28();
        System.out.println(problem.strStr("asadbutsad","sad"));
        System.out.println(problem.strStr("sadasaasssadass","ssadass"));
    }

}
