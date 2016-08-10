package AlgorithmProblems.TrieProblem;

import Algorithm.Trie.Trie;
import Algorithm.Trie.TrieNode;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by arun.gupta on 20/04/16.
 */
/*
* Given a stream of characters (e.g. acacabcatghhellomvnsdb) and a list of words (e.g. ["aca","cat","hello","world"]
* )  find and display count of each and every word once the stream ends.(Like : "aca" : 2 , "cat" : 1 , "hello" : 1 , "world" : 0 ).
*
*
* So Idea is every time we en-counter a character it can have following cases
* 1. It's starting of the word.
* 2. This is a part of dictionary word
* 3. It is a Leaf Node.
*
* Keep all Location of the trie Tree in List. and try adding new character and try to find new combination should be
* working.
* */
public class Problem1 {

    public static void main(String[] args) {
        Trie trie = new Trie();
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        System.out.print("Please enter words with Space : ");
        String input = scanner.nextLine();
        for (String inputCharacter: input.split("\\s+")){
            trie.addWord(inputCharacter);
        }

        // This is used to Save all possible solution
        // EveryTime a new character is came try to find all possible solutions.
        List<TrieNode> trieNodeList = new ArrayList<TrieNode>();

        System.out.print("Please enter Input Stream : ");
        input = scanner.nextLine();
        for (char latter : input.toCharArray()) {
            List<TrieNode> trieNodesIterator = new ArrayList<TrieNode>(trieNodeList);
            int i = 0;
            for (TrieNode trieNodeIt : trieNodesIterator) {
                TrieNode nextTrieNode = trie.getNextTrieNode(latter, trieNodeIt);

                // Means for current Trie branch no child have that latter.
                if (nextTrieNode == null) {
                    trieNodeList.remove(trieNodeIt);
                } else if (nextTrieNode.isLeaf()) {
                    // Means We found word in directory.
                    System.out.println("Found a Dictionary : " + nextTrieNode.toString());
                }else {
                    Collections.replaceAll(trieNodeList, trieNodeIt, nextTrieNode);
                    //trieNodeList.set(i,nextTrieNode);
                }
                ++i;
            }
            TrieNode trieNode = trie.getNextTrieNode(latter);
            if (trieNode == null) {

            } else if (trieNode.isLeaf()) {
                System.out.println("Found a Dictionary : " + trieNode.toString());
            } else {
                trieNodeList.add(trieNode);
            }
        }

    }
}
