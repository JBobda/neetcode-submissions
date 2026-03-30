class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:

        ad_list = defaultdict(list)
        
        for course, pre in prerequisites:
            ad_list[course].append(pre)
        
        def dfs(ad_list, visited, i):
            if len(ad_list[i]) == 0:
                return True

            if i in visited:
                return False
            
            visited.add(i)

            for pre in ad_list[i]:
                if not dfs(ad_list, visited, pre):
                    return False

            visited.remove(i)
            return True


        for i in range(numCourses):
            visited = set()
            if not dfs(ad_list, visited, i):
                return False

        return True

        