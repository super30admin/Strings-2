public class ImplementStrStrBruteForce {
    public int strStr(String haystack, String needle) {
        int hayStackLength = haystack.length();
        int needleLength = needle.length();
        int count=0; 
        int startingIndex=0;
        int i=0; int j=0; 
        while(i<= hayStackLength-1 && j<=needleLength-1)
        {
            if(haystack.charAt(i)==needle.charAt(j))
            {
                count++;
                if(count==1)
                    startingIndex = i; //set starting index to i if this is the first matched char
                i++;
                j++;   
            }
            else
            {
                count=0;
                j=0;
                startingIndex++; //if the chars were matching, and failed at some point, go back to the starting index+1
                i = startingIndex;
            }
            //ignore all the chars if the length of the remaining chars in haystack is shorter (from the starting index) than the length of needle
            if((hayStackLength-(startingIndex))<needleLength && j==0)
                break;
        }
        if(count==needleLength) return startingIndex;
        else return -1;
    }
}
