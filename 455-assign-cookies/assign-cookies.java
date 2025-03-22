import java.util.*;

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        
        int r = 0;
        for (int i = 0; i < s.length; i++) {
            if (r >= g.length) {
                return r;
            }
            if (g[r] <= s[i]) {
                r++;
            }
        }
        return r;
    }
}
