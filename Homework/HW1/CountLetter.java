import java.util.Scanner;

public class CountLetter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter a sentence, ending with a period '.':");
        String inputString = scanner.nextLine();


        int count = 0;
        int aCount = 0;
        int eCount = 0;
        int oCount = 0;
        for (int i = 0; i < inputString.length(); i++) {
            char letter = inputString.charAt(i);
            if (letter == 'a') {
                aCount++;
            } else if (letter == 'e') {
                eCount++;
            } else if (letter == 'o') {
                oCount++;
            }
            count++;
        }
        double aPercent = (aCount * 100.0) / count;
        double ePercent = (eCount * 100.0) / count;
        double oPercent = (oCount * 100.0) / count;
        System.out.println("There are " + count + " letters.");
        System.out.println("a: " + aCount + ", " + aPercent + "%");
        System.out.println("e: " + eCount + ", " + ePercent + "%");
        System.out.println("o: " + oCount + ", " + oPercent + "%");
        
        scanner.close();
    }
}