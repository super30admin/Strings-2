//Time Complexity: O(m + n)
//Space Complexity: O(1)
public class StrStr {
	public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        if(n == 0) return 0;
        int i = 0;
        while(i < m){
            int j = 0;
            if(haystack.charAt(i) == needle.charAt(j)){
                int temp = i;
                while(temp < m && j < n){
                    if(haystack.charAt(temp) != needle.charAt(j)) break;
                    temp++; j++;
                }
                if(j == n) return i;
            }
            i++;
        }
        return -1;
    }
}
