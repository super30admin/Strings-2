package week7.day7;
class Solution12 {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        if(n>m)
            return -1;
        
        int haystack_ptr=0;
        while(haystack_ptr<= m-n){
                int needle_ptr=0;
                int start = haystack_ptr;
            while(needle_ptr<n && haystack.charAt(haystack_ptr)==needle.charAt(needle_ptr)){
                haystack_ptr++;
                needle_ptr++;
            }
            if (needle_ptr == n) {
                return start;
            } else {
                haystack_ptr = start + 1; // Move the haystack pointer to the next position
            }
        }
        return -1;
    }
}
public class IndexOfFirstOccurrenceInString {

	public static void main(String[] args) {
		Solution12 s = new Solution12();
		int re = s.strStr("mississippi", "issip");
		System.out.println(re);

	}

}
