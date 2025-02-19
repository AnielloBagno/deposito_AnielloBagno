import java.util.Scanner;
public class Somma {
    public static void main(String[] args) {
        int N=0;
        int somma=0;
        while (N>=0) { 
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.print("Inserisci un numero: ");
            Scanner Num= new Scanner (System.in);
            N=Num.nextInt();
            if(N>=0)
                somma+=N;
            else{    
                System.out.println("Il numero che hai inserito è negativo.");
                Num.close();
            }
        }
     System.out.print("\nLa somma dei numeri inseriti e': "+ somma);   
    }
}
