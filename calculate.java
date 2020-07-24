//Time - O(n) n is the string length;
//Space - O(n);
//LeetCode - Yes


class Solution {
    public int calculate(String s) {
        if(s == null) return 0;
        Stack<Integer> st = new Stack<>();
        int num = 0; char sign = '+';
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = num*10 + (c-'0');
            }
            if((!Character.isDigit(c) && c!= ' ') || i == s.length()-1){
                if(sign == '+') st.push(num);
                else if(sign=='-') st.push(-num);
                else if(sign=='*'){
                    num *= st.pop();
                    st.push(num);
                }
                else{
                    num = st.pop() / num;
                    st.push(num);
                    
                }
                sign = c;
                num = 0;   
            }
        }
        num = 0;
        while(!st.isEmpty()){
            num += st.pop();
        }
        return num;
        
    }
}