import java.io.FileNotFoundException;

public class DictionaryCommandline {
    public void showAllWord(Dictionary dict) {
        System.out.println("NO\t\t|English\t|Vietnamese");
        dict.print();
    }

    public void dictionaryBasic(DictionaryManagement dictionaryManagement) {
        dictionaryManagement.insertFromCommandline();
        showAllWord(dictionaryManagement.dictionary);
    }

    public void dictionaryAdvance(DictionaryManagement dictionaryManagement) throws FileNotFoundException {
        dictionaryManagement.insertFromFile();
        this.showAllWord(dictionaryManagement.dictionary);
        //dictionaryManagement.dictionaryLookup();
    }

}
