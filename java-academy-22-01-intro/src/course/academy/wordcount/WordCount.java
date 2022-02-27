package course.academy.wordcount;

public class WordCount implements Comparable<WordCount>{
    private String word;
    private int count;

    public WordCount() {
    }

    public WordCount(String word, int count) {
        this.word = word;
        this.count = count;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WordCount)) return false;

        WordCount wordCount = (WordCount) o;

        return getWord().equals(wordCount.getWord());
    }

    @Override
    public int hashCode() {
        return getWord().hashCode();
    }

    @Override
    public String toString() {
        return "(" + word + " ," + count + ")";
    }

    @Override
    public int compareTo(WordCount other) {
        return word.compareTo(other.word);
//        return (count < other.count) ? -1 : (count > other.count) ? 1 : word.compareTo(other.word);
    }
}
