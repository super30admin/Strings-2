class ImplementStrStr {
    //Time: O(m+n) where m = length of haystack and n= length of needle
    //Space: O(n)//
    public int strStr(String haystack, String needle) {
        //if needle length is zero i.e. empty string
        if(needle.length()==0) return 0;
        //initialize haystack and needle pointers
        int i=0, j=0;
        //getting length of both the input strings
        int h = haystack.length(), n = needle.length();
        //fetching the lps array for our needle
        int[] lps = lps(needle);
        // until haystack pointer is less then length of haystack
        while(i<h){
            //if current character of needle is same as that of haystack
            if(needle.charAt(j) == haystack.charAt(i)){
                //increement haystack and needle pointers
                j++;
                i++;
                // needle pointer has reached the end, we have found our result
                if(j == n) return i-n;
            }
            //if current characters are not same and needle pointer greater than zero
            else if(needle.charAt(j) != haystack.charAt(i) && j>0){
                //update needle pointer
                j = lps[j-1];
            }//if current characters are not same and needle pointer equal to zero
            else if(needle.charAt(j) != haystack.charAt(i) && j==0){
                //increement haystack pointer
                i++;
            }
        }

        return -1;
    }

    //creating lps array
    private int[] lps(String pattern){//O(n)
        //array to store lps array
        int[] lps = new int[pattern.length()];
        //initializing prefix and suffix pointer
        int j=0;
        int i=1;
        //until suffix pointer less than length of our pattern string
        while(i<pattern.length()){
            //if current character of prefix is same as that of suffix
            if(pattern.charAt(j) == pattern.charAt(i)){
                //increement prefix and needle pointers
                j++;
                //set lps value at index i
                lps[i] = j;
                //increement suffix pointers
                i++;
            }//if current characters are not same and prefix pointer greater than zero
            else if(pattern.charAt(j) != pattern.charAt(i) && j>0){
                //update prefix pointer
                j = lps[j-1];
            }//if current characters are not same and prefix pointer equal to zero
            else if(pattern.charAt(j) != pattern.charAt(i) && j==0){
                //increement suffix pointer
                i++;
            }
        }
        return lps;
    }
}