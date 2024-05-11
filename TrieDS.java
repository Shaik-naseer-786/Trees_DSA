class TrieNode {
    TrieNode[] children;
    boolean isEndOfWord;

    TrieNode() {
        children = new TrieNode[26]; 
        isEndOfWord = false;
    }
}

class TrieDS {
    TrieNode root;

    TrieDS() {
        root = new TrieNode();
    }

    void insert(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a'; 
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.isEndOfWord = true;
    }

    boolean search(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a'; 
            if (current.children[index] == null) {
                return false;
            }
            current = current.children[index];
        }
        return current != null && current.isEndOfWord;
    }
}

class Main {
    public static void main(String[] args) {
        TrieDS trie = new TrieDS();

        
        trie.insert("shaiknaseer");
        trie.insert("shaikabdul");

        
        System.out.println("Search for 'shaiknaseer': " + trie.search("shaiknaseer"));
        System.out.println("Search for 'shaikabdul': " + trie.search("shaikabdul"));
        System.out.println("Search for 'shaik': " + trie.search("shaik"));
        System.out.println("Search for 'abdul': " + trie.search("abdul"));
    }
}