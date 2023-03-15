"""
Rasika Sasturkar
Time Complexity: O(n), n is the length of string
Space Complexity: O(1)
"""


def findAnagrams(s: str, p: str):
    """
    To avoid creating substrings of the given string, we can use sliding
    window. We handle the cases of incoming and outgoing character
    and keep track of the matching characters in the pattern using a
    match variable that tells us the exact no. of characters in our current
    window matching the pattern string.
    """
    result = []
    if len(p) > len(s):
        return result

    freq_map = {}
    for char in p:
        if char not in freq_map:
            freq_map[char] = 1
        else:
            freq_map[char] += 1

    match = 0

    for i in range(len(s)):
        # for incoming character
        in_char = s[i]
        if in_char in freq_map:
            count = freq_map[in_char]
            count -= 1
            freq_map[in_char] = count
            if count == 0:
                match += 1

        # for outgoing character
        if i >= len(p):
            out_char = s[i - len(p)]
            if out_char in freq_map:
                count = freq_map[out_char]
                count += 1
                freq_map[out_char] = count
                if count == 1:
                    match -= 1

        if match == len(freq_map):
            result.append(i - len(p) + 1)

    return result


def main():
    """
    Main function - examples from LeetCode problem to show the working.
    This code ran successfully on LeetCode and passed all test cases.
    """
    print(findAnagrams(s="cbaebabacd", p="abc"))  # return [0, 6]
    print(findAnagrams(s="abab", p="ab"))  # return [0, 1, 2]


if __name__ == "__main__":
    main()
