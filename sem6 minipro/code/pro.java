import java.util.Scanner;
import java.lang.*;
class  dfa{
static int flag=0;
public static int Start(char c)
{       
        
	if(c=='a') return 1;
	else if(c=='b') return 3;
        else return 3;
}
public static int Q1(char c)
{
	if(c=='a') return 3;
	else if(c=='b') return 2;
	else return 3;
}
public static int Q2(char c)
{
	if(c=='a') return 4;
	else if(c=='b') return 3;
	else return 3;
}
public static int Q3(char c)
{
	
	if(c=='a') return 3;
	else if(c=='b'){
        
        return 3;
        }
	else return 3;
	

}
public static int Qf(char c)
{  
         flag=1;
         System.out.println("string is accepted ");
	int state=1;
      	return state;
}
}
public class pro extends dfa {
  public static void main(String arg[])
  {
	String a;
        int state=0;
	Scanner sc=new Scanner(System.in) ;
	System.out.println("enter the string\n");
	a=sc.nextLine();
        char c;
	for(int i=0;i<a.length();i++)
	{
		c=a.charAt(i);
		if(state==0)
			state=Start(c);
		else if(state==1)
			state=Q1(c);
		else if(state==2)
			state=Q2(c);
		else if(state==3)
			state=Q3(c);
		else if(state==4)
			{
		state=Qf(c);
			}
		
	}
       if(flag==0)
         System.out.println("not accepted");
	
	
  }
}

