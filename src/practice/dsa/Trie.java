package practice.dsa;

//for lowercase english chars
public class Trie {
    TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode trieNode = root;
        for(char ch: word.toCharArray()){
            if(!trieNode.hasChar(ch)){
                trieNode.addNode(ch,new TrieNode());
            }
            trieNode = trieNode.getNode(ch);
        }
        trieNode.setEnd(true);
    }

    public boolean search(String word) {
        TrieNode trieNode = root;
        for(char ch: word.toCharArray()){
            if(trieNode.hasChar(ch)){
                trieNode = trieNode.getNode(ch);
            }else{
               return false;
            }
        }
        return trieNode.isEnd();
    }

    public boolean startsWith(String prefix) {
        TrieNode trieNode = root;
        for(char ch: prefix.toCharArray()){
            if(trieNode.hasChar(ch)){
                trieNode = trieNode.getNode(ch);
            }else{
                return false;
            }
        }
        return true;
    }

    class TrieNode {
        TrieNode[] trieNodes;
        boolean end;

        public TrieNode(){
            this.trieNodes = new TrieNode[26];
            this.end = false;
        }

        public boolean isEnd() {
            return end;
        }

        public void setEnd(boolean end) {
            this.end = end;
        }

        public boolean hasChar(char ch){
            return trieNodes[ch-'a'] != null;
        }

        public TrieNode getNode(char ch){
            return trieNodes[ch-'a'];
        }

        public void addNode(char ch, TrieNode node){
            trieNodes[ch-'a'] = node;
        }
    }

/*    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("test");
        trie.insert("tent");
        System.out.println("----------------");

    }*/
}
