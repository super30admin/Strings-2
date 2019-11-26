//Time Complexity :O(exp(N)).
//Space Complexity :O(N)
//Did this code successfully run on Leetcode :yes
//Any problem you faced while coding this :Nope


//Your code here along with comments explaining your approach
class FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        char arr[] = p.toCharArray();
        Arrays.sort(arr);
        List<List<Character>> list = new ArrayList<>();
        boolean used[] = new boolean[arr.length];
        findpermutations(arr,list,used,new ArrayList<>());
        List<Integer> result = new ArrayList<>();
        for(List<Character> l : list){
            StringBuilder sb = new StringBuilder("");
            for(Character ch : l){
                sb.append(ch);
            }
            strStr(s,sb.toString(),result);
        }
    return result;
    }
    public void findpermutations(char arr[], List<List<Character>> result, boolean[] used, List<Character> list){
        if(list.size() == arr.length){
            result.add(new ArrayList<>(list));
        }else{
            for(int i = 0; i < arr.length; i++){
                if(used[i]){continue;}
                if(i > 0 && arr[i-1] == arr[i] && !used[i-1]){continue;}
                used[i] = true;
                list.add(arr[i]);
                findpermutations(arr,result,used,list);
                list.remove(list.size()-1);
                used[i] = false;
            }
        }
    }
    public void strStr(String haystack, String needle, List<Integer> result) {
        if(null == needle || needle.length() == 0){return;}
        if(null == haystack || haystack.length() == 0){return;}
        for(int i = 0; i < haystack.length(); i++){
            if(haystack.charAt(i) == needle.charAt(0)){
                int j = i + 1, k = 1;
                while(k < needle.length() && j < haystack.length()){
                    if(needle.charAt(k) != haystack.charAt(j)){
                        break;
                    }
                    k++;
                    j++;
                }
                if(k == needle.length()){
                    result.add(i);
                }
            }
        }
    }
}