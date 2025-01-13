package serializacao;

import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadSequentialFile {
    private static ObjectInputStream input;

    public static void main(String[] args) {
        openFile();
        readRecords();
        close();
    }

    public static void openFile(){
        try{
            input = new ObjectInputStream(Files.newInputStream(Paths.get("clients.ser")));
        }catch (IOException e) {
            System.err.println("Error opening file. Terminating.");
            System.exit(1);
        }
    }

    public static void readRecords(){
        System.out.printf("%-10s%-12s%-12s%10s%n", "Account", "First Name", "Last Name", "Balance");
        while (true) {
            try {
                Account record = (Account) input.readObject();
                System.out.printf("%-10d%-12s%-12s%10.2f%n", 
                record.getAccount(), record.getFirstName(),
                record.getLastName(), record.getBalance());
            } catch (EOFException e) {
                System.out.println("No more records");
                break;
            }catch(ClassNotFoundException e){
                System.err.println("Invalid object type. Terminating.");
            }catch(IOException e){
                System.err.println("Error reading from file. Terminating.");
            }
        }
    }

     public static void close(){
        try{
            if (input != null)
                input.close();
        }catch(IOException e){
            System.err.println("Error closing file. Terminating.");
        }
    }
}
