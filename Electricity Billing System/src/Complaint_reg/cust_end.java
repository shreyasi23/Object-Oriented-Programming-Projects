/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Complaint_reg;
import java.util.Scanner;
/**
 *
 * @author SHREYASI
 */
public class cust_end {
    String cust_id, n, comp, da,add;
    Scanner sce = new Scanner(System.in);
    public void get_cust_comp()
    {
        System.out.println("Enter date(dd/mm/yyyy): ");
        da = sce.next();
        System.out.println("Enter customer ID: ");
        cust_id = sce.next();
        System.out.println("Enter Name: ");
        n = "";
        n+= sce.nextLine();
        n = sce.nextLine();
        System.out.println("Enter address: ");
        add = "";
        add+= sce.next();
        add = sce.next();
        System.out.println("Please describe your problem here: \n");
        comp ="";
        comp += sce.nextLine();
        comp = sce.nextLine();
        System.out.println("\nYour complaint is registered");
    }
}
