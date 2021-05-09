//Approach - check for an index in which the charcter matches with needle's first char
// if found, then iterate through the next chars till the entire needle is found in haystack
//Time Complexity - O(h) - h is length of haystack
// Space Complexity - O(1)

class Solution {
  public int strStr(String haystack, String needle) {
    if(needle == null || needle.length() == 0){
      return 0;
    }

    int i=0;
    while(i < haystack.length()){
      if(haystack.charAt(i) == needle.charAt(0)){
        int temp = i;
        int j = 0;

        while(temp < haystack.length() && haystack.charAt(temp) == needle.charAt(j)){
          temp++;
          j++;
          if(j == needle.length()){
            return i;
          }
        }
      }
      i++;
    }
    return -1;
  }
}
