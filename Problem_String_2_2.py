class Solution:

    # Time Complexity : O(n)
    # Space Complexity : O(n)

    def calculate(self, s: str) -> int:

        stack = []

        lastsign = "+"

        num = 0

        for i in range(len(s)):

            if s[i].isdigit():

                num = num * 10 + int(s[i])

            if (not s[i].isdigit()) and s[i] != " " or i == len(s) - 1:

                if lastsign == "+":

                    stack.append(num)

                if lastsign == "-":

                    stack.append(-num)

                if lastsign == "*":

                    stack.append(stack.pop() * num)

                if lastsign == "/":

                    stack.append(int(stack.pop() / num))

                lastsign = s[i]

                num = 0

        return sum(stack)

