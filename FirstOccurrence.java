public class FirstOccurrence {
    public static int strStr(String haystack, String needle){
        //loop through haystack string until first occurence of needle character
        for(int i=0;i<haystack.length()-needle.length()+1;i++){
            //if loop encounters first character from needle string then check if substring equals to needle string
            if(haystack.charAt(i)==needle.charAt(0)){
                if(haystack.substring(i,needle.length()+i).equals(needle));
                return i;
            }
        }
        return -1;
    }
    public static void main(String args[]){
        String haystack="butsad";
        String needle="sad";
        System.out.println("First occurrence index: " +strStr(haystack,needle));
    }
}

//TC: O(m*n)
//SC: O(1)