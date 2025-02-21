/*
TC : O (n+m)
SC : O (1)
*/
class Solution
{
public:
    vector<int> findAnagrams(string s, string p)
    {
        if (s.size() == 0 || s.empty() || p.size() == 0 || p.empty())
        {
            return {};
        }

        int match = 0;
        map<char, int> hashMap;
        vector<int> result;

        for (auto i : p)
        {
            hashMap[i]++;
        }

        for (int i = 0; i < s.size(); i++)
        {
            // if char exists in hashmap
            if (hashMap.find(s[i]) != hashMap.end())
            {
                hashMap[s[i]]--;
                // update match count when frequency matches
                if (hashMap[s[i]] == 0)
                {
                    match++;
                    // update result if it is an anagram
                    if (match == hashMap.size())
                    {
                        result.push_back(i + 1 - p.size());
                    }
                }
            }

            if (i + 1 >= p.size())
            {
                // update frequency in hashMap if the char exists
                if (hashMap.find(s[i + 1 - p.size()]) != hashMap.end())
                {
                    hashMap[s[i + 1 - p.size()]]++;
                    // update match count if frequency is 1
                    if (hashMap[s[i + 1 - p.size()]] == 1)
                    {
                        match--;
                    }
                }
            }
        }

        return result;
    }
};