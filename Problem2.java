///Implement strstr
//brute force approach 
//tc - O(m*n)
//sc - O(1)

public class Problem2{
    public static void main(String[] args){

        Problem2 p = new Problem2();
        System.out.println(p.strStr("hello", "ll"));
        

    }
    public int strStr(String haystack, String needle) {
        if(needle.length() ==0){
            return 0;
        }
        if(haystack.length()==0){
            return 0;
        }
        int m = haystack.length();
        int n  = needle.length();
        int i = 0;
        while(i<m){
            if(haystack.charAt(i) == needle.charAt(0)){
                int temp = i;
                int j = 0;
                while(temp< m && haystack.charAt(temp)== needle.charAt(j)){
                    temp++;
                    j++;
                    if(j== n){
                        return i;
                    }

                }

            }
            i++;
        }
        return -1;  
    }
}