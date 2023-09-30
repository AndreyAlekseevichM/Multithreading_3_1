import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        String[] texts = new String[100_000];
        for (int i = 0; i < texts.length; i++) {
            texts[i] = generateText("abc", 3 + random.nextInt(3));
        }

        Thread palindromeThread = new Thread(() ->
        {
            for (String text : texts) {
                if (Nicknames.palindrome(text) && Nicknames.identicalChar(text)) {
                    Nicknames.counterName(texts.length);
                }
            }
        });
        palindromeThread.start();

        Thread identicalCharThread = new Thread(() -> {
            for (String text : texts) {
                if (!Nicknames.identicalChar(text) && Nicknames.ascending(text)) {
                    Nicknames.counterName(text.length());
                }
            }
        });
        identicalCharThread.start();

        Thread ascendingThread = new Thread(() -> {
            for (String text : texts) {
                if (Nicknames.identicalChar(text) && Nicknames.ascending(text)) {
                    Nicknames.counterName(texts.length);
                }
            }
        });
        ascendingThread.start();

        identicalCharThread.join();
        ascendingThread.join();
        palindromeThread.join();

        System.out.println("Красивых слов с длиной 3: " + Nicknames.nameLength3 + " шт.");
        System.out.println("Красивых слов с длиной 4: " + Nicknames.nameLength4 + " шт.");
        System.out.println("Красивых слов с длиной 5: " + Nicknames.nameLength5 + " шт.");
    }

    public static String generateText(String letters, int length) {
        Random random = new Random();
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < length; i++) {
            text.append(letters.charAt(random.nextInt(letters.length())));
        }
        return text.toString();
    }
}