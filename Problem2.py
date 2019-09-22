class Solution:
	def findAnagrams(self, s: str, p: str) -> List[int]:
		# Time Complexity : O(mn) where n is the length of s because for every element in the s we are checking the same length matches with p
		# Time Limit Exceeded on leetcode - one testcase failed
		analen = len(p)
		p = sorted(p)
		res = []
		for i in range(len(s) - len(p) + 1):
			if sorted(s[i:i + analen]) == p:
				res.append(i)
		return res

	def findAnagrams(self, s: str, p: str) -> List[int]:
		# Time Complexity : O(m + n) where n is the length of p and m is length of s
		p_map = dict()
		for i in p: # O(n) operation
			if i not in p_map:
				p_map[i] = 0
			p_map[i] += 1
		res = []
		match = 0
		for i in range(len(s)): # O(m) operation
			c = s[i]
			# in
			if c in p_map:
				p_map[c] -= 1
				if p_map[c] == 0:
					match += 1
			# out
			if i >= len(p):
				if s[i - len(p)] in p_map:
					p_map[s[i - len(p)]] += 1
					if p_map[s[i - len(p)]] == 1:
						match -= 1
			# match
			if match == len(p_map):
				res.append(i - len(p) + 1)
		return res