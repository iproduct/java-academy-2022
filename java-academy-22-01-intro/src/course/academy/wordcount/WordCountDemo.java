package course.academy.wordcount;

import java.util.Arrays;

public class WordCountDemo {
    public static final String WORD_SPLITTING_PATTERN = "-?[\\s.!?:;\\\"{},\\[\\]\\d()+–]+-?";
    public static final String SAMPLE_TEXT = "Java is a high-level, class-based, " +
            "object-oriented programming language that is designed to have as few implementation " +
            "dependencies as possible. It is a general-purpose programming language intended to let " +
            "programmers write once, run anywhere (WORA),[17] meaning that compiled Java code can run " +
            "on all platforms that support Java without the need to recompile.[18]\n" +
            "Java applications are typically compiled to bytecode that can run on any Java virtual " +
            "machine (JVM) regardless of the underlying computer architecture. The syntax of Java is " +
            "similar to C and C++, but has fewer low-level facilities than either of them. The Java " +
            "runtime provides dynamic capabilities (such as reflection and runtime code modification) " +
            "that are typically not available in traditional compiled languages. As of 2019, " +
            "Java was one of the most popular programming languages in use according to GitHub,[19][20] " +
            "particularly for client–server web applications, with a reported 9 million developers.[21]\n" +
            "Java was originally developed by James Gosling at Sun Microsystems and released in May 1995 " +
            "as a core component of Sun Microsystems' Java platform. The original and reference " +
            "implementation Java compilers, virtual machines, and class libraries were originally " +
            "released by Sun under proprietary licenses. As of May 2007, in compliance with the " +
            "specifications of the Java Community Process, Sun had relicensed most of its Java " +
            "technologies under the GPL-2.0-only license. Oracle offers its own HotSpot Java Virtual " +
            "Machine, however the official reference implementation is the OpenJDK JVM which is free " +
            "open-source software and used by most developers and is the default JVM for almost all " +
            "Linux distributions. \n"+
            "As of October 2021, Java 17 is the latest version. Java 8, 11 and 17 are the current " +
            "long-term support (LTS) versions. Oracle released the last zero-cost public update for " +
            "the legacy version Java 8 LTS in January 2019 for commercial use, although it will " +
            "otherwise still support Java 8 with public updates for personal use indefinitely. " +
            "Other vendors have begun to offer zero-cost builds of OpenJDK 8 and 11 that are still " +
            "receiving security and other upgrades.\n"
            +"Oracle (and others) highly recommend uninstalling outdated and unsupported versions of Java, " +
            "due to unresolved security issues in older versions.[22] Oracle advises its users to " +
            "immediately transition to a supported version, such as one of the LTS versions (8, 11, 17).\n";

    public static final String[] STOP_WORDS = {
            "when", "didn't", "wasn", "y", "few", "below", "into", "there", "his", "these", "about", "if", "again",
            "too", "were", "then", "doing", "haven", "such", "this", "me", "the", "further", "whom", "having",
            "mightn", "both", "him", "she", "don", "yourselves", "all", "do", "it's", "i", "what", "needn", "had",
            "during", "weren", "wasn't", "up", "will", "just", "isn", "theirs", "own", "ll", "hadn", "aren't",
            "while", "hasn't", "themselves", "re", "in", "she's", "wouldn't", "he", "couldn't", "their", "more",
            "that'll", "ain", "t", "a", "was", "but", "couldn", "only", "been", "so", "until", "have", "from",
            "those", "or", "our", "ourselves", "as", "doesn", "over", "how", "you'd", "where", "itself", "against",
            "very", "you'll", "who", "needn't", "by", "no", "each", "its", "at", "we", "any", "ours", "mightn't",
            "through", "does", "here", "didn", "between", "some", "which", "other", "did", "don't", "hasn", "won",
            "not", "should", "haven't", "on", "now", "with", "you", "them", "himself", "under", "you've", "yours",
            "they", "shouldn", "doesn't", "of", "can", "be", "above", "weren't", "wouldn", "for", "s", "and",
            "hadn't", "herself", "nor", "should've", "am", "once", "ve", "an", "hers", "myself", "to", "her", "is",
            "shan't", "are", "same", "being", "your", "than", "it", "aren", "shan", "d", "m", "isn't", "down",
            "shouldn't", "you're", "why", "o", "yourself", "has", "my", "ma", "out", "that", "mustn't", "because",
            "after", "before", "most", "off", "mustn", "won't"};
    public static WordCount[] indexText(String text, int maxCount){
        String[] words = text.split(WORD_SPLITTING_PATTERN);
        Arrays.sort(STOP_WORDS); // O(N)
        WordCount[] wordCounts = new WordCount[words.length];
        int size = 0;
        for(String word : words) { //O(N)
            word = word.trim().toLowerCase();
            if(word.length() < 3 || Arrays.binarySearch(STOP_WORDS, word) >= 0) { // O(log(N))
                continue;
            }
            int index = Arrays.binarySearch(wordCounts,0, size, new WordCount(word, 0));
            if(index >= 0) { //word found
                WordCount element = wordCounts[index];
                element.setCount(element.getCount() + 1);
            } else {
                size = insert(wordCounts, size, new WordCount(word, 1), -index-1);
            }
        }
        System.out.println(Arrays.toString(wordCounts));
        return new WordCount[0];
    }

    /**
     * Inserts element into array in given index and returns new array size
     * @param wordCounts given array
     * @param size the length of valid data in array
     * @param inserted element to inser in given position into array
     * @param insertIndex the position we want to insert the new element
     * @return the new array size (length of valid data in array)
     */
    public static int insert(WordCount[] wordCounts, int size, WordCount inserted, int insertIndex){
        for(int i = size; insertIndex < i; i--) {
            wordCounts[i] = wordCounts[i-1];
        }
        wordCounts[insertIndex] = inserted;
        return size + 1;
    }

    public static void main(String[] args) {
        for(WordCount wc : indexText(SAMPLE_TEXT, 20)){
            System.out.println(wc);
        }
    }
}
