below_20 = ['', 'One', 'Two', 'Three', 'Four', 'Five', 'Six', 'Seven', 'Eight', 'Nine', 'Ten', 'Eleven', 'Twelve', 'Thirteen', 'Fourteen', 'Fifteen', 'Sixteen', 'Seventeen', 'Eighteen', 'Nineteen']
tens = ['', 'Ten', 'Twenty', 'Thirty', 'Forty', 'Fifty', 'Sixty', 'Seventy', 'Eighty', 'Ninety']
thousands = ['', 'Thousand', 'Million', 'Billion']

class Solution(object):
    def numberToWords(self, num):
        """
        :type num: int
        :rtype: str
        """
        def helper(num):
            if num == 0: return ""
            elif num < 20: return below_20[num] + " "
            elif num < 100: return tens[num/10] + " " + helper(num%10)
            else: return below_20[num/100] + " Hundred " + helper(num%100)
        if num == 0: return "Zero"
        i = 0
        res = ""
        result = ""
        while num > 0:
            if num%1000 != 0:
                result = helper(num%1000) + thousands[i] + " " + result
            num = num/1000
            i += 1
        return result.strip()