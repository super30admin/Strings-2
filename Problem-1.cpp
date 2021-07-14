//O(n) +O(1) where n is size of haystack
//implemented like it is done in C++
lass Solution {
public:
    int strStr(string haystack, string needle) {
        int len1 = needle.size();
        if(len1 == 0) {
            return 0;
        }
        int len2 = haystack.size();
        if(len2 == 0) {
            return -1;
        }
        for(int i = 0; i < len2 - len1 + 1; ++i) {
            bool isFind = true;
            for(int j = 0; j < len1; ++j) {
                if(haystack[i+j] != needle[j]) {
                    isFind = false;
                    break;
                }
            }
            if(isFind) {
                return i;
            }
        }
        return -1;
    }
};
