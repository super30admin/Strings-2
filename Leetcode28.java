import java.math.BigInteger;
class Solution {
    // Rabin-Karp hashing Algorithm
    public int strStr(String haystack, String needle) {
        if(needle.length() > haystack.length()){
            return -1;
        }
        BigInteger hashOfP = BigInteger.ZERO; //hash is initially zero
        BigInteger k = BigInteger.valueOf(26);
        for(int i = 0 ; i < needle.length() ; i++){
            char ch = needle.charAt(i);
            //updated hash = earlierhash * 26 + (charvalue-asciivalueofchar+1) +1 is as indices from 0
            hashOfP = hashOfP.multiply(k).add(BigInteger.valueOf(ch - 'a' + 1));
        }
        //hash process for haystack
        BigInteger hashOfS = BigInteger.ZERO;
        for(int i = 0 ; i < haystack.length() ; i++){
            if(i >= needle.length()){ //we will have an outgoing element in this case
                //we will subtract the contribution of outgoing element in total hash calculataed till there
                hashOfS = hashOfS.mod(k.pow(needle.length()-1));
            }
            char c = haystack.charAt(i); //adding contribution of incoming character
            hashOfS = hashOfS.multiply(k).add(BigInteger.valueOf(c-'a'+1));
            if(hashOfP.equals(hashOfS)){
                return i-needle.length()+1;
            }

        }
        return -1;
        
    }
}