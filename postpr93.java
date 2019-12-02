class Solution {
    public int strStr(String haystack, String needle) {
        String S = haystack;
        int N = S.length();
        String P = needle;
        int M = P.length();
        if(M==0)return 0;
        int[] KMP = KMPArray(P,M);
        int i=0;
        int j=0;
        
        while(i<N){
            if(S.charAt(i)==P.charAt(j)){
                i++;
                j++;
            }
            if(j==M){
                return i-j;
            }else if(i < N && S.charAt(i)!=P.charAt(j) && j>0){
                j=KMP[j-1];
            }else if(i < N && S.charAt(i)!=P.charAt(j) && j==0){
                i++;
        }
    }
                return -1;
    }
        
    private int[] KMPArray(String P,int M){
        int[] KMP = new int[M];
        int i=1;
        int j=0;
        
        while(i<M){
            if(P.charAt(i)==P.charAt(j)){
                j++;
                KMP[i]=j;
                i++;
            }else if(P.charAt(i)!=P.charAt(j) && j>0){
                j=KMP[j-1];
            }else if(P.charAt(i)!=P.charAt(j) && j==0){
                KMP[i]=j;
                i++;
            }
        }
        
        return KMP;
    }
}