import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Trie trie = new Trie();

        for (String str : phone_book) {
            trie.insert(str);
        }

        for (String prefix : phone_book) {
            if (trie.searchPrefix(prefix)) {
                return false;
            }
        }

        return true;
    }
}

class Node {
    Map<Character, Node> child;
    boolean isTerminal;

    public Node() {
        child = new HashMap<>();
        isTerminal = false;
    }
}

class Trie {
    Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String str) {
        Node cur = root;

        for (char ch : str.toCharArray()) {
            cur = cur.child.computeIfAbsent(ch, x -> new Node());
        }

        cur.isTerminal = true;
    }

    public boolean searchPrefix(String prefix) {
        Node cur = root;

        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            cur = cur.child.get(c);

            if (cur == null) {
                return false;
            }

            if (cur.isTerminal) {
                if (i == prefix.length() - 1) {
                    return false;
                } else {
                    return true;
                }
            }
        }

        return !cur.child.isEmpty();
    }
}
