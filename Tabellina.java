import java.util.Scanner;
public class Tabellina {
    public static void main(String[] args) {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.print("Inserisci il numero di cui vorresti stampare la tabellina: ");
        Scanner Num= new Scanner (System.in);
        int N=Num.nextInt();
        int i=1;
        while(i<=10){
            System.out.println(N*i);
            i++;
        }
        Num.close();
    }
}
