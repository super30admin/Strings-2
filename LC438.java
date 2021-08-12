class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        List<Integer> output = new ArrayList<>();
        
        if(s.length() < p.length()){
            return output;
        }
        
        int[] arr = new int[26];
        
        for(int i = 0; i < p.length(); i++){
            int val = p.charAt(i);
            arr[val - 'a']++;
        }
        
        for(int i = 0; i <= s.length() - p.length(); i++){
            int[] arr2 = new int[26];
            for(int j = 0; j < p.length(); j++){
                int val1 = s.charAt(i+j);
                arr2[val1 - 'a']++;
            }
            if(match(arr, arr2)){
                output.add(i);
            }
        }
        
        return output;
    }
    
    public boolean match(int[] arr1, int[] arr2){
        for(int i = 0; i < arr1.length; i++){
            if(arr1[i] != arr2[i]){
                return false;
            }
        }
        return true;
    }
}