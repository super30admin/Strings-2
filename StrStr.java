/*
  Time: O(2n) ~= O(n)
  Spcae: O(1)
  Run on LeetCode: yes
*/
class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0)
            return 0;

        int nindx = 0;
        int hindx = 0;
        int strt = -1;
        //hindx moves from 0 to end of str.
        // O(n)
        while(hindx < haystack.length()){

          //********* set strt, nindx, hindx values **************//

            //if first chars meet. increment hindx and nindx,
            //also set strt in case strt == -1, can happen if first matching char.
            //or last needle we were comparing was not matched.
            if(haystack.charAt(hindx) == needle.charAt(nindx)){
                if(strt == -1)
                    strt = hindx;
                hindx++;
                nindx++;
            }
            //in case chars dont match move strt forward by one and nindx
            //back by one, try to see if this string matches.
            //keep doing this till nindx >=0 or strings match.
            else{
                if(strt < 0){
                //no matching char so far, reduce nindx.
                //nindx should be 0 here anyway, will get set to 0 back
                //in if condition after this else block.
                    nindx--;
                }
                else{
                    while(!haystack.substring(strt, hindx+1).equals(needle.substring(0, nindx+1))){
                        nindx--;
                        strt++;
                        if(nindx < 0)
                            break;
                    }
                }
            }

            //************ cheack n indx values ***************//
            
            //in case nindx < 0 , we know current hindx char is not what we are
            //looking for.
            //nove hindx by once, make nindx == 0.
            //set strt to -1, so that we can set it to hindx on first matching
            //char.
            if(nindx == -1){
                nindx++;
                hindx++;
                strt = -1;
            }
            //in case nindx == len of needle , we know we found the
            //needle. return strt, since its at indx in haystack where needle strts
            else if(nindx == needle.length())
                return strt;
        }
        return -1;
    }
}
