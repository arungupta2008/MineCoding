package CodingProblem;

import Algorithm.Trie.Trie;
import Algorithm.Trie.TrieNode;

import java.util.*;

/**
 * Created by arun.gupta on 23/08/16.
 * <p>
 * <p>
 * <p>
 * Given A Phone No and Dictionary. Try to Convert it to Memorable words.
 * 1. Digit Will have 0-9.
 * 2. Follow T9 Standard Only.
 * That means for Every Digit you have Three Options to Select the Character.
 */
public class PhoneNoToWord {
    public static void main(String[] args) {
//        String[] dictionary = {"arun", "gupta", "khana", "kha", "lo", "do", "you", "kno", "me", "en", "yn", "ul", "no"};

        // Input Sets
        String phoneNo = "36968566";
        String[] dictionary = {"do", "you", "kno", "en", "yn", "ul", "no"};


        Trie trie = new Trie();
        for (String inputWord : dictionary) {
            trie.addWord(inputWord);
        }
        Map<Integer, HashSet<Character>> T9 = setupT9Keyboard();
        findAllOptions(T9, phoneNo, trie);
    }

    private static Map<Integer, HashSet<Character>> setupT9Keyboard() {
        Map<Integer, HashSet<Character>> T9 = new HashMap<Integer, HashSet<Character>>();
        HashSet<Character> input2 = new HashSet<>();
        input2.add('a');
        input2.add('b');
        input2.add('c');

        HashSet<Character> input3 = new HashSet<>();
        input3.add('d');
        input3.add('e');
        input3.add('f');

        HashSet<Character> input4 = new HashSet<>();
        input4.add('g');
        input4.add('h');
        input4.add('i');

        HashSet<Character> input5 = new HashSet<>();
        input5.add('j');
        input5.add('k');
        input5.add('l');

        HashSet<Character> input6 = new HashSet<>();
        input6.add('m');
        input6.add('n');
        input6.add('o');

        HashSet<Character> input7 = new HashSet<>();
        input7.add('p');
        input7.add('q');
        input7.add('r');
        input7.add('s');

        HashSet<Character> input8 = new HashSet<>();
        input8.add('t');
        input8.add('u');
        input8.add('v');

        HashSet<Character> input9 = new HashSet<>();
        input9.add('w');
        input9.add('x');
        input9.add('y');
        input9.add('z');

        T9.put(2, input2);
        T9.put(3, input3);
        T9.put(4, input4);
        T9.put(5, input5);
        T9.put(6, input6);
        T9.put(7, input7);
        T9.put(8, input8);
        T9.put(9, input9);
        return T9;
    }

    /**
     * @param t9
     * @param phoneNo
     * @param trie    Idea is to Iterate Over Trie (Dictionary) word by word if, If You reach to Leaf node and Still digits are coming again re-start from Trie Root.
     */
    private static void findAllOptions(Map<Integer, HashSet<Character>> t9, String phoneNo, Trie trie) {
        char[] phoneNoDigits = phoneNo.toCharArray();

        // This will be used to Store All interMediate Solutions
        Set<TrieNode> trieNodeStack = new HashSet<>();
        boolean isFirstDigit = true;

        for (char digitCharacter : phoneNoDigits) {
            Set<TrieNode> trieNodesIterator = new HashSet<>(trieNodeStack);
            for (Character options : t9.get(Character.getNumericValue(digitCharacter))) {
                // If Fist Digit of Phone no. Just search it in Trie and Put to Solution List.
                if (isFirstDigit) {
                    TrieNode node = trie.getNextTrieNode(options);
                    if (node != null) {
                        trieNodeStack.add(node);
                    }
                } else {
                    if (trieNodeStack.size() == 0) {
                        System.out.println("No Solution Found");
                        break;
                    }
                    for (TrieNode node : trieNodesIterator) {
                        TrieNode response = null;

                        // If Leaf node then Restart searching from Root node.
                        if (node.isLeaf()) {
                            // Searching from Root node
                            response = trie.getNextTrieNode(options);
                            if (response != null) {
                                // Adding Space Node for Keeping Space between two Words.
                                TrieNode spaceNode = new TrieNode(' ');
                                spaceNode.setParent(node);


                                // Copy by value, otherwise it was coming as Copy by reference then it was creating problem if we modify the Object.
                                response = new TrieNode(response);
                                // Setting up Older Parents, because if we don't it will forget older search. // Adding Space Node.
                                response.setParent(spaceNode);
                            }
                        } else {
                            // Getting Next Node for given Location in Trie
                            response = trie.getNextTrieNode(options, node);
                            if (response != null) {
                                // In Second Iterations Error Case:  Let's Root==>Y==>N is the current Situation of the Tree. And if i am trying to Find out the next node for Y.
                                // It will gimme the Child(N) with parent Y.
                                // It's Possible that second iteration or more iteration is going on then If i take the chile Node.
                                // Then i am loosing Older Parent information.
                                if (response.getParent().getCharacter() == node.getCharacter() // Check if child have same value as Parent Node.
                                        && node.getParent().getCharacter() != '\u0000' // This Prevents First iteration values to be modified.
                                        ) {
                                    response = new TrieNode(response);
                                    response.setParent(node);
                                }
                            }
                        }
                        // Adding to Temp List
                        if (response != null) {
                            trieNodeStack.add(response);
                        }
                    }
                }
            }
            isFirstDigit = false;
            trieNodeStack.removeAll(trieNodesIterator);
        }
        System.out.println("Result : " + trieNodeStack);
    }
}