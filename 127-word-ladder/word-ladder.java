import java.util.*;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // Create a queue for BFS, storing pairs of (word, steps)
        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(beginWord, 1)); // Start with the beginWord and step count 1

        // Convert wordList to a set for O(1) lookups and deletions
        Set<String> wordSet = new HashSet<>(wordList);

        // If the beginWord is in the set, remove it to avoid revisiting
        if (wordSet.contains(beginWord)) {
            wordSet.remove(beginWord);
        }

        // Perform BFS
        while (!queue.isEmpty()) {
            Pair<String, Integer> current = queue.poll();
            String word = current.getKey();
            int steps = current.getValue();

            // If the current word matches the endWord, return the steps
            if (word.equals(endWord)) {
                return steps;
            }

            // Try changing each character of the word to all possible letters (a-z)
            for (int i = 0; i < word.length(); i++) {
                char[] wordArray = word.toCharArray(); // Convert the word to a char array for easy manipulation
                char originalChar = wordArray[i]; // Save the original character

                for (char ch = 'a'; ch <= 'z'; ch++) {
                    wordArray[i] = ch; // Replace the character at position i with ch
                    String newWord = new String(wordArray); // Convert the char array back to a string

                    // If the new word exists in the wordSet, add it to the queue
                    if (wordSet.contains(newWord)) {
                        wordSet.remove(newWord); // Mark as visited
                        queue.add(new Pair<>(newWord, steps + 1)); // Add to queue with incremented steps
                    }
                }

                // Restore the original character for the next iteration
                wordArray[i] = originalChar;
            }
        }

        // If no transformation sequence is found, return 0
        return 0;
    }
}

// Custom Pair class since Java does not have a built-in Pair class
class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}

// Driver code
