import java.util.Scanner;
import java.util.Random;
public class Main
{
    public static void StartGame()
    {   int a;
        Scanner sc=new Scanner(System.in);
        Random r=new Random();
        int RN = r.nextInt(100)+1;
        System.out.println("A number Between 1 to 100");
        for(a=1;a<=5;a++)
        { 
            System.out.println("Guess The Number:");
            int num=sc.nextInt();
            if(num>RN)
            {
                int d=num-RN;
                if(d>=20)
                {
                    System.out.println("OOPS! Too High :( Try Again");
                }
                else
                {
                    if(d<5)
                    {
                        System.out.println("Too Close :) Little Lower");
                    }
                    else
                    {
                        System.out.println("Guess a number lower Than Previous");
                    }
                }
                System.out.println("You Have " + (5-a) + " Tries Remaining");
            }
            else if(num<RN)
            {
                int d=RN-num;
                if(d>=20)
                {
                    System.out.println("OOPS! Too Low :( Try Again");
                }
                else
                {
                    if(d<5)
                    {
                        System.out.println("Too Close :) Little Higher");
                    }
                    else
                    {
                        System.out.println("Guess a number Higher Than Previous");
                    }
                }
                System.out.println("You Have " + (5-a) + " Tries Remaining");
            }
            else
            {
                System.out.println("Congratulations!!! You Have Guessed the correct Number");
                System.out.println("You Guessed in " + a +" Tries");
                System.out.println("Your Score is: " + ((5-a)*20));
                break;
            }
        }
        if(a>5)
        {
            System.out.println("You Have Exceeded Maximum Tries:(");
            System.out.println("The Number is: " + RN);
        }
    }

    public static void main(String[] args) {
        Scanner Sc=new Scanner(System.in);
        int ch;
        while(true){
        System.out.println("1.Start Game");
        System.out.println("2.Exit");
        ch=Sc.nextInt();
        switch (ch) {
            case 1:
                StartGame();
                break;
            
            case 2:
                System.exit(0);
                break;
            default:
                System.out.println("Enter Correct Entry");
                break;
        }
    }
    }
}
