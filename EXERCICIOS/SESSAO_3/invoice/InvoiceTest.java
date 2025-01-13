package invoice;

public class InvoiceTest {
    public static void main(String[] args) {
        Invoice invoice = new Invoice("0b588a","Compras de computadores", 2, -12);

        System.out.println(invoice.getInvoiveAmount());
    }
}
