//Time complexity-O(n+m)
//Space complexity-O(m)
//Ran on leetcode-Yes
//Solution wot comments-
class Solution {
    public int strStr(String haystack, String needle) {
        if(needle==null || needle.length()==0) return 0;
        
        int i=0,j=0;
        int []arr = LPS(needle);//using Longest prefix suffix approach
        
      while(i<haystack.length()){
            
            if(haystack.charAt(i)==needle.charAt(j)){
                i++;
                j++;
                if(j>=needle.length()){
                    return i-j;
                }
            }
          else if(j!=0 && haystack.charAt(i)!=needle.charAt(j)){
              j=arr[j-1];
          }
          else if(j==0 && haystack.charAt(i)!=needle.charAt(j)){
                i++;
          }
        }
        return -1;
        
    }
    
    public int[] LPS(String n){
        int arr[]= new int[n.length()];
        int i=0;
        int j=1;
        while(j<n.length()){
            if(n.charAt(i)==n.charAt(j)){
                i++;
                arr[j]=i;
                j++;
            }
            else if(i!=0 && n.charAt(i)!=n.charAt(j)){
                i=arr[i-1];
            }
            else if(i==0 && n.charAt(i)!=n.charAt(j)){
                arr[j]=0;
                j++;
            }
        }
        return arr;
        
    }
}