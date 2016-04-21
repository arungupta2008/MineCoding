package AlgorithmProblems.TrieProblem;

import Algorithm.Trie.Trie;
import Algorithm.Trie.TrieNode;
import Helper.Vertex;

import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by arun.gupta on 20/04/16.
 */
/*
* Given a stream of characters (e.g. acacabcatghhellomvnsdb) and a list of words (e.g. ["aca","cat","hello","world"] ) find and display count of each and every word once the stream ends.(Like : "aca" : 2 , "cat" : 1 , "hello" : 1 , "world" : 0 ).
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

        List<TrieNode> trieNodeList = new ArrayList<>();

        System.out.print("Please enter Input Stream : ");
        input = scanner.nextLine();
        for (char latter : input.toCharArray()) {
            List<TrieNode> trieNodesIterator = new ArrayList<>(trieNodeList);
            int i = 0;
            for (TrieNode trieNodeIt : trieNodesIterator) {
                TrieNode nextTrieNode = trie.getNextTrieNode(latter, trieNodeIt);
                if (nextTrieNode == null) {
                    trieNodeList.remove(trieNodeIt);
                } else if (nextTrieNode.isLeaf()) {
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
