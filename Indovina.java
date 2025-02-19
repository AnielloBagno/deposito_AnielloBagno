import java.util.Random;
import java.util.Scanner;
public class Indovina {
    public static void main(String[] args)throws InterruptedException {
        boolean b=true;
        Scanner Num;
        do{
            System.out.print("\033[H\033[2J");
            System.out.flush();
            Random rand= new Random();
            int x= rand.nextInt(100);
            x+=1;
            int g=0;
            
            while (g!=x) { 
                Num =new Scanner (System.in);
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.print("Indovina il numero: ");
                g=Num.nextInt();
                if(g>x){
                    System.out.println("Il numero che hai scelto è troppo alto");
                    Thread.sleep(1000);
                }
                else if(g<x){
                    System.out.println("Il numero che hai scelto è troppo basso");
                    Thread.sleep(1000);
                }          
            }
                
                System.out.print("Complimenti, hai indovinato il numero segreto. Inserisci il numero 1 se vuoi giocare ancora: ");
                Num=new Scanner(System.in);
                int s=Num.nextInt();
                if(s!=1)
                    b=false;
        }while(b);
    }
}
