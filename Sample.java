//Time comp: O(n)
//Space comp: O(1)
//approach: iterate through haystack and check if needle is substring of haystack
class Solution {
    public int strStr(String haystack, String needle) {
        int i=0;
        int n=haystack.length();
        int l=needle.length();
        while(i<=n-l){
            if(haystack.substring(i,i+l).equals(needle)){
                return i;
            }
            i++;
        }
        return -1;
    }
}

// Time limit exceeded
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> l = new ArrayList<>();
        HashSet<Character> set = new HashSet<>();
        HashSet<Character> seen = new HashSet<>();
        for(Character c: p.toCharArray()){
            set.add(c);
        }
        int pLen=p.length();
        int sLen=s.length();
        int i=0;
        int j=0;
        int count=0;
        while(i<sLen && j<sLen){
            if(set.contains(s.charAt(j)) && !seen.contains(s.charAt(j))){
                seen.add(s.charAt(j));
                j++;
                count++;
                if(count==pLen){
                    l.add(i);
                    i++;
                    j=i;
                    count=0;
                    seen.clear();
                }
            }
            else{
                if(!set.contains(s.charAt(j))){
                    j++;
                    i=j;
                    count=0;    
                }
                else{
                    i=j;
                    count=0;
                }
            }
        }
        return l;
    }
}
