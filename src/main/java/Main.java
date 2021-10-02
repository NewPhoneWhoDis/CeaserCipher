import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        CaesarCipher caesarCipher = new CaesarCipher();
        Scanner userInput = new Scanner(System.in);

        System.out.println("Enter a message without special symbols like @, &, etc.");
        System.out.println("After that enter an offset number!");

        String result = caesarCipher.cipher(userInput.nextLine(), userInput.nextInt());

        System.out.println("The ciphered message is : " + result);

    }
}
