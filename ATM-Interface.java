import java.util.*;
class ATM_Interface {
    Scanner sc=new Scanner(System.in);
    String Username;
    String Password;
    String Name;
    int Balance;
    String TransHistory="";
    int IsLogin=0;
    int IsFinished=0;
    String User;
    void Register()
    {
        System.out.println("Enter Your name:");
        this.Name=sc.nextLine();
        System.out.println("Enter UserName:");
        this.Username=sc.nextLine();
        System.out.println("Create Password:");
        this.Password=sc.nextLine();
        System.out.println("Deposit Initial Balance:");
        this.Balance=sc.nextInt();
        System.out.println("Your Current Balance is:"+Balance);
        System.out.println("Registration Succesfull");

    }
    void SignIn()
    {
        System.out.println("Enter Username:");
        String Input=sc.nextLine();
        if(Input.equals(this.Username))
        {
            Password();
        }
        else
        {
            System.out.println("Incorrect Username\nPlease Try Again!!!");
            SignIn();
        }
    }
    void Password()
    {
        System.out.println("Enter Password:");
        String pass=sc.nextLine();
        if(pass.equals(Password))
        {
            System.out.println("Login SuccesFull");
            IsLogin=1;
        }
        else
        {
            System.out.println("Incorrect Password");
            Password();
        }
    }  
    
    void Withdrawal()
    {
        System.out.println("Enter Withdrawal Amount:");
        int Amount=sc.nextInt();
        if(this.Balance>=Amount)
        {
            if(Amount>10000)
            {
                System.out.println("Transaction Limit is 10000");
                System.out.println("Please Enter lower Amount");
                Withdrawal();
            }
            else
            {
                System.out.println("Please Collect Cash of Rs."+Amount);
                this.Balance=this.Balance-Amount;
                String str=Amount+" Rs Withdrawed\n";
                this.TransHistory=this.TransHistory+str;
            }
        }
        else
        {
            System.out.println("Amount Insufficient");
        }
    }
    void Deposit()
    {
        System.out.println("Enter Deposit Amount:");
        int Amount=sc.nextInt();
        if(Amount>10000)
        {
            System.out.println("Enter a Lower Amount");
            Deposit();
        }
        else
        {
            System.out.println("Rs. "+Amount+" Deposited Succesfully");
            this.Balance=this.Balance+Amount;
            String str=Amount +" Rs Deposited\n";
            this.TransHistory=this.TransHistory+str;
        }
    }
    void Transfer()
    {
        System.out.println("Enter Recipients Name:");
        String RName=sc.nextLine();
        System.out.println("Enter Amount to be Transferred:");
        int Amount=sc.nextInt();
        if(this.Balance>Amount)
        {
            System.out.println("Rs. "+Amount+" Succesfully Tansferred\n");
            this.Balance=this.Balance-Amount;
            String str=Amount +" Rs Transferred to "+RName+"\n";
            this.TransHistory=this.TransHistory+str;
        }
        else
        {
            System.out.println("Amount Insufficient");
        }
    }
    void CheckBalance()
    {
        System.out.println("Balance:"+this.Balance);
    }
    void TransHistory()
    {
        System.out.println("Transaction History:");
        System.out.println(this.TransHistory);
    }
    void Quit()
    {
        System.out.println("Thank you for using the ATM.");
        IsFinished=1;
        
    }
}

public class Main
{
    public static void main(String[] args) 
    {
        Scanner in=new Scanner(System.in);
        System.out.println("******************Welcome To ATM Interface**********************");
        
        System.out.println("\n1.Register \n2.Exit");
        System.out.println("Enter Your Choice:");
        int ch=in.nextInt();
        if(ch==1)
        {
            ATM_Interface a = new ATM_Interface();
            a.Register();  
            while(true)
            {
                System.out.println("\n1.Login \n2.Exit\n");
                System.out.println("Enter Your Choice:");
                int choice=in.nextInt();
                if(choice==1)
                {
                    int c=0;
                    a.SignIn();
                    if(a.IsLogin==1)
                    {
                        while(a.IsFinished==0)
                        {
                            System.out.println("1.Withdrawl");
                            System.out.println("2.Deposit");
                            System.out.println("3.Transfer");
                            System.out.println("4.Transaction History");
                            System.out.println("5.Check balance");
                            System.out.println("6.Exit");
                            System.out.println("Enter Your Choice:");  
                            c=in.nextInt();
                            switch(c)
                            {
                                case 1:
                                {
                                    a.Withdrawal();
                                    break;
                                }
                                case 2:
                                {
                                    a.Deposit();
                                    break;
                                }
                                case 3:
                                {
                                    a.Transfer();
                                    break;
                                }
                                case 4:
                                {
                                    a.TransHistory();
                                    break;
                                }
                                case 5:
                                {
                                    a.CheckBalance();
                                    break;
                                }
                                case 6:
                                {
                                    a.Quit();
                                }
                            }
                        }
                    }
                }
                else
                {
                    System.exit(0);
                }
            }
        }
        else
        {
            System.exit(0);
        }
        in.close();
    }
}
