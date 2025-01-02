import java.util.ArrayList;
import java.util.List;

public class Alphabet {
    private final String RUSSIAN_ALPHABET = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
    private final String ENGLISH_ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    private final String SYMBOL_ALPHABET = ".,-:;!";

    public Alphabet() {
    }

    public List<Character> createCryptoAlphabet() {
        List<Character> cryptoAlphabet = new ArrayList<>();
        String dualRegisterRussianAlphabet = RUSSIAN_ALPHABET.toUpperCase() + RUSSIAN_ALPHABET;
        String dualRegisterEnglishAlphabet = ENGLISH_ALPHABET.toUpperCase() + ENGLISH_ALPHABET;

        addToCryptoAlphabet(dualRegisterRussianAlphabet, cryptoAlphabet);
        addToCryptoAlphabet(dualRegisterEnglishAlphabet, cryptoAlphabet);
        addToCryptoAlphabet(SYMBOL_ALPHABET, cryptoAlphabet);
        return cryptoAlphabet;
    }

    private static void addToCryptoAlphabet(String alphabet, List<Character> cryptoAlphabet) {
        char[] symbols = alphabet.toCharArray();
        for (char symbol : symbols) {
            cryptoAlphabet.add(symbol);
        }
    }
}
