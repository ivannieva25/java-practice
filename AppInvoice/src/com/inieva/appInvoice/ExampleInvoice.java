package com.inieva.appInvoice;

import com.inieva.appInvoice.model.*;
import java.util.Scanner;

public class ExampleInvoice {
    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.setCuit("66666-6");
        customer.setName("Ivan");

        Scanner sc= new Scanner(System.in);
        System.out.print("Ingrese una descripción de la factura: ");
        Invoice invoice = new Invoice(sc.nextLine(),customer);

        Product product;
        System.out.println();

        for (int i =0; i<3; i++){
            product = new Product();
            System.out.print("Ingrese el tipo de prod. n°: " + product.getCode() + ": ");
            product.setName(sc.nextLine());

            System.out.print("Ingrese el precio del producto :  ");
            product.setPrice(sc.nextFloat());

            System.out.print("Ingrese la cantidad del producto :");
            invoice.addItemInvoice(new ItemInvoice(sc.nextInt(),product));
            System.out.println();
            sc.nextLine();
        }
        System.out.println(invoice);
    }
}
