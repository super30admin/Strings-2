// Time: O(mn)
// Space(1)



class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length() ==0 ) return 0;
        for(int i = 0 ;i <haystack.length() ; i++){
            char c = haystack.charAt(i);
            if(c == needle.charAt(0)){
                if(found(haystack, needle, i)){
                    return i;
                }
            }

        }
        return -1;
        
    }

    public boolean found(String haystack, String needle, int start){
        int last = needle.length() + start;
        if(last >haystack.length()){
            return false;
        }
        int needleFirst = 0;
        // int needleLast = needle.length()-1;
        while(start<last){
            if(start< haystack.length() && needleFirst <  needle.length() && haystack.charAt(start) ==needle.charAt(needleFirst) ){
                start++;
                needleFirst++;
                
            }else{
                return false;
            }
        }
        return true;
    }
}