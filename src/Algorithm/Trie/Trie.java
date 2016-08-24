package Algorithm.Trie;

/**
 * Created by arun.gupta on 20/04/16.
 * * Copied From  :: https://community.oracle.com/thread/2070706
 */

import java.util.ArrayList;
import java.util.List;

public class Trie {
    private TrieNode root;

    /**
     * Constructor
     */
    public Trie() {
        root = new TrieNode();
    }

    /**
     * Returns Root node of the Tri
     * @return
     */
    public TrieNode getRootNode(){
        return root;
    }

    /**
     * Adds a word to the Trie
     *
     * @param word
     */
    public void addWord(String word) {
        root.addWord(word.toLowerCase());
    }

    /**
     * Get the words in the Trie with the given
     * prefix
     *
     * @param prefix
     * @return a List containing String objects containing the words in
     * the Trie with the given prefix.
     */
    public List getWords(String prefix) {
        //Find the node which represents the last letter of the prefix
        TrieNode lastNode = root;
        for (int i = 0; i < prefix.length(); i++) {
            lastNode = lastNode.getNode(prefix.charAt(i));

            //If no node matches, then no words exist, return empty list
            if (lastNode == null) return new ArrayList();
        }
        //Return the words which eminate from the last node
        return lastNode.getWords();
    }

    public TrieNode getNextTrieNode(char character){
        TrieNode lastNode = root;
        return lastNode.getNode(character);
    }

    public TrieNode getNextTrieNode(char character, TrieNode trieNode){
        return trieNode.getNode(character);
//        TrieNode node  = trieNode.getNode(character);
//        if(node !=null){
//            node.setParent(trieNode.getParent());
//        }
//        return node;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.trieTest();
    }

    private void trieTest() {
        System.out.println("Trie Testing");
        Trie trie = new Trie();
        trie.addWord("Arun");
        trie.addWord("Ajay");
        trie.addWord("Guay");

        System.out.println("Words : "+ trie.getWords("a"));
        System.out.println("No Words Should come: "+ trie.getWords("u"));
    }
}
