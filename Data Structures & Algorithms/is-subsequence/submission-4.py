class Solution:
    def isSubsequence(self, s: str, t: str) -> bool:
        sub_index = 0
        for i in range(0, len(t)):
            if sub_index < len(s) and t[i] == s[sub_index]:
                sub_index += 1

        return sub_index == len(s)