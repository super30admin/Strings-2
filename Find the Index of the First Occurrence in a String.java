class Solution {
    public int strStr(String haystack, String needle) {
        //I will be using a standard 2 pointer approach.
        //if the needle is bigger then nothing can be done. 

        //hello
        //ll
        //Tme:O(n + m)
        if(needle.length() > haystack.length()){
            return -1;
        }
        long h_hash = 0l;
        long n_hash = 0l;

        int k = 26;
        int kl = (int)Math.pow(k, needle.length());

        //compute the needle hash

        for(int i = 0; i < needle.length(); i++){
            
           char c = needle.charAt(i);
           n_hash = n_hash * k + (c - 'a');
        
        }

        //compute the hash of haystack only upto needle length. 

        for(int i = 0; i < needle.length(); i ++){

            char c = haystack.charAt(i);
            h_hash = h_hash * k + (c - 'a');

        }

        if(h_hash == n_hash){
            return 0;
        }

        //initialize pointers

        int l = 1;
        int r = l + needle.length() - 1;

        while(r < haystack.length()){
            

            //add the incoming character first. 
            System.out.println("l:" + l);
            h_hash = h_hash * k + (haystack.charAt(r) - 'a');
            //remove the outgoing character. 

            System.out.println("r:" + r);
            h_hash = h_hash - kl * (haystack.charAt(l - 1) - 'a');

            
            if(n_hash  == h_hash){
                return l;
            }

            l++;
            r++;

        }

        if(n_hash == h_hash){
            return l - 1;
        }

        return -1;
    }
}