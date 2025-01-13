import java.io.IOException;
import java.nio.file.Paths;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class EditTextFile {
    private static Formatter output;
    private static Scanner input;

    public static void main(String[] args) {
        copyRegisters();
        addRecords();
    }

    public static void copyRegisters() {
        try {
            output = new Formatter("temp.txt");
            input = new Scanner(Paths.get("clients.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (input.hasNext()) {
            output.format("%d %s %s %.2f%n", input.nextInt(), input.next(), input.next(), input.nextDouble());
        }
        close();
    }

    public static void addRecords(){
        try {
            output = new Formatter("clients.txt");
            input = new Scanner(Paths.get("temp.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (input.hasNext()) {
            output.format("%d %s %s %.2f%n", input.nextInt(), input.next(), input.next(), input.nextDouble());
        }
        Scanner newIn = new Scanner(System.in);
        System.out.printf("%s%n%s%n? ", 
            "Enter account number, first name, last name and balance.",
            "Enter end-of-file indicator to end input."
        );
         while ((newIn.hasNext())) {
            try {
                output.format("%d %s %s %.2f%n", newIn.nextInt(), newIn.next(), newIn.next(), newIn.nextDouble());
            } catch (FormatterClosedException FormatterClosedException) {
                System.err.println("Error writing to file. Terminating");
                break;
            }catch(NoSuchElementException noSuchElementException){
                System.err.println("Invalid input, try again.");
                newIn.nextLine();
            }
            System.out.print("? ");
        }
        newIn.close();
        close();
    }

    public static void close(){
        if (output != null)
            output.close();
        if (input != null)
            input.close();
    }
}
