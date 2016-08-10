package CodingProblem;

import Algorithm.Trie.Trie;
import Algorithm.Trie.TrieNode;

import java.util.List;

/**
 * Created by arun.gupta on 22/07/16.
 */
public class MostFrequestWords {
    public static void main(String[] args) {
        String [] inputWords = {"Arun", "Sanjay", "Saket", "Gupta"};
        String inputParagrapgh = "Arun was going to hih hme and then i saw you you are not a good boy";
        findMostFrequestWord(inputWords,inputParagrapgh);
    }

    private static void findMostFrequestWord(String[] inputWords, String inputParagrapgh) {
        Trie trie = new Trie();
//        TrieNode
    }
}
