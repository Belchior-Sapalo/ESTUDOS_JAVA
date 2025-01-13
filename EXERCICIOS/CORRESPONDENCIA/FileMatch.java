
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class FileMatch {
    public static Scanner inOldMaster;
    public static Formatter outOldMaster;
    public static Scanner inTransaction;
    public static Formatter outTransaction;
    public static Formatter outNewMaster;
    public static Formatter outLogFile;

    public static void main(String[] args) {
        foundMatchAndUpdateNewMastFile();
        closeAll();
    }

    // public static void openOldMasterForOutput(){
    // try {
    // outOldMaster = new Formatter("oldmast.txt");
    // } catch (Exception e) {
    // System.out.printf("Error: %s", e.getMessage());
    // }
    // }

    // public static void addOldMasterRecord(){
    // Scanner input = new Scanner(System.in);
    // System.out.printf("%s%n%s%n? ",
    // "Enter account number, first name, last name and balance.",
    // "Enter end-of-file indicator to end input."
    // );

    // while ((input.hasNext())) {
    // try {
    // outOldMaster.format("%d %s %s %.2f%n", input.nextInt(), input.next(),
    // input.next(), input.nextDouble());
    // } catch (FormatterClosedException FormatterClosedException) {
    // System.err.println("Error writing to file. Terminating");
    // break;
    // }catch(NoSuchElementException noSuchElementException){
    // System.err.println("Invalid input, try again.");
    // input.nextLine();
    // }
    // System.out.print("? ");
    // }
    // outOldMaster.close();
    // }

    // public static void addTransFileRecord(){
    // Scanner input = new Scanner(System.in);
    // System.out.printf("%s%n%s%n? ",
    // "Enter account number, amount",
    // "Enter end-of-file indicator to end input."
    // );

    // while ((input.hasNext())) {
    // try {
    // outTransaction.format("%d %.2f%n", input.nextInt(), input.nextDouble());
    // } catch (FormatterClosedException FormatterClosedException) {
    // System.err.println("Error writing to file. Terminating");
    // break;
    // }catch(NoSuchElementException noSuchElementException){
    // System.err.println("Invalid input, try again.");
    // input.nextLine();
    // }
    // System.out.print("? ");
    // }
    // outTransaction.close();
    // }

    public static void openOldMasterForInput() {
        try {
            inOldMaster = new Scanner(Paths.get("oldmast.txt"));
        } catch (IOException e) {
            System.out.printf("Error: %s", e.getMessage());
        }
    }

    public static void openTransactionForInput() {
        try {
            inTransaction = new Scanner(Paths.get("trans.txt"));
        } catch (IOException e) {
            System.out.printf("Error: %s", e.getMessage());
        }
    }

    public static void foundMatchAndUpdateNewMastFile() {
        List<Account> accountList = readOldMasterFileAndGetAccountObjectList();
        List<TransactionRecord> transactionList = readTransactionFileAndGetTransactionObject();
        transactionList = compactTransFile(transactionList);
        openNewMasterForOutput();
        openLogFileForOutput();

        // Look for match betwen oldMast and transFile
        for (Account ac : accountList) {
            for (TransactionRecord trans : transactionList) {
                if (existsInBothFiles(ac, trans)) {
                    ac.combine(trans);
                    outNewMaster.format("%d %s %s %.2f%n", ac.getAccount(), ac.getFirstName(),
                            ac.getLastName(),
                            ac.getBalance());
                }
            }
        }

        // Look for records that exists only in oldMastFile
        for (Account ac : accountList) {
            if (existsOnlyInOldMastFile(ac.getAccount(), transactionList)) {
                outNewMaster.format("%d %s %s %.2f%n", ac.getAccount(), ac.getFirstName(),
                        ac.getLastName(),
                        ac.getBalance());
            }
        }

        // Look for records that exists only in transFile
        for (TransactionRecord trans : transactionList) {
            if (existsOnlyInTransFile(trans.getAccount(), accountList)) {
                outLogFile.format("Unmatched transaction record for account number: %d%n",
                        trans.getAccount());
            }
        }

    }

    private static List<TransactionRecord> compactTransFile(List<TransactionRecord> transactionList) {
        List<TransactionRecord> compactedList = new ArrayList<>();

        for (int i = 0; i < transactionList.size(); i++) {
            TransactionRecord combinedTrans = combineTransactions(transactionList.get(i), i + 1, transactionList);
            if (i == 0) {
                compactedList.add(combinedTrans);
            } else {
                if (compactedList.get(compactedList.size() - 1).getAccount() == combinedTrans.getAccount()) {
                    continue;
                } else {
                    compactedList.add(combinedTrans);
                }
            }
        }
        return compactedList;

    }

    private static TransactionRecord combineTransactions(TransactionRecord currrent, int start,
            List<TransactionRecord> transList) {
        for (int i = start; i < transList.size(); i++) {
            if (currrent.getAccount() == transList.get(i).getAccount()) {
                currrent.combine(transList.get(i));
            }
        }
        return currrent;
    }

    public static void openTransfileForOutput() {
        try {
            outTransaction = new Formatter("trans.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void openNewMasterForOutput() {
        try {
            outNewMaster = new Formatter("newmast.txt");
        } catch (IOException e) {
            System.out.printf("Error: %s", e.getMessage());
        }
        System.out.println("NewMasterFile opened for output");

    }

    public static void openLogFileForOutput() {
        try {
            outLogFile = new Formatter("log.txt");
        } catch (IOException e) {
            System.out.printf("Error: %s", e.getMessage());
        }
        System.out.println("TransactionFile opened for output");
    }

    public static List<Account> readOldMasterFileAndGetAccountObjectList() {
        openOldMasterForInput();
        List<Account> accountList = new ArrayList<>();
        while (inOldMaster.hasNext()) {
            try {

                Account account = new Account(
                        inOldMaster.nextInt(),
                        inOldMaster.next(),
                        inOldMaster.next(),
                        inOldMaster.nextDouble());
                accountList.add(account);
            } catch (NoSuchElementException noSuchElementException) {
                System.err.println("File improperly formed. Terminating.");
                break;
            } catch (IllegalStateException IllegalStateException) {
                System.err.println("Error reading from file. Terminating.");
                break;
            }
        }
        System.out.println("OldMarter records recovered succesfuly");
        return accountList;
    }

    public static List<TransactionRecord> readTransactionFileAndGetTransactionObject() {
        openTransactionForInput();
        List<TransactionRecord> transactionList = new ArrayList<>();
        while (inTransaction.hasNext()) {
            try {
                TransactionRecord transaction = new TransactionRecord(
                        inTransaction.nextInt(),
                        inTransaction.nextDouble());
                transactionList.add(transaction);
            } catch (NoSuchElementException noSuchElementException) {
                System.err.println("File improperly formed. Terminating.");
                break;
            } catch (IllegalStateException IllegalStateException) {
                System.err.println("Error reading from file. Terminating.");
                break;
            }
        }
        System.out.println("TransactionFile records recovered succesfuly");
        return transactionList;
    }

    public static void addNewMasterRecord() {
        Scanner input = new Scanner(System.in);
        System.out.printf("%s%n%s%n? ",
                "Enter account number, first name, last name and balance.",
                "Enter end-of-file indicator to end input.");

        while ((input.hasNext())) {
            try {
                outNewMaster.format("%d %s %s %.2f%n", input.nextInt(), input.next(), input.next(), input.nextDouble());
            } catch (FormatterClosedException FormatterClosedException) {
                System.err.println("Error writing to file. Terminating");
                break;
            } catch (NoSuchElementException noSuchElementException) {
                System.err.println("Invalid input, try again.");
                input.nextLine();
            }
            System.out.print("? ");
        }
    }

    private static boolean existsInBothFiles(Account ac, TransactionRecord trans) {
        return ac.getAccount() == trans.getAccount();
    }

    private static boolean existsOnlyInOldMastFile(int num, List<TransactionRecord> transList) {
        for (TransactionRecord transactionRecord : transList) {
            if (transactionRecord.getAccount() == num)
                return false;
        }
        return true;
    }

    private static boolean existsOnlyInTransFile(int num, List<Account> acList) {
        for (Account ac : acList) {
            if (ac.getAccount() == num)
                return false;
        }
        return true;
    }

    public static void closeAll() {
        if (outLogFile != null)
            outLogFile.close();
        if (outOldMaster != null)
            outOldMaster.close();
        if (inTransaction != null)
            inTransaction.close();
        if (outTransaction != null)
            outTransaction.close();
        if (outNewMaster != null)
            outNewMaster.close();
    }
}
