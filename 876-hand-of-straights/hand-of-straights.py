import heapq
from collections import Counter

class Solution(object):
    def isNStraightHand(self, hand, groupSize):
        # If total cards aren't divisible by groupSize, it's impossible
        if len(hand) % groupSize != 0:
            return False

        # Count the frequency of each card
        card_count = Counter(hand)
        
        # Use a heap to process cards in sorted order
        min_heap = list(card_count.keys())
        heapq.heapify(min_heap)

        while min_heap:
            start = min_heap[0]  # Get the smallest card
            for card in range(start, start + groupSize):
                if card_count[card] == 0:
                    return False  # Cannot form a group
                card_count[card] -= 1
                if card_count[card] == 0:
                    # Remove the card from the heap
                    if card != min_heap[0]:
                        return False  # The heap is no longer valid if out of order
                    heapq.heappop(min_heap)

        return True
