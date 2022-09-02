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
public class office_end extends cust_end{
    char v_ch;
    String date,custid,name,address,compl;
    Scanner soe = new Scanner(System.in);
   // public office_end(cust_end obj)
   // {
   //     date = obj.da;
   //     custid = obj.cust_id;
   //     name = obj.n;
   //     address = obj.add;
   //     compl = obj.comp;
   // }
    public void view_comp()
    {
        //System.out.println("S.no. \tDate \tcustomer ID \tName \tCustomer Issue");
        //System.out.println(1+"\t"+da+"\t"+cust_id+"\t"+n+"\t"+comp);
        System.out.println("\nDate: "+da);
        System.out.println("Customer ID: "+cust_id);
        System.out.println("Name: "+n);
        System.out.println("Address: "+add);
        System.out.println("customer Issue: \n"+comp);
        
        System.out.println("Complaint verified?(y/n): ");
        v_ch = soe.next().charAt(0);
        
        if(v_ch == 'y')
        {
            System.out.println("Complaint closed!");
        }
        else
        {
            System.out.println("Complaint saved to pending complaints");
        }
    }   
}
