from collections import deque

class Solution(object):
    def orangesRotting(self, grid):
        if not grid:
            return 0

        m, n = len(grid), len(grid[0])
        days, total, count = 0, 0, 0
        rotten = deque()

        # Count total oranges and push initially rotten ones into the queue
        for i in range(m):
            for j in range(n):
                if grid[i][j] != 0:
                    total += 1
                if grid[i][j] == 2:
                    rotten.append((i, j))

        directions = [(0, 1), (0, -1), (1, 0), (-1, 0)]

        while rotten:
            k = len(rotten)
            count += k
            for _ in range(k):
                x, y = rotten.popleft()
                for dx, dy in directions:
                    nx, ny = x + dx, y + dy
                    if 0 <= nx < m and 0 <= ny < n and grid[nx][ny] == 1:
                        grid[nx][ny] = 2
                        rotten.append((nx, ny))

            if rotten:
                days += 1

        return days if total == count else -1


