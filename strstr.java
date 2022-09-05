
//Time - O(n*m)
//Space - O(1)

public class Main {
    public static void main(String[] args) {
        String haystack = "hello";
        String needle = "ll";
        int i = findIndex(haystack,needle);
        System.out.println(i);
    }
    
    public static int findIndex(String main, String sub){
        if(sub.length()==0)
            return 0;
        for(int i=0;i<main.length()-sub.length();i++){
            String substr = main.substring(i, i+sub.length());
            if(sub.equals(substr))
                return i;
        }
        return -1;
    }
}
