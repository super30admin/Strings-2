//time O(m*n)
//space O(1) 
class Solution {
public:
    int strStr(string haystack, string needle) {
        int i = 0;
        int j=0;



        int m=haystack.size();
        int n= needle.size();

        if(n>m){
            return -1;
        }

        while(i<=m-n){
            if(haystack[i]==needle[j]){
                int k=i;
                
                while(haystack[k]==needle[j]){
                    k++;
                    j++;

                    if(j==n){
                        return i;
                    }



                }
                j=0;
                
            }
            i++;
                
            
            
        }

        return -1;


        
    }
};