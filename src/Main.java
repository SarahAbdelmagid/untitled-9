import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String sentence = "Java öğrenmeyi seviyorum ama zor olmasa keşke";
        int maxWordLength = 3;

        List<String> result = kelimelereAyir(sentence, maxWordLength);
        System.out.println(result);

        maxWordLength = 6;
        result = kelimelereAyir(sentence, maxWordLength);
        System.out.println(result);
    }

    public static List<String> kelimelereAyir(String sentence, int maxWordLength) {
        String[] words = sentence.split("\\s+");
        List<String> result = new ArrayList<>();

        for (String word : words) {
            if (word.length() <= maxWordLength) {
                result.add(word);
            } else {
                String[] parts = new String[word.length()];
                for (int i = 0; i < parts.length; i++) {
                    parts[i] = word.substring(i, i + 1);
                }

                int combinations = (int) Math.pow(2, parts.length - 1);
                for (int i = 0; i < combinations; i++) {
                    StringBuilder current = new StringBuilder(parts[0]);
                    for (int j = 0; j < parts.length - 1; j++) {
                        if ((i & (1 << j)) > 0) {
                            current.append(" ").append(parts[j + 1]);
                        } else {
                            current.append(parts[j + 1]);
                        }
                    }

                    if (current.length() <= maxWordLength) {
                        result.add(current.toString());
                    }
                }
            }
        }

        return result;
    }
}
