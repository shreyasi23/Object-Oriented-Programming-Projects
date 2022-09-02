
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login_module;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.*;
import java.lang.Exception;
import java.io.IOException;
import Complaint_reg.*;

/**
 *
 * @author SHREYASI
 */
//class login
class Login
{
    String username, password, X, Y, un, p; //data members
    int attempt = 3;
    Scanner scan = new Scanner(System.in);
    //default constructor
    Login()
    {
        username = "Customer";
        password = "Customer@01"; 
    }
    
    //parameterized constructor
    Login(String X, String Y)
    {
        username = X;
        password = Y;
    }
    public void sign_in()
    {
        while(attempt != 0)
        {
            System.out.println("\nEnter Username: ");
            username = scan.next();
            System.out.println("Enter Password: ");
            password = scan.next();
            
            if((("Shreya".compareTo(username)==0)&&("Shreya@123".compareTo(password)==0)) || (("Admin".compareTo(username)== 0)&&("Admin@100".compareTo(password)==0)))
            {
                System.out.println("Login Successfull!");
                break;
            }
            else
            {
                System.out.println("Incorrect username or password");
            }
            attempt--;
            if(attempt == 1)
            {
                System.out.println("Access denied!");
                System.exit(0);
            }
        }
    }
}

//class for 0 units exception
class Zero_units_exception extends Exception
{
    float fix_c, other_c, tb;
    //parameterized constructor
    Zero_units_exception(float x, float y)
    {
        fix_c = x;
        other_c = y;
        tb = fix_c + other_c;
    }
}
class calulate_bill
{
    //data members
    int meter_no, units; 
    float puc, total_bill, fix_cost, oc, tax; 
    String name, id;
    Scanner cb = new Scanner(System.in); 
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    Date da= new Date();
    //member functions 
    public void get_cust_details()       //function for collecting consumer details
    {
        System.out.println("\n======* Calculate Bill *======\n");
        System.out.println("Enter Customer ID: ");
        id = cb.next();
        System.out.println("Enter Name: ");
        name ="";
        name = cb.nextLine();
        name+=cb.nextLine();
        System.out.println("Enter Meter number: ");
        meter_no = cb.nextInt();
        System.out.println("Enter number of units consumed: ");
        units = cb.nextInt();
    }
    
    public void cal_bill()      //function for calculating bill
    {
        fix_cost = (float)350.00; 
        oc = (float)101.50;
        
        try
        {
            if(units == 0)
            {
                throw new Zero_units_exception(fix_cost,oc);
            }
            else
            {
                if(units >= 1 && units <= 100)
                {
                    puc = (float) 3.46;
                }
                else if(units >= 101 && units <= 300)
                {
                    puc =  (float)7.43;
                }
                else if(units >= 301 && units <= 500)
                {
                    puc = (float)10.32;
                }
                else if(units >= 501 && units <= 1000)
                {
                    puc = (float)11.71;
                }
                else if(units > 1000)
                {
                    puc = (float)12.71;
                }
                tax = ((puc * units) + fix_cost + oc )*((float)0.16);
                total_bill = (puc * units)+ fix_cost+ oc + tax;
            }
        }
        catch(Zero_units_exception zue)
        {
             total_bill = zue.tb;
             tax = 0;
        } 
    }
    
    public void Display_receipt()       //function for printing bill 
    {
        
        System.out.println("\n======* Bill *======\n");
        System.out.println("Date: "+(formatter.format(da)));
        System.out.println("Name: "+name);
        System.out.println("Customer ID: "+id);
        System.out.println("Meter Number: "+meter_no);
        System.out.println("Units Consumed: "+units);
        System.out.println("Fixed Charges: "+fix_cost);
        System.out.println("Other Charges: "+oc);
        System.out.println("Unit Amount: "+(puc * units));
        System.out.println("Tax (16.00%): "+tax);
        System.out.println("Total Amount: "+total_bill);
    }
}

class pay_bill extends calulate_bill
{ 
    int cc = 1, c_ac_no, c_card, eb_ac_no, c_CardCode, c_cvd, code,Meter_no;
    long c_ph_no;
    float amount;
    String c_ac_name, eb_ac_name;
    char pp;
    
    pay_bill()      //constructor
    {
        eb_ac_no = 110123;
        eb_ac_name = "EOB";
    }
    public void get_pay()
    {
        System.out.println("\n======* Pay Bill *======\n");
        System.out.println("Enter Customer ID: ");
        id = cb.next();
        System.out.println("Enter Name: ");
        name = "";
        name = cb.nextLine();
        name += cb.nextLine();
        System.out.println("Enter meter number: ");
        Meter_no = cb.nextInt();
        
        while(cc > 0)
        {
            System.out.println("\nChoose a payment option: \n[1] Net Banking \n[2] Card payment \n[3] paytm");
            System.out.println("Enter choice: ");
            cc = cb.nextInt();
        
            switch(cc)
            {
                case 1:
                {
                    System.out.println("\n****** SBI Bank ******\n");
                    System.out.println("Enter your account number: ");
                    c_ac_no = cb.nextInt();
                    System.out.println("Enter your account name: ");
                    c_ac_name = cb.next();
                    System.out.println("Enter amount: ");
                    amount = cb.nextFloat();
                    pay(c_ac_no, c_ac_name,eb_ac_no, eb_ac_name, amount);
                    cc = 0;
                    break; 
                }
                case 2:
                {
                    System.out.println("\n****** Card Payment ******\n");
                    System.out.println("Enter your card number: ");
                    c_card = cb.nextInt();
                    System.out.println("Enter your account number: ");
                    c_ac_no = cb.nextInt();
                    System.out.println("Enter name on your card: ");
                    c_ac_name = cb.next();
                    System.out.println("Enter FSC code: ");
                    c_CardCode = cb.nextInt();
                    System.out.println("Enter Card validity: ");
                    c_cvd = cb.nextInt();
                    System.out.println("Enter amount: ");
                    amount = cb.nextFloat();
                    pay(c_CardCode, c_ac_no, c_cvd, c_card, c_ac_name, eb_ac_no, eb_ac_name, amount);
                    cc = 0;
                    break;
                }
                case 3:
                {
                    System.out.println("\n****** Paytm ******\n");
                    System.out.println("Enter your mobile number: ");
                    c_ph_no = cb.nextLong();
                    System.out.println("Enter your account number: ");
                    c_ac_no = cb.nextInt();
                    System.out.println("Enter your account name: ");
                    c_ac_name = cb.next();
                    System.out.println("Enter amount: ");
                    amount = cb.nextFloat();
                    pay(c_ph_no, c_ac_name, eb_ac_no,amount);
                    cc = 0;
                    break;
                }
                default:
                {
                    System.out.println("Invalid Choice");
                    get_pay();
                }
            }
        }  
    }
    //payment through net banking 
    public void pay(int c_ac_no, String c_ac_name, int eb_ac_no, String eb_ac_name,float amount)
    {
        System.out.println("Please confirm the following details");
        System.out.println("Account Name: "+c_ac_name);
        System.out.println("Account number: "+c_ac_no);
        System.out.println("Beneficiary Name: "+eb_ac_name);
        System.out.println("Beneficiary Account number: "+eb_ac_no);
        System.out.println("Amount: "+amount);
        System.out.println("Do you want to proceed for paymet?(y(yes)/n(no)): ");
        pp = cb.next().charAt(0);
        
        if(pp == 'y')
        {
            Display_receipt(); 
        }
        else
        {
           System.out.println("Transcation cancelled");
        }
    }
    //payment through card 
    public void pay(int c_CardCode,int c_ac_no, int c_cvd,int c_card, String c_ac_name, int eb_ac_no, String eb_ac_name,float amount)
    {
        System.out.println("Please confirm the following details");
        System.out.println("Name on card: "+c_ac_name);
        System.out.println("Account number: "+c_ac_no);
        System.out.println("Card number: "+c_card);
        System.out.println("FSC code: "+c_CardCode);
        System.out.println("Card validity till: "+c_cvd);
        System.out.println("Beneficiary Name: "+eb_ac_name);
        System.out.println("Beneficiary Account number: "+eb_ac_no);
        System.out.println("Amount: "+amount);
        System.out.println("Do you want to proceed for paymet?(y(yes)/n(no)): ");
        pp = cb.next().charAt(0);
        
        if(pp == 'y')
        {
            Display_receipt(); 
        }
        else
        {
           System.out.println("Transcation cancelled");
        }
    }
    //payment through paytm 
    public void pay(long c_ph_no, String c_ac_name, int eb_ac_no,float amount)
    {
        System.out.println("Amount: "+amount);
        System.out.println("Enter the code: ");
        code = cb.nextInt();
        
        if(code == 102034)
        {
            Display_receipt(); 
        }
        else
        {
            System.out.println("Transcation failed");
        }
    }
    
    public void Display_receipt() 
    {
        System.out.println("\nTransaction Successful");
        System.out.println("\n==== Payment Receipt ====");
        System.out.println("Debit Account Details: ");
        System.out.println("Account number: "+c_ac_no);
        System.out.println("Amount: "+amount);
        System.out.println("Credit Account details: ");
        System.out.println("Account number: "+eb_ac_no);
        System.out.println("Amount: "+amount);
        //recording details of payment
        redord_payment_details();
    }
    
    public void redord_payment_details()
    {
        // creating new file, object of new file
            File file = new File("./cust_payment_record.txt");
            try 
            {
                file.createNewFile();
                //if(file.createNewFile())
               // {
                    FileWriter new_writer = new FileWriter(file,true); 
                    BufferedWriter b = new BufferedWriter(new_writer);
                    PrintWriter p = new PrintWriter(b);
                        p.println((formatter.format(da))+","+id+","+name+","+Meter_no+","+amount);
                        p.close();
                        //new_writer.write(Address);
                        //new_writer.write(Area_code);
                        //new_writer.write(meter_no);
                        //new_writer.write(meter_type);
                        //new_writer.write(s_deposite);
                        //new_writer.write(date_of_inst);
                        System.out.println("Details recorded");
                //}
               // else
               // {
                   // System.out.println("File already exist");
                //}
            }    
            catch (IOException e) 
            {
                e.getStackTrace();
            }
    }
}

//display deposite details
class Display_deposit_details extends pay_bill
{
    //Scanner sobj_ddd = new Scanner(System.in);
    public void cust_deposite()
    {
        char[] array = new char[2000];
        try
        {
            FileReader fr = new FileReader("./cust_payment_record.txt");
            fr.read(array);
            System.out.println(array);
            fr.close();
        }
        catch(IOException e)
        {
            e.getStackTrace();
        }
    }
}
// record new customer details
class New_cust
{
    //data members
    String Name, Address, date_of_inst, meter_type, co, cust_id;
    int meter_no,Area_code, s_deposite;
    //boolean created;
    
    //object of scanner class 
    Scanner take = new Scanner(System.in);
    // function to take input
    public void get_new_cust_details()
    {
        System.out.println("Enter customer ID: ");
        cust_id = take.next();
        System.out.println("Enter name: ");
        Name = "";
        Name = take.nextLine();
        Name += take.nextLine();
        System.out.println("Enter meter number: ");
        meter_no = take.nextInt();
        System.out.println("Enter type of meter: ");
        meter_type = take.next();
        //meter_type+=take.next();
        System.out.println("Enter safe deposit amount: ");
        s_deposite = take.nextInt();
        System.out.println("Enter deposit date: ");
        date_of_inst = take.next();
        System.out.println("Enter area code: ");
        Area_code = take.nextInt();
        System.out.println("Enter address: ");
        Address ="";
        Address = take.nextLine();
        Address+=take.nextLine();
        //take.close();
    }
    
    public void display_record_details()
    {
        System.out.println("\nPlease confirm the following details");
        System.out.println("Customer ID: "+cust_id);
        System.out.println("Name: "+Name);
        System.out.println("Address: "+Address);
        System.out.println("Pincode: "+Area_code);
        System.out.println("Meter number: "+meter_no);
        System.out.println("Type of meter: "+meter_type);
        System.out.println("Safe deposit amount: "+s_deposite);
        System.out.println("Deposit date: "+date_of_inst);
        System.out.println("Enter y to add details, n to make changes: ");
        co = take.next();
        
        if("y".equals(co))
        {
            System.out.println("Details saved");
        }
        
        else if("n".equals(co))
        {
            get_new_cust_details();
        }
    } 
}

class show_cust_details extends New_cust
{
    public void show_details()
    {
        System.out.println("Customer ID: "+cust_id);
        System.out.println("Name: "+Name);
        System.out.println("Address: "+Address);
        System.out.println("Pincode: "+Area_code);
        System.out.println("Meter number: "+meter_no);
        System.out.println("Type of meter: "+meter_type);
        System.out.println("Safe deposit amount: "+s_deposite);
        System.out.println("Deposit date: "+date_of_inst);
    }  
}

//interface
interface inf_mod
{
    void modify_cd();
}

//using interface
class delete_cust_details extends New_cust implements inf_mod    //hirarchical + multiple inheritance
{
    //data members
    String ID;
    char ad_ch;
    Scanner sdcd = new Scanner(System.in);
   public void modify_cd()
   {
       System.out.println("Enter customer ID: ");
       ID = sdcd.next();
       if(ID.equals(cust_id))
       {
           System.out.println("Please confirm before deleting");
           System.out.println("\nCustomer ID: "+cust_id);
           System.out.println("Name: "+Name);
           System.out.println("Meter number: "+meter_no);
           System.out.println("Do you want to delete this record?(y/n)");
           ad_ch = sdcd.next().charAt(0);
       }
       
       
       if(ad_ch == 'y')
       {
           cust_id = null;
           Name = null;
           Address = null;
           Area_code = 0;
           meter_no = 0;
           meter_type = null;
           s_deposite = 0;
           date_of_inst = null;
           System.out.println("\nRecord deleted");
       }
       else
       {
           System.out.println("\nRecord not deleted");
       }
   }
}

// using interface
class update_cust_details extends New_cust implements inf_mod    //hierarchical + multiple inheritance
{
    String c_id;
    char ad_ch1;
    Scanner sucd = new Scanner(System.in);
    
    public void modify_cd()
    {
        System.out.println("Enter customer ID: ");
        c_id = sucd.next();
        if(c_id.equals(cust_id))
        {
            System.out.println("Please confirm before updating");
            System.out.println("\nCustomer ID: "+cust_id);
            System.out.println("Name: "+Name);
            System.out.println("Meter number: "+meter_no);
            System.out.println("Do you want to update this record?(y/n)"); 
            ad_ch1 = sucd.next().charAt(0);
        }
        
        if(ad_ch1 == 'y')
       {
           get_new_cust_details();
           System.out.println("\nRecord updated successfully!");
       }
       else
       {
           System.out.println("\nRecord not updated");
       }
    }
    
}
public class Login_module {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scan = new Scanner(System.in);   //object scan of class scanner
        int chooseuser, True = 1, c1, c2, attempt = 2;
        char admin = 'y', user = 'y';
        show_cust_details obj_scd = new show_cust_details();    //object of show_cust_details class
        Display_deposit_details obj_d3 = new Display_deposit_details();   //object of display_deposit_details class
        update_cust_details obj_ucd = new update_cust_details();        //object of update_cust_details class
        delete_cust_details obj_dcd = new delete_cust_details();        //object of delete_cust_details class
        //cust_end crc = new cust_end();  // object of cust_end class of Complaint_reg package
        office_end oee = new office_end();  //object of office_end class of Complaint_reg package
        
        while(true)
        {
            System.out.println("****** Electricity Billing System ******");
            System.out.println("By - K.Shreyasi & Kshitija Chilbule");
            System.out.println("\n[1] Admin \n[2] Customer");
            System.out.println("Enter 1 for Admin login and 2 for Customer login:");
            chooseuser = scan.nextInt();
        
            switch(chooseuser)
            {
                case 1:
                {
                    //object of login class
                    Login L1 = new Login();
                    L1.sign_in();
                    
                    while(admin == 'y')
                    {
                        System.out.println("\nChoose a option: \n[1] New \n[2] Customer Details \n[3] Customer deposite details \n[4] Update \n[5] Delete \n[6] Complaint Register \n[7] Logout");
                        System.out.println("Enter choice: ");
                        c1 = scan.nextInt();
                    
                        switch(c1)
                        {
                            case 1:
                            {
                                System.out.println("\n=====* New Customer Details *======");
                                //show_cust_details obj_scd = new show_cust_details();
                                obj_ucd.get_new_cust_details();
                                obj_ucd.display_record_details();
                               // New_cust obj_nc = new New_cust();
                                //obj_nc.get_new_cust_details();
                                //obj_nc.display_record_details();
                                break;
                            }
                            case 2:
                            {
                                //show_cust_details obj_scd = new show_cust_details();
                                System.out.println("\n=====* Customer Details *======");
                                obj_scd.show_details();
                                break;
                            }
                            case 3:
                            {
                                System.out.println("\n=====* Customer Deposit Details *======");
                                System.out.println();
                                //Display_deposite_details obj_d3 = new Display_deposite_details();
                                obj_d3.cust_deposite();
                                break;
                            }
                            case 4:
                            {
                                System.out.println("\n=====* Update Customer Details *======");
                                //update_cust_details obj_ucd = new update_cust_details();
                                obj_ucd.modify_cd();
                                break;
                            }
                            case 5:
                            {
                                System.out.println("\n=====* Delete Customer Details *======");
                                //delete_cust_details obj_dcd = new delete_cust_details();
                                obj_dcd.modify_cd();
                                break;
                            }
                            case 6:
                            {
                                System.out.println("\n======* Complaint Register *======");
                                oee.view_comp();
                                break;
                            }
                            case 7:
                            {
                                System.out.println("\n You are successfully logged out");
                                System.exit(0);
                               // admin = 'n';
                                break;
                            }
                            default:
                            {
                                System.out.println("\n Invalid Input");
                                break;
                            }
                        }
                    }
                }
                
                case 2:
                {                        
                    //object of login class
                    Login L2 = new Login();  
                    L2.sign_in();
                    //cust_end crc = new cust_end();  // object of cust_end class of Complaint_reg package
                   
                    while(user == 'y')
                    {
                        System.out.println("\nChoose a option: \n[1] Calculate Bill \n[2] Pay Bill \n[3] Complaint Registration \n[4] Logout");
                        System.out.println("Enter choice: ");
                        c2 = scan.nextInt();
                    
                        switch(c2)
                        {
                            case 1:
                            {
                                //object of calculate_bill class
                                calulate_bill cb_obj = new calulate_bill();
                                cb_obj.get_cust_details();
                                cb_obj.cal_bill();
                                cb_obj.Display_receipt();
                                break;
                            }
                            case 2:
                            {
                                //object of pay_bill 
                                pay_bill pb_obj = new pay_bill();
                                pb_obj.get_pay();
                                break;
                            }
                            case 3:
                            {
                                System.out.println("======* Complaint Registration *======");
                                //crc.get_cust_comp();
                                oee.get_cust_comp();
                                break;
                            }
                            case 4:
                            {
                                System.out.println("\n You are successfully logged out");
                                //System.exit(0);
                                user = 'n';
                                break;
                            }
                            
                            default:
                            {
                                System.out.println("\n Invalid Input");
                                break;
                            }
                        }
                    }
                } 
            }
        }   
    } 
}
