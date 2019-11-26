//Time Complexity :O(N*M).
//Space Complexity :O(1)
//Did this code successfully run on Leetcode :yes
//Any problem you faced while coding this :Nope


//Your code here along with comments explaining your approach
class StrStr {
    public int strStr(String haystack, String needle) {
        if(null == needle || needle.length() == 0){return 0;}
        if(null == haystack || haystack.length() == 0){return -1;}
        for(int i = 0; i < haystack.length(); i++){
            if(haystack.charAt(i) == needle.charAt(0)){
                int j = i + 1, k = 1;
                while(k < needle.length() && j < haystack.length()){
                    if(needle.charAt(k) != haystack.charAt(j)){
                        break;
                    }
                    k++;
                    j++;
                }
                if(k == needle.length()){
                    return i;
                }
            }
        }
    return -1;
    }
}