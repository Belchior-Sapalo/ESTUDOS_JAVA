package com.estudosjava.javacomoprogramar.javacore.capitulo10_Polimorfismo_Interface.Apolimorfismo.classes;

public class Invoice implements Payable{
    private final String partNumber;
    private final String partDescription;
    private int quantity;
    private double pricePerItem;

    public Invoice(String partNumber, int quantity, String partDescription, double pricePerItem) {
        if(quantity < 0)
            throw new IllegalArgumentException("Quantity must be a positive number");
        if(pricePerItem < 0)
            throw new IllegalArgumentException("Price per item must be a positive number");
        this.partNumber = partNumber;
        this.quantity = quantity;
        this.partDescription = partDescription;
        this.pricePerItem = pricePerItem;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if(quantity < 0)
            throw new IllegalArgumentException("Quantity must be a positive number");
        this.quantity = quantity;
    }

    public String getPartDescription() {
        return partDescription;
    }

    public double getPricePerItem() {
        return pricePerItem;
    }

    public void setPricePerItem(double pricePerItem) {
        this.pricePerItem = pricePerItem;
    }

    @Override
    public String toString(){
        return String.format(
                "%s: %n%s: %s (%s) %n%s: %d %n%s: $%,.2f",
                "invoice", "part number", getPartNumber(), getPartDescription(),
                "quantity", getQuantity(), "price per item", getPricePerItem()
        );
    }

    @Override
    //Implementando o metodo da interface payable
    public double getPaymentAmount() {
        return getQuantity() * getPricePerItem();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(obj == this) return true;
        if(this.getClass() != obj.getClass()) return false;
        Invoice other = (Invoice) obj;
        return getPartNumber() != null && getPartNumber().equals(other.partNumber);
    }

    @Override
    public int hashCode() {
        return getPartNumber() != null ? getPartNumber().hashCode() : 0;
    }
}
