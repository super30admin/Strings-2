class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
    if(m<n) return -1;
    int i=0;

     

            while(i<m-n+1)
            {
                    if(haystack.charAt(i) == needle.charAt(0)){
                       int k=i;
                       int j=0;


                while(haystack.charAt(k) == needle.charAt(j)){

                    k++;
                    j++;
                    if(j==n){
                        return i;
                    }
                }
            
            }

                i++;
            }
           

    return -1;


        }

    
    
}