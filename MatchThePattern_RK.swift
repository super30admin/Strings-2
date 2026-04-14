//
//  MatchThePattern.swift
//  DSA-Practice
//
//  Created by Paridhi Malviya on 2/11/26.
//

/*
 /*
  bruteforce - create substrings of pattern length and then check
  O(m * n)
  m- pattern ;ength
  n- string length
  
  approach 2 - left two pointers on the string and the pattern both - i and j respectively.
  if char at i == char at j then only start the traversing pointer k in the string.
  If mismatch -> i to (i + 1), reset j to 0.
  time complexity -> O(m * n)
  */
 */

class MatchThePattern {
    init() {
        
    }
    
    func strStr(_ haystack: String, _ needle: String) -> Int {
        let m = haystack.count
        let n = needle.count
        var i = 0
        var result: Int = -1
        while (i < haystack.count) { //-needle.count
            let hCharIdx = haystack.index(haystack.startIndex, offsetBy: i)
            var nIdx = needle.index(needle.startIndex, offsetBy: 0)
            if (haystack[hCharIdx] == needle[nIdx]) {
                var j = 0
                var k = 0
                var kIdx = haystack.index(hCharIdx, offsetBy: k)
                while (k < haystack.count && haystack[kIdx] == needle[nIdx]) {
                    k += 1
                    j += 1
                    if (j == needle.count) {
                        return i
                    }
                    // if (k < haystack.count) {
                        kIdx = haystack.index(hCharIdx, offsetBy: k)
                        nIdx = needle.index(needle.startIndex, offsetBy: j)
                    // }
                }
            }
            i = i + 1
        }
        return result
    }
    
//Time complexity - m*n
    func strStrUsingCharArray(_ haystack: String, _ needle: String) -> Int {
        let m = haystack.count
        let haystackArr = Array(haystack)
        let needleArr = Array(needle)
        let n = needleArr.count
        var i = 0
        var result: Int = -1
        while (i < haystackArr.count - needleArr.count) {
            let hChar = haystackArr[i]
            var nChar = needleArr[0]
            if (hChar == nChar) {
                var j = 0
                var k = i
                var kChar = haystackArr[k]
                while (haystackArr[k] == needleArr[j]) {
                    k += 1
                    j += 1
                    if (j == needleArr.count) {
                        return i
                    }
                }
            }
            i = i + 1
        }
        return result
    }
}

/*
 Robin karp rolling hash.
 find() functon =
 pattern - we will associate hash value for the pattern
 If we find this hash value somehwere in the main string, we get the pattern
 
 How to calculate the hash value for a string ? wec were taking prime product before to find anagram
 
 Here we need order for the pattern. order matters. in hese situations, we use rollng hash suggested by robin carp. based on the position , the hash value should chnge. In this case, we take powers of the position. for understandin take pwer as 10.
 
 If we have just lower case letters, then the power factor is 26.
 If we have just lower case letters and upper case letters as well, then the power factor is 52.

 
 aaab
 hash value of a char = earlier hash value * 10 + ascii vslue of chaaracter = 0 * 10 + 1 = 1
 hash value of 2nd a = earlier hash value * 10 + ascii value of character = 1 * 10 + 1 = 11
 for 3rd a = 11 * 10 + 1 = 111
 for b = 111 * 10 + 2 = 1112
 O(m + n)
 
 
 
 downside -> for longer strings, it can go out of bounds
 
 first calculate the hash value of the pattern and find it in the string. If it matches means he pattern exists.
 
 */

class MatchPatternUsingRobinKarp {
    //average time compelxity - O(m + n)
    //worst (collisions) - O(m * n)
    func strStr(_ haystack: String, _ needle: String) -> Int {
        let hayStackArr = Array(haystack)
        let needleArr = Array(needle)
        let mod = 1_000_000_007
        let m = haystack.count
        let n = needle.count
        if n > m { return -1 }
        let base = 26
        var hashP = 0
        var power = 1
        //compute base^(n-1) % mod
        for _ in 0..<n-1 {
            power = (power * base) % mod
        }
        //for outgoing characters, this term + ascii of character needs to be subtracted from the overall hash.
        let charAAscii = Character("a").unicodeScalars.first!.value
        //hash of pattern
        for i in 0..<n {
            let incoming: Character = needleArr[i]
            let val = Int(incoming.unicodeScalars.first!.value - charAAscii)
            hashP = (hashP * base + val) % mod

        }

        //iterate over source. Wherever the hash value of source becomes equal to the hash value of pattern, that's where we founf the pattern.
        var hashS = 0
        for i in 0..<m {
            //out - after 4th character, we start having the outgoing character
            if (i >= n) {
                let outgoing = Int(hayStackArr[i - n].unicodeScalars.first!.value - charAAscii)
                //subtract contribution of outgoing chracter
                hashS = (hashS - (outgoing * power) % mod + mod) % mod
            }
            let incomingVal = Int(hayStackArr[i].unicodeScalars.first!.value - charAAscii)
            //include the contributoin of new character
            hashS = (hashS * base + incomingVal) % mod
            
            //after processing and outgoing and incoming elements, if the hash value of source has become hash value of P then return very first index of the pattern in source
            if ((i >= n - 1) && hashS == hashP) {
                //verify to avoid collisions
                let start = i - n + 1
                if (String(hayStackArr[start...i]) == needle) {
                    return start
                }
            }
        }
        return -1
    }
}
