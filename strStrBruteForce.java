//Both with time complexities O(nm)


//Method 1

class Solution {
    public int strStr(String haystack, String needle) {

        if(needle.length() == 0 )
            return 0;

        // for(int i=0;i<haystack.length();i++){
        //     char c = haystack.charAt(i);
        //     if(c ==  needle.charAt(0) && i+needle.length() <= haystack.length()){
        //         if(needle.equals(haystack.substring(i,i+needle.length())))
        //             return i;
        //     }
        // }
        
        for(int i=0;i<haystack.length();i++){
            char c = haystack.charAt(i);
            int j = 0;

            if(haystack.charAt(i) == needle.charAt(j)){
                int temp = i;
                while(temp < haystack.length() && j <needle.length()){
                    if(haystack.charAt(temp) == needle.charAt(j)){
                        temp++;j++;
                    }
                    else{
                        break;
                    }
                }
                if(j == needle.length())
                    return i;
            }

        }
        return -1;
    }

   
}

//Method 2

class Solution {
    public int strStr(String haystack, String needle) {

        if(needle.length() == 0 )
            return 0;

        for(int i=0;i<haystack.length();i++){
            char c = haystack.charAt(i);
            if(c ==  needle.charAt(0) && i+needle.length() <= haystack.length()){
                if(needle.equals(haystack.substring(i,i+needle.length())))
                    return i;
            }
        }
        return -1;
    }

}

