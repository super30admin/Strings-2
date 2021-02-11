// Time Complexity :O(n^2)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :
// Three line explanation of solution in plain english

// Your code here along with comments explaining your approach

class Solution {
     List<Integer> result;
    public List<Integer> findAnagrams(String s, String p) {
        result=new ArrayList<>();
        boolean[] track=new boolean[p.length()];
        createAnagrams(p,track,0,new StringBuilder(),s);
        return result;
    }
    
    public void createAnagrams(String p,boolean[] track,int index,StringBuilder str,String s){
        if(index==p.length()){
            //System.out.println(str);
            checkValidity(str,s);
            return;
        }
        for(int i=0;i<p.length();i++){
            if(!track[i]){
                track[i]=true;
                str.append(p.charAt(i));
                createAnagrams(p,track,index+1,str,s);
                str.deleteCharAt(str.length()-1);
                track[i]=false;
            }
        }
    }
    
    public void checkValidity(StringBuilder str,String s){
        int index=0;
        if(s.indexOf(str.toString())!=-1){
            index=0;
            while(s.indexOf(str.toString(),index)!=-1){
                if(!result.contains(s.indexOf(str.toString(),index))){
                    result.add(s.indexOf(str.toString(),index));
                }
                index=s.indexOf(str.toString(),index)+str.length();
                // System.out.println(str);
                // System.out.println(index);
            }
        }
        
    }
}