// Time Complexity :O(m+n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : nothing

import java.util.HashMap;

public class HayStack {
    public int strStr(String haystack, String needle) {
        HashMap<Character,Integer> map = new HashMap<>();
        int m = haystack.length();
        int n = needle.length();

        int pHash=0;
        int pos = 1;
        int currhash=0;
        int prime = 1000001;



        for(char c: needle.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
            pHash= (pHash*26+(c-'a'+1))%prime;
            pos = (pos * 26) %prime;
        }


        for(int i=0; i<m; i++){
            char in = haystack.charAt(i);
            currhash = (currhash*26+(in-'a'+1))%prime;

            if(i>=n){
                char out = haystack.charAt(i-n);
                currhash=(currhash-(pos*(out-'a'+1)))%prime
            }

            if(currhash<0) currhash+=prime;
            if(currhash==pHash){
                return i-n+1;
            }

        }
        return -1;

    }
}
