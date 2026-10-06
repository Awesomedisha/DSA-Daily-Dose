class WordDictionary {

    class Node {
        Node[] child = new Node[26];
        boolean end;
    }

    Node root = new Node();

    public void addWord(String word) {
        Node curr = root;

        for (char c : word.toCharArray()) {
            int i = c - 'a';

            if (curr.child[i] == null)
                curr.child[i] = new Node();

            curr = curr.child[i];
        }

        curr.end = true;
    }

    public boolean search(String word) {
        return dfs(root, word, 0);
    }

    private boolean dfs(Node curr, String word, int i) {
        if (i == word.length())
            return curr.end;

        char c = word.charAt(i);

        if (c != '.') {
            int idx = c - 'a';

            if (curr.child[idx] == null)
                return false;

            return dfs(curr.child[idx], word, i + 1);
        }

        for (Node next : curr.child) {
            if (next != null && dfs(next, word, i + 1))
                return true;
        }

        return false;
    }
}