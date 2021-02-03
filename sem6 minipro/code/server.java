// A Java program for a Server
import java.net.*;
import java.io.*;
import java.util.Scanner;
import java.lang.*;
class  dfa{
static int flag=0;
public static int Start(char c)
{       System.out.println("state: start");
	if(c=='g') return 1;
	else return 0;
}
public static int Q0(char c)
{       System.out.println("state: Q0");
	if(c=='g') return 1;
	else if(c=='o') return 2;
	else return 0;
}
public static int Q1(char c)
{       System.out.println("state: Q1");
	if(c=='g') return 1;
	else if(c=='o') return 3;
	else return 0;
}
public static int Q2(char c,int i)
{
	System.out.println("state: Q2");
	if(c=='g') return 1;
	else if(c=='d'){
        i=i-3;
        System.out.println("state: final");
        System.out.println("string found at index "+i);
        return 4;
        }
	else return 0;
	

}
public static int Qf(char c)
{       flag=1;
	int state=0;
      	return state;
}
}
 class pro extends dfa {
  pro(String a)
  {
	//String a;
        int state=0;
	Scanner sc=new Scanner(System.in) ;
	//System.out.println("enter the string\n");
	//a=sc.nextLine();
        char c;
	for(int i=0;i<a.length();i++)
	{
		c=a.charAt(i);
		if(state==0)
			state=Start(c);
		else if(state==1)
			state=Q0(c);
		else if(state==2)
			state=Q1(c);
		else if(state==3)
			state=Q2(c,i);
		else if(state==4)
			{
			state=Qf(c);
			}
		
	}
         if(flag==0)
           System.out.println("string is not accepted");
	
	
  }
}

 
public class Server
{
    //initialize socket and input stream
    private Socket          socket   = null;
    private ServerSocket    server   = null;
    private DataInputStream in       =  null;
 
    // constructor with port
    public Server(int port)
    {
        // starts server and waits for a connection
        try
        {
            server = new ServerSocket(port);
            System.out.println("Server started");
 
            System.out.println("Waiting for a client ...");
 
            socket = server.accept();
            System.out.println("Client accepted");
 
            // takes input from the client socket
            in = new DataInputStream(
                new BufferedInputStream(socket.getInputStream()));
 
            String line = "";
 
           
                try
                {
                    line = in.readUTF();
                    System.out.println(line);
 
                }
                catch(IOException i)
                {
                    System.out.println(i);
                }

               pro p=new pro(line);
            System.out.println("Closing connection");
 
            // close connection
            socket.close();
            in.close();
        }
        catch(IOException i)
        {
            System.out.println(i);
        }
    }
 
    public static void main(String args[])
    {
        Server server = new Server(5000);
    }
}