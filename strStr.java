class Solution {
    public int strStr(String haystack, String needle) {
        int l1 = haystack.length();
        int l2 = needle.length();
        if(needle == null || l2 == 0){
            return 0;
        }
        if(l2 > l1){
            return -1;
        }
        
        int i = 0; int j = 0;
        int tempi = 0;
        while(i < l1){
            tempi = i;
            j = 0;
            while(tempi < l1 && j < l2 && haystack.charAt(tempi) == needle.charAt(j)){
                tempi++;
                j++;
                if(j == l2){
                    return i;
                }
            }
            i++;
        }
        return -1;
    }
}
        
   