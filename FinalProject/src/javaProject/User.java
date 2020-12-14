/**
 * 
 */
package javaProject;

import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * @author team
 *
 */
public class User extends functions {
	//MohammedSirajuddin-654
	public void NewUser()
	{   
		String inputDialog3;
		inputDialog3 = JOptionPane.showInputDialog("Enter the number of Accounts you want to Create: ");
		int namenumber=Integer.parseInt(inputDialog3);
		System.out.println(namenumber);
		ArrayList<String> name = new ArrayList<>(namenumber);
		ArrayList<Integer> contact= new ArrayList<>(namenumber);
		ArrayList<Double> amnt= new ArrayList<>(namenumber);
		
		
		
		for(int i=0;i<namenumber;i++) 
		{
		int c=0;
		JOptionPane.showMessageDialog(null, "Enter your details");
		try {
		PrintWriter outs = new PrintWriter(new FileWriter("userdetails.txt", true));
        BufferedWriter bw = new BufferedWriter(new FileWriter("statement.txt", true));
        String name1;
        String contact1;
        String line;
        String lread;
        String amnt1;
        String ac;
        String actype;
        JFrame f = new JFrame();
        /*************************************************/
        do
        {
        	
        c=0;
        name1= JOptionPane.showInputDialog("Enter your name",JOptionPane.OK_CANCEL_OPTION);
        name.add(i,name1);
        
        
        if (name.get(i).length() < 2) 
        {
        	JOptionPane.showMessageDialog(f,
        		    "Name Should be greater than 2-Characters."
        			+"",
        		    "Enter a Valid Name.",JOptionPane.ERROR_MESSAGE);
            c++;
        } else if (name.get(i).matches(".*?[\\p{Punct}&&[^_]].*") || name.get(i).matches("[a-zA-Z ]*\\d+.*")) 
        {
        	JOptionPane.showMessageDialog(f,
        		    "-Enter a Valid Name."
        			+"",
        		    "Enter a Valid Name.",JOptionPane.ERROR_MESSAGE);
            
            c++;
        }
		}while (c == 1);

        /*************************************************/
        do
        {
        contact1= JOptionPane.showInputDialog("Enter your contact number",JOptionPane.OK_CANCEL_OPTION);	
        double contactnumber=Double.parseDouble(contact1);
        int contactnumber1=(int)contactnumber;
        contact.add(i, contactnumber1);
        
        BufferedReader br = new BufferedReader(new FileReader("userdetails.txt"));
        
        if (contact.get(i).equals("(.*)[a-zA-Z]+(.*)") || contact.get(i).equals(".*?[\\p{Punct}&&[^_]].*"))
        {
            
            JOptionPane.showMessageDialog(f,
        		    "-Enter a Valid Contact Number."
        			+"",
        		    "Enter a Valid Contact Number.",JOptionPane.ERROR_MESSAGE);
            c++;
        } 
        else if (contact.get(i).SIZE < 15) 
        {
            c++;
            JOptionPane.showMessageDialog(f,
        		    "-Contact Number Should be of 10-Digits."
        			+"",
        		    "Contact Number Should be of 10-Digits.",JOptionPane.ERROR_MESSAGE);
            
        } 
        else 
        {
            while ((lread = br.readLine()) != null) 
            {
                c = 0;
                if (lread.contains(contact.get(i) + " "))
                {
                    c++;
                    JOptionPane.showMessageDialog(f,
                		    "Contact Number Already Exists."
                			+"",
                		    "Contact Number Already Exists.",JOptionPane.ERROR_MESSAGE);
                    break;
                }
            }
        }
        
        }while (c == 1);
        
        /*************************************************/
        
        
        do
        {
        	c = 0;
        	amnt1= JOptionPane.showInputDialog("Enter the amount",JOptionPane.OK_CANCEL_OPTION);	
            double amount=Integer.parseInt(amnt1);
            amnt.add(i, amount);
            
            if (amnt.equals("(.*)[a-zA-Z]+(.*)") || amnt.equals(".*?[\\p{Punct}&&[^_]].*")) 
            {

                c++;
                JOptionPane.showMessageDialog(f,
            		    "Enter a Valid Amount."
            			+"",
            		    "Enter a Valid Amount.",JOptionPane.ERROR_MESSAGE);
              
            } 
            else {
               
                if (amnt.get(i)< 1000)
                {
                	JOptionPane.showMessageDialog(f,
                		    "Initial Amount Should be greater than or equals to Rs.1000."
                			+"",
                		    "Enter a Valid Amount.",JOptionPane.ERROR_MESSAGE);
                	
                    
                    c++;
                }
            }
	
        }while (c == 1);
        
        /*************************************************/
        //MohammedSirajuddin-654
       
		do
        {
        	
        	ac= JOptionPane.showInputDialog("Enter Your Account type (Saving or Current) :"
        			+ "",JOptionPane.OK_CANCEL_OPTION);
            actype = ac.toLowerCase();
            if (!(actype.equals("saving") || actype.equals("current")))
            {
            	
            	JOptionPane.showMessageDialog(f,
            		    "Account Type Should be saving or current"
            			+"",
            		    "Enter a Valid Account type.",JOptionPane.ERROR_MESSAGE);
                
            }

		}while(!(actype.equals("saving") || actype.equals("current")));
		
        if (actype.equals("saving"))
        {
            actype = "saving";
        }
        
        /*************************************************/
        Random rnd = new Random();
        String username;
        String password;
        username= JOptionPane.showInputDialog("Please enter your new user name:"
    			+ "Account creation",JOptionPane.OK_CANCEL_OPTION);
        password=JOptionPane.showInputDialog("Please enter your new password:"
    			+ "Account creation",JOptionPane.OK_CANCEL_OPTION);
        
        
      /*  char nm[]=new char[6];
        Random rnd = new Random();
       
        String username;
        
    
        name.get(i).getChars(0,3,nm,0);
        username = String.valueOf(nm).trim();

        if (username.length() < 2) {
            username = username + (10000 + rnd.nextInt(90000));
        } else if (username.length() < 3) {
            username = username + (1000 + rnd.nextInt(9000));
        } else {
            username = username + (100 + rnd.nextInt(900));
        }

        if (username.contains(" ")) {
            username = username.replace(" ", "a");
        }


        //contact.getChars(2,6,pin,0);
        //contact.getChars(5,10,acnumber,0);
        //pass=String.valueOf(pin).trim();
        //acnt=String.valueOf(acnumber).trim();
        char ps[]=new char[6];
        String password;
        name.get(i).getChars(3,7,ps,0);
        password = String.valueOf(nm).trim();
        if (password.length() < 3) {
            password = password + (10000 + rnd.nextInt(90000));
        } else if (password.length() < 3) {
            password = password + (1000 + rnd.nextInt(9000));
        } else {
            password = password+ (100 + rnd.nextInt(900));
        }

        if (password.contains(" ")) {
            password = password.replace(" ", "a");
        }
        
       
      
       // String password=JOptionPane.showInputDialog("Please enter your new password:"
    		//	+ "Account creation",JOptionPane.OK_CANCEL_OPTION);
        */
        

        /*************************************************/
        int acnt;
        do {
            acnt = 10000 + rnd.nextInt(90000);
            c = 0;
            BufferedReader br = new BufferedReader(new FileReader("userdetails.txt"));
            while ((lread = br.readLine()) != null)
            {
                if (lread.contains(acnt + " "))
                {
                    c++;
                    break;
                }
            }
            br.close();
        } while (c == 1);
        JOptionPane.showMessageDialog(f,
        	    "Account Created Successfully.",
        	    "Account Created Successfully.",
        	    JOptionPane.INFORMATION_MESSAGE);

        JOptionPane.showMessageDialog(f,
        	    "Username :" + username,
        	    "Account details for Account"+acnt,
        	    JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(f,
        	    "Password :" + password,
        	    "Account details for Account "+acnt,
        	    JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(f,
        	    "Amount :" + amnt.get(i),
        	    "Account Summary for Account "+acnt,
        	    JOptionPane.INFORMATION_MESSAGE);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");//MohammedSirajuddin-654
        String date = sdf.format(new Date());

        /*************************************************/
        
        bw.write(username + " " + acnt + " " + amnt.get(i) + " initial" + " " + amnt.get(i) + " " + date); 
      //statement.txt
        bw.newLine();
        
        bw.close();
        
        outs.println(username + " " + password + " " + acnt + " " + actype + " " + contact.get(i) + " " + amnt.get(i)); //userdetails.txt
      //userdetails.txt
        outs.close();
        
        
        BufferedWriter wr = new BufferedWriter(new FileWriter("name.txt", true));
        wr.write("Username:-  "+ username + " Password:- " + password + " Account Holders name " + name.get(i));
        wr.newLine();
        wr.close();


		}
		//MohammedSirajuddin-654
		catch(Exception e)
		{
			
            System.out.println(e);
		}
		}
		}

//MohammedSirajuddin-654
	
//ganeshganji-996

	//MohammedSirajuddin-654
	//MohammedSirajuddin-654
//ArrayList<String> account = new ArrayList<String>(6);
private Random scan;

public void ExistingUser()
{JFrame f = new JFrame();
	JOptionPane.showMessageDialog(f, "Enter your details");
   
    int count=0;
    String name=null,pass=null,amt=null,cont=null,actyp=null;
    
    
    String uname = JOptionPane.showInputDialog(f,"Enter your NAME",JOptionPane.OK_CANCEL_OPTION);
  
    String upass = JOptionPane.showInputDialog(f,"Enter your password",JOptionPane.OK_CANCEL_OPTION);

    String userpass=uname+" "+upass+" ";
    char cnt=' ';
    int choice;
    String line,line2,fullname;
    char full[]=new char[100];
    //ArrayList<String> full = new ArrayList<String>(100);
    try
    {


        BufferedReader ins=new BufferedReader(new FileReader("userdetails.txt"));


        while((line=ins.readLine())!=null)
        {

            if(line.contains(userpass))
            {
            	JOptionPane.showMessageDialog(f,
                	    "Logged In Successfully !.",
                	    ".",
                	    JOptionPane.INFORMATION_MESSAGE);
                
                BufferedReader nmf=new BufferedReader(new FileReader("name.txt"));

                while((line2=nmf.readLine())!=null)
                {

                    if(line2.contains(userpass))
                    {
                        line2.getChars(13,line2.length(),full,0);
                        fullname=String.valueOf(full).trim();
                        JOptionPane.showMessageDialog(f,
                        	    "Welcome :" + fullname,
                        	    "Account details for Account",
                        	    JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                nmf.close();



                line.getChars(12,18,account,0);
                String ac=String.valueOf(account).trim();
                String userac=uname+" "+ac;
                User u=new User();
                do
                {	
                	
                	String s = JOptionPane.showInputDialog(f,"Please Enter your choice "
            				+"\n1.Deposit"
            				+"\n2.Withdraw"
            				+"\n3.Transfer Money"
            				+"\n4.Pay Utilities"
            				+"\n5.Balance Inquiry"
            				+"\n6.Loan Details"
            				+"\n7.Mini Statement"
            				+"\n"
            				+"\n",JOptionPane.QUESTION_MESSAGE);
            		

                    switch(s) {
                        case "1":
                            ins.close();
                            u.deposit(userpass);
                            break;
                        case "2":
                            ins.close();
                            u.withdraw(userpass);
                            break;
                        case "3":
                            ins.close();
                            String acc1,acc2,a1;
                           
                            acc1= JOptionPane.showInputDialog(f,"Enter a Account number to transfer from",JOptionPane.OK_CANCEL_OPTION);
                            acc2= JOptionPane.showInputDialog(f,"Enter a Account number to transfer to",JOptionPane.OK_CANCEL_OPTION);
                            
                            a1= JOptionPane.showInputDialog("Enter the amount you want to transfer",JOptionPane.OK_CANCEL_OPTION);
                            Float a=Float.parseFloat(a1);
                           
                           

                            withdrawfrom(acc1, a);
                            depositto(acc2, a);
                            break;
                        case "4":
                            int options;
                            do {
                            	String s1 = JOptionPane.showInputDialog(f,"Please Enter your choice "
                        				+"\n1.Electricity Bill"
                        				+"\n2.Water Bill"
                        				+"\n3.Mobile Bill"
                        				+"\n4.Internet Bill"
                        				+"\n5.Exit"
                        				,JOptionPane.QUESTION_MESSAGE);
                                
                            	
                                options= Integer.parseInt(JOptionPane.showInputDialog(f,"Enter choice [1-5]: ",JOptionPane.OK_CANCEL_OPTION));
                                switch (options) {
                                    case 1:
                                     
                                        int Units = Integer.parseInt(JOptionPane.showInputDialog(f,"Please Enter the Units that you Consumed  :",JOptionPane.OK_CANCEL_OPTION));
                                        u.ElectricityBill1(Units, uname);
                                        break;

                                    case 2:
                                
                                        int galoonused = Integer.parseInt(JOptionPane.showInputDialog(f," Enter the galoon of water used   : ",JOptionPane.OK_CANCEL_OPTION));
                                        u.waterBill(galoonused, userpass);
                                        break;

                                    case 3:

                                        int textUsed = Integer.parseInt(JOptionPane.showInputDialog(f," Please Enter the texts sent   :  :",JOptionPane.OK_CANCEL_OPTION));
                                        double callUsed = Double.parseDouble(JOptionPane.showInputDialog(f,"Please Enter minutes used  :  ",JOptionPane.OK_CANCEL_OPTION));
                                        u.mobileBill(textUsed, callUsed, userpass);

                                        break;

                                    case 4:
                                       
                                        double dataconsumed = Double.parseDouble(JOptionPane.showInputDialog(f,"Please Enter the data consumed   : :",JOptionPane.OK_CANCEL_OPTION));
                                        u.internetBill(dataconsumed, userpass);
                                        break;

                                    case 5:
                                        u.ExistingUser();
                                        break;
                                }
                            } while (options != 6);
                                   break;
                        case "5":
                            ins.close();
                            u.statement(userac);
                            break;
                        case "6":
                        	double principal;
                    		String input;
                    		
                    		input = JOptionPane.showInputDialog(f,"Enter Principal Amount",JOptionPane.OK_CANCEL_OPTION);
                    		principal = Double.parseDouble(input);
                    		
                            
                            int year = Integer.parseInt(JOptionPane.showInputDialog(f,"Enter Time period in years : :",JOptionPane.OK_CANCEL_OPTION));
                            
                          u.loandetails(principal, year);
                            break;
                        case "7":
                            ins.close();
                            u.inquiry(userpass);
                            break;
                        default :
                        	JOptionPane.showMessageDialog(f,
                        		    "You Have Entered Wrong Choice"
                        			+"",
                        		    "Incorrect Choice",JOptionPane.ERROR_MESSAGE);
                            
                            break;

                    }
                   // System.out.println("Do you want to continue (Y/N) :");
                   // cnt=scan.next().charAt(0);
                     //cnt=JOptionPane.showInputDialog("Do you want to continue (Y/N)");
                    
                    
                  //MohammedSirajuddin-654
             //String c;
             //c=JOptionPane.showInputDialog("Do you want to continue (Y/N)");

                
             
           //MohammedSirajuddin-654           
                
                
              // while(cnt=='Y' || cnt=='y');
                
                //if(cnt!='y' ||cnt!='Y')
                /*{
                    System.out.println("-------------------------------------------------------------");
                    System.out.println("Thank You");
                    System.out.println("          For Banking...");
                    System.out.println("-------------------------------------------------------------");
               */ //}
                count=1;
                break;
                }while (choice!=8);
            }

        }
        if(count==0)
        {
        	JOptionPane.showMessageDialog(f,
        		    "You Have Entered Wrong User/Password"
        			+"",
        		    "Incorrect Choice",JOptionPane.ERROR_MESSAGE);
        
        }


        ins.close();


    }
    catch(InputMismatchException e)
    {
        System.out.println("\nOops !!! You Have Entered Wrong Input...");
        System.out.println("-------------------------------------------------------------");
    }
    catch(Exception e)
    {
    	
    	System.out.println(e);
    	
    }
  
}//MohammedSirajuddin-654
//MohammedSirajuddin-654

public void DeleteAccount()
{
    String oldFileName = "userdetails.txt";
    String tmpFileName = "out.txt";


	String uname = JOptionPane.showInputDialog("Enter User Name");
   // System.out.println("Enter User Name :");
 //   String uname=scanner.next();

	String upin = JOptionPane.showInputDialog("Enter Your Password");
   // System.out.println("Enter Your Pin Number :");
   // int Upin=Integer.parseInt(upin);
 //  String upin=scanner.next();

    String combo=uname+" "+upin+" ";
    String data;
    int cnt=0;
    String ac=null;
    String userac=null;
    BufferedReader ins=null;
    BufferedWriter outs=null;

    try
    {
        ins=new BufferedReader(new FileReader(oldFileName));
        outs=new BufferedWriter(new FileWriter(tmpFileName));

        while((data=ins.readLine())!=null)
        {

            if(data.contains(combo))
            {
                data.getChars(16,20,account,0);
                ac=String.valueOf(account).trim();

                cnt++;
                continue;
            }

            outs.write(data);
            outs.newLine();
        }
        userac=uname+" "+ac;

        if(cnt==0)
        {
        	JOptionPane.showMessageDialog(null, " You Have Entered Wrong User/Password(Pin)...");
            //System.out.println("\nOops !!! You Have Entered Wrong User/Password(Pin)...");
           // System.out.println("-------------------------------------------------------------");
        }
        else
        {   JOptionPane.showMessageDialog(null, "Account Deleted Successfully..."
        		+"\nThank You"
        		+"\nFor Banking");
           // System.out.println("\nAccount Deleted Successfully...");
           // System.out.println("-------------------------------------------------------------");
           // System.out.println("Thank You");
           // System.out.println("          For Banking...");
            //System.out.println("-------------------------------------------------------------");
        }

    }
    catch(Exception e){}
    finally
    {
        try
        {
            if(ins != null)
                ins.close();
        }
        catch (IOException e)
        {
            //
        }
        try
        {
            if(outs != null)
                outs.close();
        }
        catch (IOException e)
        {
            //
        }
    }

    File oldFile = new File(oldFileName);
    oldFile.delete();


    File newFile = new File(tmpFileName);
    newFile.renameTo(oldFile);
/////////////////////////////////////////////////////////////////////
    String old="statement.txt";
    String temp="delete.txt";
    try
    {
        ins=new BufferedReader(new FileReader(old));
        outs=new BufferedWriter(new FileWriter(temp));

        while((data=ins.readLine())!=null)
        {
            if(data.contains(userac))
            {
                continue;
            }

            outs.write(data);
            outs.newLine();
        }

    }
    catch(Exception e){}
    finally
    {
        try
        {
            if(ins != null)
                ins.close();
        }
        catch (IOException e)
        {
            //
        }
        try
        {
            if(outs != null)
                outs.close();
        }
        catch (IOException e)
        {
            //
        }
    }

    File oldF = new File(old);
    oldF.delete();


    File newF = new File(temp);
    newF.renameTo(oldF);
////////////////////////////////////////////////////////////////////////////////////////////////////

    String oldFile2="name.txt";
    String tempFile2="delete.txt";
    try
    {
        ins=new BufferedReader(new FileReader(oldFile2));
        outs=new BufferedWriter(new FileWriter(tempFile2));

        while((data=ins.readLine())!=null)
        {
            if(data.contains(uname))
            {
                continue;
            }

            outs.write(data);
            outs.newLine();
        }

    }
    catch(Exception e){}
    finally
    {
        try
        {
            if(ins != null)
                ins.close();
        }
        catch (IOException e)
        {
            //
        }
        try
        {
            if(outs != null)
                outs.close();
        }
        catch (IOException e)
        {
            //
        }
    }

    File oldName = new File(oldFile2);
    oldName.delete();


    File newName = new File(tempFile2);
    newName.renameTo(oldName);


}



  
//MohammedSirajuddin-654 --final commit



}

