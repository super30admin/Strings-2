#https://leetcode.com/problems/implement-strstr/
#runtime: O(m + c) where m is the haystack size
#space: O(n) where n is the size of the needle
#passing leetcode: yes
#problems:
#
# understanding the algorithm
#
# explanation:
#
# generate an LPS, ie longest prefix suffix
# use the LPS when searching through the haystack
#
# (still struggling with the explanation!)

#/**
# * @param {string} haystack
# * @param {string} needle
# * @return {number}
# */
strStr = (haystack, needle) ->
  calc_LPS = (needle) ->
    LPS = Array(needle.length)

    LPS[0] = 0
    i = 1
    j = 0

    while i < needle.length
      ch_i = needle[i]
      ch_j = needle[j]

      # case 1
      if ch_i is ch_j
        j += 1
        LPS[i] = j
        i += 1

# case 2
      else if j > 0 and ch_i isnt ch_j
        j = LPS[j - 1]
# case 3
      else if j is 0 and ch_i isnt ch_j
        LPS[i] = 0
        i += 1
    LPS

  return 0 if needle.length is 0

  LPS = calc_LPS(needle)

  i = 0
  j = 0

  while i < haystack.length
    ch_i = haystack[i]
    ch_j = needle[j]

    # Case 1
    if ch_i is ch_j
      i += 1
      j += 1

    # Case 2
    if j is needle.length
      return i - j

    # Case 3
    else if j > 0 and ch_i isnt ch_j
      j = LPS[j - 1]

    # Case 4
    else if j is 0 and ch_i isnt ch_j
      i += 1

  -1

#Input: haystack = "hello", needle = "ll"
#Output: 2
console.log(strStr('hello', 'll'))

#
#Example 2:
#
#Input: haystack = "aaaaa", needle = "bba"
#Output: -1
console.log(strStr('aaaaa', 'bba'))

#
#Example 3:
#
#Input: haystack = "", needle = ""
#Output: 0
console.log(strStr('', ''))

