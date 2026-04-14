//
//  FindAllAnagram.swift
//  DSA-Practice
//
//  Created by Paridhi Malviya on 2/11/26.
//

/*
 P = "abca" -> m
 S = "cbaaebabacd" -> n
 Bruteforce - find all substrings of length 4. Then for each substring, if it's an anagram or not
 time complexity -> m * n.
 
 using hashmap and matchCount-
 O(m + n) - pattern is going to be smaller, so, O(n)
 Space complexity - O(1)
 */
class FindAllAnagrams {
    
    //O(m +n), space O(1)
    func findAnagrams(_ s: String, _ p: String) -> [Int] {
        
        if (p.count > s.count) {
            return []
        }
        var pMap = Dictionary<Character, Int>()
        for i in 0..<p.count {
            let pIdx = p.index(p.startIndex, offsetBy: i)
            pMap[p[pIdx], default: 0] += 1
        }

        var matchCount = 0
        var result = [Int]()
        for i in 0..<s.count {
            //in
            let charIdx = s.index(s.startIndex, offsetBy: i)
            let inChar = s[charIdx]
            if let c = pMap[inChar] {
                pMap[inChar]! -= 1
                if (pMap[inChar]! == 0) {
                    matchCount += 1
                }
            }

            //out
            //when we reach the length of the pattern
            if (i >= p.count) {
                let outCharIdx = s.index(s.startIndex, offsetBy: i - p.count)
                let outChar = s[outCharIdx] //outgoing character
                if (pMap[outChar] != nil) {
                    //since this character is not in the current window so, but we need this character. SO increament it. When it becomes 0, means we got the character's count
                    pMap[outChar]! += 1
                    if (pMap[outChar] == 1) {
                        matchCount -= 1
                    }
                }
            }
            if (matchCount == pMap.keys.count) {
                result.append(i - p.count + 1)
            }
        }
        return result
    }
}
