package Algorithm.Trie;

/**
 * Created by arun.gupta on 20/04/16.
 * Copied From  :: https://community.oracle.com/thread/2070706
 */

// It only works on small Letters.

import java.util.ArrayList;
import java.util.List;

public class TrieNode {
    private TrieNode parent;
    private TrieNode[] children;
    private boolean isLeaf;     //Quick way to check if any children exist
    private boolean isWord;     //Does this node represent the last character of a word
    private char character;     //The character this node represents

    public TrieNode(TrieNode response) {
        this.parent = response.getParent();
        this.children = response.getChildren();
        this.isLeaf = response.isLeaf();
        this.isWord = response.isWord;
        this.character = response.character;
    }


    public TrieNode getParent() {
        return parent;
    }

    public void setParent(TrieNode parent) {
        this.parent = parent;
    }

    public TrieNode[] getChildren() {
        return children;
    }

    public void setChildren(TrieNode[] children) {
        this.children = children;
    }

    public void setLeaf(boolean leaf) {
        isLeaf = leaf;
    }

    public boolean isWord() {
        return isWord;
    }

    public void setWord(boolean word) {
        isWord = word;
    }

    public char getCharacter() {
        return character;
    }

    public void setCharacter(char character) {
        this.character = character;
    }

    /**
     * Constructor for top level root node.
     */
    public TrieNode() {
        children = new TrieNode[26];
        isLeaf = true;
        isWord = false;
    }

    /**
     * Constructor for child node.
     */
    public TrieNode(char character) {
        this();
        this.character = character;
    }

    /**
     * Adds a word to this node. This method is called recursively and
     * adds child nodes for each successive letter in the word, therefore
     * recursive calls will be made with partial words.
     *
     * @param word the word to add
     */
    protected void addWord(String word) {
        isLeaf = false;
        int charPos = word.charAt(0) - 'a';

        if (children[charPos] == null) {
            children[charPos] = new TrieNode(word.charAt(0));
            children[charPos].parent = this;
        }

        if (word.length() > 1) {
            children[charPos].addWord(word.substring(1));
        } else {
            children[charPos].isWord = true;
        }
    }

    /**
     * Returns the child TrieNode representing the given char,
     * or null if no node exists.
     *
     * @param c
     * @return
     */
    protected TrieNode getNode(char c) {
        return children[c - 'a'];
    }

    /**
     * Returns a List of String objects which are lower in the
     * hierarchy that this node.
     *
     * @return
     */
    protected List getWords() {
        //Create a list to return
        List list = new ArrayList();

        //If this node represents a word, add it
        if (isWord) {
            list.add(toString());
        }

        //If any children
        if (!isLeaf) {
            //Add any words belonging to any children
            for (int i = 0; i < children.length; i++) {
                if (children[i] != null) {
                    list.addAll(children[i].getWords());

                }

            }

        }

        return list;

    }

    public boolean isLeaf(){
        return this.isLeaf;
    }

    /**
     * Gets the String that this node represents.
     * <p>
     * For example, if this node represents the character t, whose parent
     * <p>
     * represents the charater a, whose parent represents the character
     * <p>
     * c, then the String would be "cat".
     *
     * @return
     */

    public String toString() {
        if (parent == null) {
            return "";
        } else {
            return parent.toString() + new String(new char[]{character});
        }
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
