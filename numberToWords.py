"""
TC: O(1)
"""
class Solution:
    def numberToWords(self, num: int) -> str:
        single = [""] + "One Two Three Four Five Six Seven Eight Nine Ten Eleven Twelve Thirteen Fourteen Fifteen Sixteen Seventeen Eighteen Nineteen".split()
        tens = ["", ""] + "Twenty Thirty Forty Fifty Sixty Seventy Eighty Ninety".split()
        
        def toWord(n):
            if n == 0:
                return ""
            if n//(10**9) > 0:
                return toWord(n//(10**9)) + "Billion " + toWord(n%(10**9))
            if n//(10**6) > 0:
                return toWord(n//(10**6)) + "Million " + toWord(n%(10**6))
            if n//(10**3) > 0:
                return toWord(n//(10**3)) + "Thousand " + toWord(n%(10**3))
            if n //100 > 0 :
                return toWord(n//(10**2)) + "Hundred " + toWord(n%(10**2))
            if n > 19 and (n // 10) > 0 :
                return tens[n//10] + " " + toWord(n%10)
            return single[n] + " "
        
        if num == 0:
            return "Zero"
        return toWord(num).strip()
