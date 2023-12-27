import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

class WordProcessor {
    private Set<String> distinctWords;

    public WordProcessor() {
        distinctWords = new HashSet<>();
    }

    public void readFile(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    distinctWords.add(word.toLowerCase()); // Store words in lowercase for case-insensitive comparison
                }
            }
        }
    }

    public Set<String> getDistinctWords() {
        return distinctWords;
    }
}

class SimilarityCalculator {
    public double calculateSimilarity(Set<String> set1, Set<String> set2) {
        Set<String> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);

        Set<String> union = new HashSet<>(set1);
        union.addAll(set2);

        if (union.isEmpty()) {
            return 0.0; // Avoid division by zero
        }

        return (double) intersection.size() / union.size();
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            WordProcessor wordProcessor1 = new WordProcessor();
            wordProcessor1.readFile("file1.txt");
            Set<String> distinctWords1 = wordProcessor1.getDistinctWords();

            WordProcessor wordProcessor2 = new WordProcessor();
            wordProcessor2.readFile("file2.txt");
            Set<String> distinctWords2 = wordProcessor2.getDistinctWords();

            SimilarityCalculator similarityCalculator = new SimilarityCalculator();
            double similarity = similarityCalculator.calculateSimilarity(distinctWords1, distinctWords2);

            System.out.println("Jaccard Similarity Coefficient: " + similarity);

        } catch (IOException e) {
            System.err.println("Error reading files: " + e.getMessage());
        }
    }
}
