from collections import Counter
import heapq

class Solution:
    def leastInterval(self, tasks, n):
        # Step 1: Count the frequency of each task
        task_counts = Counter(tasks)
        
        # Step 2: Use a max-heap (negative frequencies for max-heap simulation)
        max_heap = [-count for count in task_counts.values()]
        heapq.heapify(max_heap)

        time = 0
        while max_heap:
            temp = []
            for _ in range(n + 1):  # Schedule up to n + 1 tasks in one round
                if max_heap:
                    temp.append(heapq.heappop(max_heap))
            
            for task in temp:
                if task + 1 < 0:  # Decrease frequency and add back if needed
                    heapq.heappush(max_heap, task + 1)
            
            # If the heap is empty, stop early; otherwise, add idle time
            time += n + 1 if max_heap else len(temp)
        
        return time
