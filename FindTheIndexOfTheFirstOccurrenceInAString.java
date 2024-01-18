// TC : O(n+m)
// SC : O(1)

package S30_Codes.Strings_2;

class FindTheIndexOfTheFirstOccurrenceInAString {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        if(n > m) return -1;

        long needleHash = 0l;
        for(int i=0; i<n; i++){
            int c = needle.charAt(i) - 'a' + 1;
            needleHash = needleHash * 26 + c;
        }

        long hayHash = 0l;
        long nl = (long) Math.pow(26, n);
        for(int i=0; i<m; i++){
            // incoming
            int in = haystack.charAt(i) - 'a' + 1;
            hayHash = hayHash * 26 + in;

            // outgoing
            if(i >= n){
                int out = haystack.charAt(i-n) - 'a' + 1;
                hayHash -= out * nl ;
            }

            if(hayHash == needleHash)
                return i - n + 1;
        }
        return -1;
    }
}