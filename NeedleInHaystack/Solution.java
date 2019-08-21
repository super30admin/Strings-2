class NeedleInHaystack {
    public int strStr(String haystack, String needle) {

        int hStart=0, hEnd=0;
        int n=0;
        //int start = -1;

        if(needle.length() == 0) return 0;

        while(hStart < haystack.length() && hEnd < haystack.length() && n < needle.length()){
            if(haystack.charAt(hEnd) == needle.charAt(n)){
                hEnd++;
                n++;
                
                if(n == needle.length()){
                    System.out.println(hStart);
                    return hStart;
                }
            }
            else {
                hStart++;
                hEnd = hStart;
                n=0;
            }
        }

        return -1;
    }
}

class Solution {
    public static void main(String[] args){
        System.out.println("Needle In Haystack");
        String haystack = "mississippi";
        String needle="issip";
        NeedleInHaystack obj = new NeedleInHaystack();
       System.out.println(obj.strStr(haystack, needle));
    }
}