package com.inieva.appInvoice.model;

import com.inieva.appInvoice.model.Customer;
import com.inieva.appInvoice.model.ItemInvoice;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Invoice {
    private int folio;
    private String description;
    private Date date;
    private Customer customer;
    private ItemInvoice[] items;
    private int indexItems;
    public static final int MAX_ITEMS =12;
    public static  int lastFolio;


    public Invoice(String description, Customer customer) {
        this.description = description;
        this.customer = customer;
        this.items = new ItemInvoice[MAX_ITEMS];
        this.folio = ++lastFolio;
        this.date= new Date();
    }

    public int getFolio() {
        return folio;
    }

    public void setFolio(int folio) {
        this.folio = folio;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ItemInvoice[] getItems() {
        return items;
    }


    public void addItemInvoice(ItemInvoice items){
       if( indexItems < MAX_ITEMS) {
           this.items[indexItems++] = items;
       }
    }

    public float calculateTotal(){
        float total= 0.0f;
        for(int i= 0;i<indexItems;i++){
            total += this.items[i].calculateImport();
        }
        return total;
    }
    public String gerateDetail(){
        StringBuilder sb = new StringBuilder("FACTURA N°: ");
        sb.append(folio)
                .append("\nCLIENTE: ")
                .append(this.customer.getName())
                .append("\t CUIT: ")
                .append(customer.getCuit())
                .append("\nDESCRIPCIÓN: ")
                .append(this.description)
                .append("\n")
                .append("\n");

        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yy");
        sb.append("Fecha Emisión: ")
                .append(df.format(this.date))
                .append("\n")
                .append("\n#\t\tNombre\t\tS\t\tCant.\t\tTotal\n");

        for(int i=0;i<indexItems;i++){
            sb.append(this.items[i].toString())
                    .append("\n");
        }
        sb.append("\nGran Total: ")
                .append(calculateTotal());
        return sb.toString();
    }

    @Override
    public String toString() {
        return gerateDetail();
    }
}
