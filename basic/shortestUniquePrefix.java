public class shortestUniquePrefix {
    class TrieNode {
        int cnt;
        TrieNode[] next = new TrieNode[26];

        TrieNode(int cnt) {
            this.cnt = cnt;
            for (int i = 0; i < 26; i++)
                next[i] = null;
        }
    }

    public class Solution {

        public void build(TrieNode root, String s) {
            if (s.equals(""))
                return;
            if (root.next[s.charAt(0) - 'a'] != null) {
                char c = s.charAt(0);
                s = s.substring(1);
                root.next[c - 'a'].cnt += 1;
                build(root.next[c - 'a'], s);
                return;
            }
            if (s.length() == 1) {
                root.next[s.charAt(0) - 'a'] = new TrieNode(1);
                return;
            } else {
                char c = s.charAt(0);
                s = s.substring(1);
                root.next[c - 'a'] = new TrieNode(1);
                build(root.next[c - 'a'], s);
            }
        }

        public TrieNode createTrie(String[] A) {
            TrieNode root = new TrieNode(0);
            for (int i = 0; i < A.length; i++) {
                build(root, A[i]);
            }
            return root;
        }

        public String searchPrefix(TrieNode root, String s) {
            if (s.length() == 0 || root == null) {
                return s;
            }
            char ch = s.charAt(0);
            if (root.next[ch - 'a'].cnt == 1) {
                return Character.toString(ch);
            }
            s = s.substring(1);
            return Character.toString(ch) + searchPrefix(root.next[ch - 'a'], s);
        }

        public String[] prefix(String[] A) {
            String[] r = new String[A.length];
            TrieNode root = createTrie(A);
            for (int i = 0; i < A.length; i++) {
                r[i] = searchPrefix(root, A[i]);
            }
            return r;
        }
    }
    
}
