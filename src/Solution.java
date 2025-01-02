import java.io.*;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileCreator.createFiles("encrypted.txt");
        FileCreator.createFiles("decrypted.txt");

        Alphabet alphabet = new Alphabet();
        List<Character> cryptoAlphabet = alphabet.createCryptoAlphabet();

        Cryptograph cryptograph = new Cryptograph(cryptoAlphabet);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Выберите опцию: \n" +
                "1. Зашифровать текст data.txt.\n" +
                "2. Расшифровать текст data.txt.\n" +
                "3. Осуществить попытку взлома шифра.\n" +
                "4. Выйти.\n\n" +
                "Ваша опция: ");

        int key;
        do {
            int value = scanner.nextInt();
            if (value == 1) {
                System.out.print("Введите ключ шифра (любое целое число): "); //любое, но смысла тут немного, т.к шифр в любом случае будет в диапазоне от 1 до 124 (длина алфавита)
                key = scanner.nextInt();
                cryptograph.toEncrypt("data.txt", key, "encrypted.txt");
                System.out.println("Файл успешно зашифрован.");
            } else if (value == 2) {
                System.out.print("Введите ключ для расшифровки: ");
                key = scanner.nextInt();
                cryptograph.toDecrypt("encrypted.txt", key, "decrypted.txt");
                System.out.println("Файл успешно расшифрован.");
            } else if (value == 3) {
                BruteForce bruteForce = new BruteForce();
                System.out.println("Предполагаемый ключ шифра: " + bruteForce.keyFinder("encrypted.txt"));
            } else if (value == 4) {
                System.out.println("До свидания!");
                return;
            } else {
                System.out.print("Неверная опция. Попробуйте еще раз.");
            }
            System.out.print("\n" + "Ваша опция: ");
        } while (true);
    }
}

