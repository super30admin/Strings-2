
// Time: O(n+h)
// Space: O(n)

class Solution {
    public int strStr(String haystack, String needle) {
      int n = needle.length();
      int h = haystack.length();
      
      if(h < n){
        return -1;
      }
      
      if(n == 0 || h == 0){
        return 0;
      }
      
      int[] lps = LPS(needle);
     // for(int i=0;i<lps.length;i++){
     //   System.out.println(lps[i]);
     // }
      
      int i=0;
      int j=0;
      while(i < haystack.length()){
          
          if(haystack.charAt(i) == needle.charAt(j)){
            i += 1;
            j += 1;
            
            if(j >= needle.length()){
              return i-n;
            }
          }
        else if(j != 0 && haystack.charAt(i) != needle.charAt(j)){
          j = lps[j-1];
        }
        else if(j == 0 && haystack.charAt(i) != needle.charAt(j)){
          i += 1;
        }
        
      }
      return -1;
      
    }
  public int[] LPS(String needle){
    int n = needle.length();
    int[] lps = new int[n];
    lps[0] = 0;
    int i=1;int j=0;
    while(i < needle.length()){
      if(needle.charAt(i) == needle.charAt(j)){
        j += 1;
        lps[i] = j;
        i++;
      }
      else if(j!=0 && needle.charAt(i) != needle.charAt(j)){
        // j will go to prev longest lps value and then check if ith and jth are same characters, if not move j back again
        j = lps[j-1];

      }else if(j == 0 && needle.charAt(i) != needle.charAt(j)){
        lps[i] = 0;
        i++;
      }
    }
    
    return lps;
  }
}
