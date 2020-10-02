import javafx.fxml.FXML;
import javafx.scene.control.Label;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class DictionaryManagement {
    Dictionary dictionary;

    DictionaryManagement() {
        dictionary = new Dictionary();
    }

    public void insertFromCommandline() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input the numbers of word:");
        int inputNum = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Input the Words and Meanings : ");
        for (int i = 0; i < inputNum; i++) {
            String tempWord = scanner.nextLine();
            String tempMeaning = scanner.nextLine();
            Word word = new Word(tempWord, tempMeaning);
            dictionary.addWord(word);
        }
    }

    public void insertFromFile() throws FileNotFoundException {
        File wordList = new File("dictionary_data.txt");

        try {
            Scanner scanner = new Scanner(wordList);

            String tempWord, tempMeaning;

            while (scanner.hasNext()) {
                tempWord = scanner.next();
                tempWord = scanner.next();
                tempMeaning = scanner.next();
                Word word = new Word(tempWord, tempMeaning);
                dictionary.addWord(word);
                scanner.nextLine();
            }
        } catch (FileNotFoundException ex) {
            System.out.print("File not found");
        }
    }

    public void dictionaryLookup(String wordToLookUp, Label wordDefinition) {
        if (dictionary.lookUp(wordToLookUp) == true) {
            wordDefinition.setText("I found it!! '" + wordToLookUp + "'is in the dictionary");
        } else {
            wordDefinition.setText("The word was not found in the dictionary");
        }
    }

    public void dataModify() {
        System.out.println("Select option:\n" +
                "1.Add word\n" +
                "2.Delete word\n" +
                "Your answer?                 ");
        int option;
        Scanner scanner = new Scanner(System.in);


        boolean stop = true;
        while (stop) {
            option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1: {
                    System.out.println("Input the Words and Meanings : ");
                    String tempWord = scanner.nextLine();
                    String tempMeaning = scanner.nextLine();
                    Word word = new Word(tempWord, tempMeaning);
                    dictionary.addWord(word);
                    stop = false;
                    break;
                }
                case 2: {
                    dictionary.deleteWord();
                    stop = false;
                    break;
                }
                default: {
                    System.out.print("Please re-enter: ");
                }
            }
        }
    }
}
