package demo.ayan;
import java.util.Scanner;

public class Calculator 
{
	public static void main(String[] args) 
	{
		System.out.println("WELCOME TO AYAN'S CALCULATOR:\n :OPERATION VALUES: \n (to add=1), \n (to sub=2), \n (to mul=3), \n (to div=4), \n (to mod=5),");
				
		Scanner sc=new Scanner(System.in);
		
		while(true) 
		{
			System.out.println("put your 1st value");
			int num1= sc.nextInt();
			System.out.println("put your OPERATION value");
			int num2= sc.nextInt();
			System.out.println("put your 2nd value");
			int num3=sc.nextInt();
			
			if(num2==1)
			{
				System.out.println("Addition will be= " + (num1+num3));
			}
			else if(num2==2)
			{
				System.out.println("Substraction will be= " + (num1-num3));
			}
			else if(num2==3)
			{
				System.out.println("Multipliication will be= " + (num1*num3));
			}
			else if(num2==4)
			{
				System.out.println("Divition will be= " + (num1/num3));
			}
			else if(num2==5)
			{
				System.out.println("Modulus will be= " + (num1%num3));
			}
			
			System.out.println("Want to calculate more? type 1 for contine and 0 for exit..");
			int check=sc.nextInt();
			
			if(check == 0) {
				System.exit(0);
			} else {
				System.out.println("Here we go agian!");
			}
		}
	}
}
