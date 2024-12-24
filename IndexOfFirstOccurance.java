// Time Complexity: lps array O(n) and matching loop O(m) so overall time complexity is O(m + n )
// Space Complexity : lps array  O(n) space
public class IndexOfFirstOccurance {
    int [] lps;
    public int strStr(String haystack, String needle){
        int m = haystack.length();
        int n = needle.length();

        if( n== 0) return 0;
        this.lps = new int[n];
        lpsCal(needle);
        int i =0, j =0;
        while( i < m){
            if(haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
                if(j == n) return i - j; // match found return start index
            }  else if(haystack.charAt(i) != needle.charAt(j) && j > 0){
                j = lps[j - 1];
            }else{
                i++;
            }
        }
     return -1;

    }

    private void lpsCal( String needle) {
        lps[0] = 0;
        int i = 1, j = 0; // i is incoming character for suffix window  and j is incoming character for prefix window
        while( i < needle.length()){
            if(needle.charAt(i) == needle.charAt(j)){
                j++;
                lps[i] = j;
                i++;
            } else if (needle.charAt(i) != needle.charAt(j) && j > 0){
                // Squeze the window
                j = lps[j -1]; // move j to previous lps position
            } else{
                lps[i] = 0; // no match found
                i++;
            }

        }
    }

    public static void main(String [] args) {
        IndexOfFirstOccurance solution = new IndexOfFirstOccurance();

        // Test cases
        String haystack1 = "hello", needle1 = "ll";
        System.out.println("Index of first occurrence: " + solution.strStr(haystack1, needle1)); // Output: 2

        String haystack2 = "aaaaa", needle2 = "bba";
        System.out.println("Index of first occurrence: " + solution.strStr(haystack2, needle2)); // Output: -1

        String haystack3 = "", needle3 = "";
        System.out.println("Index of first occurrence: " + solution.strStr(haystack3, needle3)); // Output: 0
    }

}
