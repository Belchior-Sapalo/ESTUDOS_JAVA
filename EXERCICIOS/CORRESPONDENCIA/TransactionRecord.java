public class TransactionRecord {
    private int account;
    private double amount;

    public TransactionRecord(){
        this(0, 0);
    }

    public TransactionRecord(int account, double amount){
        this.account = account;
        this.amount = amount;
    }

    public void setAccount(int account){
        this.account = account;
    }
    public int getAccount(){
        return account;
    }

    public void setamount(double amount){
        this.amount = amount;
    }

    public double getamount(){
        return amount;
    }

    public void combine(TransactionRecord trans){
        this.amount += trans.getamount();
    }

    @Override
    public String toString(){
        return String.format("%d %.2f%n", this.account, this.amount);
    }
}
