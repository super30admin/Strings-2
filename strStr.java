// TC: O(1)
// SC: O(n)
public class strStr {
    public int strStr(String haystack, String needle) {
        // if needle length is 0 or needle length and haystack length and both string matches return 0
        if(needle.length()==0 || (needle.length() == haystack.length() && haystack.contains(needle)))
            return 0;
        // check if needle exists in haystack and its length is lesser than the haystack
        if(haystack.contains(needle) && needle.length() < haystack.length()){
            String[] ch = haystack.split(needle);
            if(needle.length() == 1 && haystack.charAt(0) == needle.charAt(0))
                return 0;
            return ch[0].length();
        }
        return -1;        
    }
}