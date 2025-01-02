import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class BruteForce {
    private final String VERIFICATION_VOCABULARY = "Как, что, чтобы, также, когда, будто, однако, словно, без, между, затем, до, для, около, об, на, по, за, про, он, она, его, ее";

    public BruteForce() {
    }

    public int keyFinder(String encryptedFile) throws IOException {
        String[] splitVocabulary = VERIFICATION_VOCABULARY.split(", ");
        Alphabet alphabet = new Alphabet();
        List<Character> cryptoAlphabet = alphabet.createCryptoAlphabet();
        Cryptograph cryptograph = new Cryptograph(cryptoAlphabet);
        for (int estimatedKey = 0; estimatedKey < cryptoAlphabet.size(); estimatedKey++) {
            int matchCounter = 0;
            cryptograph.toDecrypt(encryptedFile, estimatedKey, "decrypted.txt");
            String decrypted = Files.readString(Path.of("resources/decrypted.txt"));
            for (int j = 0; j < splitVocabulary.length; j++) {
                if (decrypted.contains(splitVocabulary[j])){
                    matchCounter++;
                }
            }
            if (matchCounter >= (splitVocabulary.length/2)) {
                return estimatedKey;
            }
        }
        return 0;
    }
}
