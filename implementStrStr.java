public class implementStrStr {
    public int strStr(String haystack, String needle) {
        if(haystack.length()<needle.length()) return -1;
        if(haystack.length()==0 || needle.length()==0) return -1;
        //return haystack.indexOf(needle);
        int limit = haystack.length()-needle.length()+1;

        for(int i=0;i<limit; i++){
            if(haystack.charAt(i)==needle.charAt(0)){
                int j=0;
                int k=i;
                while(j<needle.length()){
                    if(haystack.charAt(k)==needle.charAt(j)){
                        j++;
                        k++;
                        if(j==needle.length()){
                            return i;
                        }
                    }else {
                        break;
                    }
                }
            }

        }
        return -1;

    }
}
