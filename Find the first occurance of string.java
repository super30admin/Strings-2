//Time Complexity = O(M*N);
//Space Complexity = O(1);
class Solution {
    public int strStr(String haystack, String needle) {
        //base
        if(needle.length() > haystack.length())return -1;
        //pivot
        int i =0;
        while(i < haystack.length() - needle.length() +1){
            for(int j = 0; j< needle.length(); j++){
                char a = haystack.charAt(i+j);
                char b = needle.charAt(j);
                if(a != b) break;
                else if(j==needle.length()-1){
                    if(a==b) return i;
                }
            }
            i++;
        }


        return -1;
    }
}