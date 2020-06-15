//28. Implement strStr()
//Time Complexity: O(m*n)
//Space Complexity: o(1)
class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack==null || needle==null) return -1;
        if(needle.length()==0) return 0;
        int ptr1=0;
        int len=needle.length();
        while(ptr1<haystack.length()-len+1){
            if(haystack.charAt(ptr1) == needle.charAt(0)){
                int j=1;
                while(j<len){
                    if(haystack.charAt(ptr1+j) != needle.charAt(j)){
                         break;
                    }
                     j++;
                }
                if(j==len) return ptr1;
            }
            ptr1++;
        }
        return -1;
    }
}