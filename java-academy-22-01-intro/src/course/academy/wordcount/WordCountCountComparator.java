package course.academy.wordcount;

import java.util.Comparator;

public class WordCountCountComparator implements Comparator<WordCount> {

    @Override
    public int compare(WordCount wc1, WordCount wc2) {
        return (wc1.getCount() < wc2.getCount()) ? -1 :
                (wc1.getCount() > wc2.getCount()) ? 1 :
                        wc1.getWord().compareTo(wc2.getWord());
    }
}
