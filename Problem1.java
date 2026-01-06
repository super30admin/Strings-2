
class Problem1 {
    public int strStr(String haystack, String needle) {
        int m= haystack.length();
        int n=needle.length();
        for(int i=0;i<=m-n;i++){
            int j =0;
            int count =0;
            int k=i;

            while(j<n){
                if(haystack.charAt(k)==needle.charAt(j)){
                    count++;
                }
                j++;
                k++;
            }
            if(count==n){
                return i;
            }
        }
        return -1;

    }
}
// Time complexity: O(m*n) where m is the length of haystack and n is the length of needle
// Space complexity: O(1)
//No issues found