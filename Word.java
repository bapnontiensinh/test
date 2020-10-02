public class Word {
    private final String word_target;
    private final String word_explain;

    public Word(String word, String meaning) {
        word_target = word;
        word_explain = meaning;
    }

    public String getWord_target() {
        return word_target;
    }

    public String getWord_explain() {
        return word_explain;
    }
}
