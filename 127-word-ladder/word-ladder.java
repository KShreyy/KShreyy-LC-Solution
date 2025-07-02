import java.util.*;

class Pair {
    String str;
    int num;
    
    Pair(String str, int num) {
        this.str = str;
        this.num = num;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // Convert list to set for O(1) lookup
        Set<String> set = new HashSet<>(wordList);
        
        if (!set.contains(endWord)) return 0;  // endWord must be in the list

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord, 1));
        
        while (!q.isEmpty()) {
            Pair element = q.poll();
            String word = element.str;
            int level = element.num;
            
            if (word.equals(endWord)) return level;
            
            for (int i = 0; i < word.length(); i++) {
                char[] chars = word.toCharArray();
                for (char c = 'a'; c <= 'z'; c++) {
                    if (chars[i] == c) continue;  // avoid unnecessary work
                    
                    chars[i] = c;
                    String newWord = new String(chars);
                    
                    if (set.contains(newWord)) {
                        q.add(new Pair(newWord, level + 1));
                        set.remove(newWord);  // mark as visited
                    }
                }
            }
        }
        
        return 0;  // if endWord not reachable
    }
}

/*
class Pair{
    String str;
    int num;
    Pair(String str,int num){
        this.str=str;
        this.num=num;
    }
}
class Solution {
    pubic pair(String str,int count){}
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        //making a set ds to stoe the wordlist for less tC linear search
        Set<String> set=new Hashset<>();
        for(String element:wordList){
            set.add(element);
        }
        
        //make a queueu to do bfs
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(){beginword,1});

        //start a for loop 
        while(!q.isEmpty()){
            Pair element=q.poll();
            String s=element.str;
            int val=element.num;
            for(int i=0;i<s.length();i++){
                 char ch=s.charAt(i);
                 for(char ch='a';ch<='z';ch++){
                    String new_string=s.substring(0,i)+ch+s.substring(i+1,s.length());
                    
                    if(set.contains(new_string)){
                        count=count+1;
                        q.add(Pair(){new_string,count});
                    }
                 }
            }

        }

    }
}
*/