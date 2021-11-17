//Timecomplexity:- O(m+n);
//space complexity:-o(m);
//Did it run on leetcode:- yes.
//What problem did you face?:- got many runtime erros.
//Your code with explanation:- first longest prefix array is consturcted while traversing needle, then Kmp is applied using this array.


class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length()==0||needle==""){
            return 0;
        }
        else if(needle.length()>haystack.length()){
            return -1;
        }
        int[]lps=new int[needle.length()];
        lps[0]=0;
        int i=1;
        int j=0;
        while(i<needle.length()){
            if(needle.charAt(i)==needle.charAt(j)){
                j++;
                lps[i]=j;
                i++;                                              // constructing longest prefix;
            }
            else if(j!=0&&needle.charAt(i)!=needle.charAt(j)){
                j=lps[j-1];
            }
            else if(j==0&&needle.charAt(i)!=needle.charAt(j)){
                lps[i]=0;
                i++;
            }
        }
        int a=0;
        int b=0;
        while(a<haystack.length()){
            if(haystack.charAt(a)==needle.charAt(b)){
                a++;
                b++;
                if(b>=needle.length()){
                    return a-b;
                }
            }
            else if(haystack.charAt(a)!=needle.charAt(b)&&b!=0){
                b=lps[b-1];                                        // kmp algorithm.
            }
            else if(b==0&&haystack.charAt(a)!=needle.charAt(b)){
                a++;
            }
        }
       return -1; 
    }  
        }
   
