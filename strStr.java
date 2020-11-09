/*

TC: O((H-N)N) : H - haystack length, N - needle length. A substring of length N is executed H - L times.
SC: O(1)

1. When the char of haystack matches with first char of needle. Take substring. 
2. If the substring matches, return index.
3. 

*/


public class strStr{
    public int str(String haystack, String needle) {
        
        if(needle == null || needle.length() == 0) return 0;
        if(needle.length() > haystack.length()) return -1;
        
        for(int i = 0; i < haystack.length(); i++){
            if(haystack.charAt(i) == needle.charAt(0)){
                
                if(i + needle.length() <= haystack.length() && haystack.substring(i, i + needle.length()).equals(needle)){
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args){
        strStr str = new strStr();
        System.out.println(str.str("helolla","ll"));


    }
}