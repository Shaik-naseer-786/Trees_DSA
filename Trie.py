class TrieNode:
    def __init__(self):
        self.children = {}
        self.is_end_of_word = False

class Trie:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word):
        node = self.root
        for char in word:
            if char not in node.children:
                node.children[char] = TrieNode()
            node = node.children[char]
        node.is_end_of_word = True

    def search(self, word):
        node = self.root
        for char in word:
            if char not in node.children:
                return False
            node = node.children[char]
        return node.is_end_of_word

    def delete(self, word):
        def _delete_helper(node, word, depth):
            if depth == len(word):
                if not node.is_end_of_word:
                    return False
                node.is_end_of_word = False
                return len(node.children) == 0
            char = word[depth]
            if char not in node.children:
                return False
            should_delete_current_node = _delete_helper(node.children[char], word, depth + 1)
            if should_delete_current_node:
                del node.children[char]
                return len(node.children) == 0
            return False

        _delete_helper(self.root, word, 0)


trie = Trie()
trie.insert("hello")
trie.insert("world")
trie.insert("Application")
trie.insert("Apple")

print(trie.search("Apple")) 
trie.delete("Apple")
print(trie.search("Application"))
print(trie.search("Apple"))
