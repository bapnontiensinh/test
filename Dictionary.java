import java.util.Scanner;

import static com.sun.xml.internal.bind.v2.schemagen.Util.equal;

public class Dictionary {
    private final Word[] wordList = new Word[2000];
    private int count;

    public Dictionary() {
        count = 0;
    }

    public void addWord(Word word) {
        wordList[count] = word;
        ++count;
    }

    public void print() {
        for (int i = 0; i < count; ++i) {
            System.out.println((i + 1) + "\t\t|" + wordList[i].getWord_target() + "\t\t|" + wordList[i].getWord_explain());
        }
    }

    public boolean lookUp(String wordToLookUp) {
        for (int i = 0; i < this.count; i++) {
            if (equal(this.wordList[i].getWord_target(), wordToLookUp)
                    || equal(this.wordList[i].getWord_explain(), wordToLookUp))
                return true;
        }
        return false;
    }

    public void deleteWord() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("The word to be deleted is...? :");
        String wordToDelete = scanner.nextLine();
        int length = this.count;
        for (int i = 0; i < length; i++) {
            if (equal(this.wordList[i].getWord_target(), wordToDelete)
                    || equal(this.wordList[i].getWord_explain(), wordToDelete)) {
                this.count--;
                for (int j = i; j < this.count; j++) {
                    this.wordList[j] = this.wordList[j + 1];
                }
            }
        }
        if(length==this.count)
            System.out.println("Nothing to change");
    }
}

