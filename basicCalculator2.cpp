// Time Complexity :O(n) n is the length of the string
// Space Complexity : O(s) s-> Size of the stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
public:
    int calculate(string s) {
        string str;
        for(auto c : s){
            if(c != ' ') str+=c;
        }
        long num = 0;
        char lastSign = '+';
        stack<int> st;
        int size = str.length();
        for(int i = 0;i < size;i++){
            char c = str[i];
            if(isdigit(c)){
                num= (num*10) + c - '0';
            }
            if(!isdigit(c) || i == size-1){
                if(lastSign=='+') st.push(num);
                else if(lastSign=='-')st.push(-num);
                else if(lastSign=='*'){
                    int temp = st.top()*num;
                    st.pop();
                    st.push(temp);
                }
                else if(lastSign == '/'){
                    int temp = st.top()/num;
                    st.pop();
                    st.push(temp);
                }
                num = 0;
                lastSign = c;
            }
        }
        long res = 0;
        while(!st.empty()){
            res+=st.top();
            st.pop();
        }
        return res;
    }
};