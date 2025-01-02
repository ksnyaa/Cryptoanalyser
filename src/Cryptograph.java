import java.io.*;
import java.util.List;

public class Cryptograph {
    private static final String CHARSET_NAME = "UTF-8";
    private List<Character> cryptoAlphabet;

    public Cryptograph(List<Character> cryptoAlphabet) {
        this.cryptoAlphabet = cryptoAlphabet;
    }

    public void toEncrypt(String originalFile, int key, String encryptedFile) throws IOException{
        InputStream fileInputStream = new FileInputStream("resources/" + originalFile);
        OutputStream fileOutputStream = new FileOutputStream("resources/" + encryptedFile);

        try (InputStreamReader inputStream = new InputStreamReader(fileInputStream, CHARSET_NAME);
             OutputStreamWriter outputStream = new OutputStreamWriter(fileOutputStream, CHARSET_NAME)) {
            int inputSymbol;
            int outputSymbol;
            do {
                inputSymbol = inputStream.read();
                outputSymbol = replaceSymbol(inputSymbol, key, cryptoAlphabet);
                outputStream.write(outputSymbol);
            } while (inputSymbol != -1);
            outputStream.flush();
        }
    }

    public void toDecrypt(String encryptedFile, int key, String decryptedFile) throws IOException {
        toEncrypt(encryptedFile, -(key), decryptedFile);
    }

    private static int replaceSymbol(int symbol, int key, List<Character> alphabet) {
        char charSymbol = (char) symbol;
        if (!alphabet.contains(charSymbol)) {
            return symbol;
        }

        int replacedIndex = (alphabet.indexOf(charSymbol) + key) % alphabet.size();
        if (replacedIndex < 0){
            replacedIndex = replacedIndex + alphabet.size();
        }
        return alphabet.get(replacedIndex);
    }
}
