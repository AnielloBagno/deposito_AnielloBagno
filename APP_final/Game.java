import java.util.Random;
import java.util.Scanner;
public class Game {
    private static final Random rand = new Random();
    
    public static void domanda(User user)throws InterruptedException{
        boolean loop = true;
        do{
            System.out.print("\033[H\033[2J");
            System.out.flush();
            String risp= "";
            int livello = user.getLevel();
            int a = rand.nextInt(10 * livello) + 1;
            int b = rand.nextInt(10 * livello) + 1;
            int risultato = 0;
            String op = " ";
                switch(livello){
                    case 1:
                        op = "+";
                        risultato = a + b;
                        break;
                    case 2:
                        op = "-";
                        risultato = a-b;
                        break;
                    case 3:
                        op = "*";
                        risultato = a * b;
                        break;
                    default:
                }
            
            Scanner scan = new Scanner(System.in);
            System.out.println("Quanto fa "+ a + " " + op + " " + b + " ?");
            int r = scan.nextInt();

            if(r == risultato){
                System.out.println("Risposta corretta! Ti sono stati assegnati 5 punti");
                user.updatePoints(5);
                Thread.sleep(500);
                scan.nextLine();
                System.out.println("Vuoi continuare a giocare ? (si/no)");
                 risp = scan.nextLine();
                if(risp.equals("no")){
                    loop = false;
                }
            }else{
                System.out.println("Risposta errata! Ti sono stati sottratti 3 punti");
                user.updatePoints(-3);   
                Thread.sleep(500);
                scan.nextLine();
                System.out.println("Vuoi continuare a giocare ? (si/no)");
                 risp = scan.nextLine();
                if(risp.equals("no")){
                    loop = false;
                }
            }
        }while(loop);
    }
}
