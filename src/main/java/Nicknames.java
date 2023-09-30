import java.util.concurrent.atomic.AtomicInteger;

public class Nicknames {
    public static AtomicInteger nameLength3 = new AtomicInteger();
    public static AtomicInteger nameLength4 = new AtomicInteger();
    public static AtomicInteger nameLength5 = new AtomicInteger();

    public static boolean palindrome(String text) {
        return text.equals(new StringBuilder(text).reverse().toString());
    }

    public static boolean identicalChar(String text) {
        for (int i = 1; i < text.length(); i++) {
            if (text.charAt(i) != text.charAt(i - 1))
                return false;
        }
        return true;
    }

    public static boolean ascending(String text) {
        for (int i = 1; i < text.length(); i++) {
            if (text.charAt(i) < text.charAt(i - 1))
                return false;
        }
        return true;
    }

    public static void counterName(int lengthText) {
        if (lengthText == 3) {
            nameLength3.getAndIncrement();
        } else if (lengthText == 4) {
            nameLength4.getAndIncrement();
        } else {
            nameLength5.getAndIncrement();
        }
    }
}