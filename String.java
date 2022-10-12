
Find the Index of the First Occurrence in a String

public int strStr1(String haystack, String needle) {
    return haystack.indexOf(needle);
}

public int strStr(String haystack, String needle) {
    if (haystack == null || needle == null)
        return -1;
    int l1 = haystack.length();
    int l2 = needle.length();
    for (int i = 0; i < l1-l2+1; i++) {
        int count = 0;
        while (count < l2 && haystack.charAt(i+count) == needle.charAt(count))
            count++;
        if (count == l2)
            return i;
    }
    return -1;
}

Find All Anagrams in a String

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<Integer>();
        int[] arr = new int[26];
        for(int i=0;i<p.length();i++){
            arr[p.charAt(i)-'a']++;
        }
        for(int i=0;i<=s.length()-p.length();i++){
            String temp = s.substring(i,p.length()+i);
            int[] arr1 = new int[26];
            for(int j=0;j<p.length();j++){
                arr1[temp.charAt(j)-'a']++;
            }
            if(Arrays.equals(arr,arr1))
                list.add(i);
        }
        return list;
    }
}


