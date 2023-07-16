public class FirstOccurrenceOfString {

    //Time Complexity: O(N)
    //SpaceComplexity: O(1)// we are just maintaining a hash value so constant space
    public int strStr(String haystack, String needle) {
        //rolling hash->hash* 26 + ch - 'a'
        long needleHash = hash(needle);


        int ptr2 = 0;
        long haystackHash = 0;

        for(ptr2 = 0; ptr2 < haystack.length(); ptr2++){

            if(ptr2 < needle.length()){
                haystackHash = haystackHash*26 +(haystack.charAt(ptr2) - 'a'+ 1);
            }
            else{
                haystackHash = haystackHash*26 +(haystack.charAt(ptr2) - 'a'+ 1);
                haystackHash = haystackHash - (long)Math.pow(26, (needle.length()))*(haystack.charAt(ptr2- needle.length()) - 'a'+ 1);
            }

            if(haystackHash == needleHash){
                return ptr2 - needle.length()+ 1;
            }

        }
        return haystackHash == needleHash? ptr2- needle.length(): -1;

    }

    private long hash(String needle){
        int k = 26;
        long hash = 0;
        for(int i  = 0; i< needle.length(); i++){
            hash = hash*k +(needle.charAt(i) - 'a'+ 1);
        }

        return hash;
    }
}
