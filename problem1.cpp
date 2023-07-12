/*
// Time Complexity : O(N+M)
// Space Complexity : O(M)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
You find the rolling hash of the window and compare with that of the key when found return the key 
Else return - 1
*/

#include<iostream>
#include<vector>
#include<string>

using namespace std;

class Solution {
public:
    int strStr(string haystack, string needle) {
        const int power{26};
        int h_len = haystack.size();
        int n_len = needle.size();
        if(n_len > h_len) return -1;
        unsigned long long int key{0};
        for(auto& c:needle){
            int num = c-'a'+1;
            key = key*power + num;
        }
        //cout<<"key is "<<key<<endl;
        unsigned long long int curr_key{0};
        for(int i{};i<h_len;++i){
            //cout<<"i val"<<i<<endl;
            int num = haystack.at(i) - 'a' +1;
            //cout<<"num is "<<num<<endl;
            if(i>=n_len){
                unsigned long long int s_num = haystack.at(i-n_len) - 'a' + 1;
                //cout<<"s_num is "<<s_num<<endl;
                s_num = s_num*pow(power,n_len-1);
                curr_key = curr_key - s_num;
            }
            curr_key = curr_key*power + num;
            if(curr_key == key) return (i+1-n_len);

        }
        return -1;
    }
};