import java.util.Scanner;
public class APP_final {
    static Scanner scan = new Scanner (System.in);
    public static void main(String[] args) throws InterruptedException{
        boolean loop = true;
        reg_utenti reg = new reg_utenti();
        User u_current = null;
        
        while(loop){
            clear();
            System.out.println("1)Registrazione \n2)Login \n3)Esci");
            int s = scan.nextInt();
            scan.nextLine();
            switch(s){
                case 1:
                    signup(u_current, reg);
                    loop = false;
                case 2:
                    log(u_current, reg);
                    loop = false;
                case 3:
                    clear();
                    System.out.print("Uscita dal sistema");
                    loop = false;
                    break;
                default:
                    System.out.println("Inserisci un'opzione valida");
            }
        }
        scan.close();
    }
    private static void clear()throws InterruptedException{
        System.out.print("\033[H\033[2J");
        System.out.flush();
        Thread.sleep(500);
    }

    private static void signup(User u, reg_utenti r) throws InterruptedException{
        clear();
        System.out.print("Inserisci il tuo nome per registrarti: ");
        String nome = scan.nextLine();
        System.out.print("Inserisci la tua password per registrarti: ");
        String pass = scan.nextLine();
        if(r.sign_user(nome, pass))
            System.out.println("Registrazione avvenuta con successo");
        else    
            System.out.println("Utente gia\' esistente");
       
    }

    private static void log(User u, reg_utenti r)throws InterruptedException{
        clear();
        boolean L = true;
        System.out.print("Inserisci il tuo nome per loggarti: ");
        String nome = scan.nextLine();
        System.out.print("Inserisci la tua password per loggarti: ");
        String pass = scan.nextLine();
        scan.nextLine();
        u = r.login(nome, pass);
        if (u != null){
            System.out.println("Login avvenuto con successo. Benvenuto " + u.getName());
            while (L) { 
                System.out.println("1)Gioca \n2)Stampa utenti \n3)Logout");
                int x = scan.nextInt();
                switch (x) {
                    case 1:
                        Game.domanda(u);
                    case 2:
                        r.printUsers(); 
                    case 3:
                        L = false;
                        System.out.println("Logout avvenuto con successo");
                        break;
                    default:
                    System.out.println("Inserisci un'opzione valida");
                }  
            }
        }else   
            System.out.println("Le credenziali inserite sono errate");
    }

}
