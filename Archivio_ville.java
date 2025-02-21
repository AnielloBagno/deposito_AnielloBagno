import java.lang.foreign.SymbolLookup;
import java.util.ArrayList;
import java.util.Scanner;
public class Archivio_ville {

    private static ArrayList<String> nome_villa= new ArrayList<String>();
    private static ArrayList<Integer> n_stanze= new ArrayList<Integer>();
    private static final ArrayList<Boolean> pool= new ArrayList<>();
    private static Scanner str= new Scanner (System.in);
    private static Scanner num= new Scanner (System.in);

    public static void main(String[] args)throws InterruptedException {
        boolean loop=true;
        while(loop){
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("1)Aggiungi una villa \n2)Visualizza elenco ville \n3)Ricerca villa per nome \n4)Exit");
            int s= num.nextInt();
            
            switch (s) {
                case 1:
                    add_villa();
                    Thread.sleep(1000);
                    main(args);
                    break;
                case 2:
                    view_villa();
                    Thread.sleep(1000);
                    main(args);
                    break;
                case 3:
                    find_villa();
                    Thread.sleep(1000);
                    main(args);
                    break;
                case 4:
                    loop=false;
                    break;
                default:
                    System.out.println("Scegli un'opzione valida");
                    Thread.sleep(1000);
            }
        }
    }// fine main

    private static void add_villa(){
        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.print("Inserisci il nome della villa: ");
        String nome= str.nextLine();
        System.out.print("Inserisci il numero di stanze presenti: ");
        int num_stanze= num.nextInt();
        System.out.print("Nella villa e\' presente una piscina? (si/no)");
        String piscina= str.nextLine();
        nome_villa.add(nome);
        n_stanze.add(num_stanze);
        if(piscina.equals("si"))
            pool.add(true);
        System.out.println("La villa e\' stata aggiunta");
    }

    private static void view_villa(){
        System.out.print("\033[H\033[2J");
        System.out.flush();

        if(nome_villa.isEmpty())
            System.out.println("Nessuna villa registrata");
        else{
            System.out.println("Elenco delle ville: ");
            for(int i = 0; i < nome_villa.size(); i++){
                System.out.println("Nome: "+ nome_villa.get(i) + "\nNumero stanze: "+ n_stanze.get(i)+ "\nPiscina: "+ (pool.get(i) ? "Si" : "No"));
            }
        }   
    }

    private static void find_villa(){
        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.print("Nome della villa da cercare: ");
        String nome= str.nextLine();
        boolean found=false;

        for(int i = 0; i < nome_villa.size(); i++){
            if(nome_villa.get(i).equalsIgnoreCase(nome)){
                System.out.println("Villa trovata! \nNome: "+ nome_villa.get(i) + "\nNumero stanze: "+ n_stanze.get(i)+ "\nPiscina: "+ (pool.get(i) ? "Si" : "No"));
                found=true;
                break;
            }
        }
        if(!found)
            System.out.println("Villa non trovata");
    }
}
