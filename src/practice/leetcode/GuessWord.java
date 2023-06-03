package practice.leetcode;

import java.util.HashSet;
import java.util.Set;

public class GuessWord {
    public void findSecretWord(String[] words, Master master) {
        Set<String> wordSet = new HashSet<>();
        //Add all words in set
        for(String word: words){
            wordSet.add(word);
        }

        while(!wordSet.isEmpty()){
            String word = wordSet.stream().findFirst().get();
            int matchCount = master.guess(word);
            if(matchCount == word.length()){
                break;
            }
            wordSet.removeIf(w1 -> matchCount != matchedLetterCount(w1, word));
        }
    }

    static int matchedLetterCount(String word1, String word2){
        int count=0;
        for(int i=0; i<word1.length(); i++){
            if(i < word2.length() && word1.charAt(i)==word2.charAt(i)){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        GuessWord solution = new GuessWord();
        String[] words = {"acckzz","ccbazz","eiowzz","abcczz","hamada","khaled"};
        Master master = new Master("hamada");
        solution.findSecretWord(words,master);
        System.out.println("Guess count: "+master.getGuessCount());
    }
}

class Master{
    private final String secret;
    private int guessCount;
    public Master(String secret){
        this.secret = secret;
        guessCount = 0;
    }

    int guess(String word){
        guessCount++;
        return GuessWord.matchedLetterCount(secret,word);
    }

    public int getGuessCount() {
        return guessCount;
    }
}
