import java.util.ArrayList;
import java.util.Scanner;

public class Esercizio_ArrayList{
    public static void main(String[] args) throws InterruptedException{
        
        Scanner str= new Scanner (System.in);
        Scanner num= new Scanner (System.in);

        int R=3;
        int C= 8;
        boolean ripeti= true;

        ArrayList<Integer> posto_r= new ArrayList<Integer>();
        ArrayList<Integer> posto_c= new ArrayList<Integer>();
        ArrayList<String> nominativo= new ArrayList<String>();

        while(ripeti){    //ciclo del sistema
            while(true){// ciclo della prenotazione
                System.out.print("Inserisci il tuo nome: ");
                String Nome= str.nextLine();

                System.out.print("Inserisci la fila: ");
                int fila= num.nextInt();

                System.out.print("Inserisci la colonna: ");
                int colonna= num.nextInt();

                if(fila < 0 || fila > R || colonna < 0 || colonna > C){
                    System.out.println("Posizione non valida.");
                    continue;
                }
                boolean posto_occupato = false;
                for(int i = 0; i < posto_r.size(); i++){
                    if(posto_r.get(i) == fila && posto_c.get(i) == colonna){
                        posto_occupato=true;
                        break;
                    }
                }
                if(!posto_occupato){
                    posto_r.add(fila);
                    posto_c.add(colonna);
                    nominativo.add(Nome);
                    System.out.println("Prenotazione effettuata ");
                }else   
                    System.out.println("Il posto e' gia' prenotato ");
                break;
            }
            Thread.sleep(1000);
            while(true){//ciclo ricerca prenotazione
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.print("Digita il nome da cercare: ");
                String cerca= str.nextLine();
                
                boolean found= false;
                
                for(int i = 0; i < nominativo.size(); i++){
                    if(nominativo.get(i).equalsIgnoreCase(cerca)){
                        System.out.println("Prenotazione trovata: "+ cerca + "\nFila: "+ posto_r.get(i) +"\nColonna: "+ posto_c.get(i));
                        found=true;
                    }
                }
                if(!found)
                    System.out.println("Per questo nome non e' stata trovata alcuna prenotazione. ");
                break;
            }
            Thread.sleep(1000);
            while(true){//ciclo visualizzazione posti prenotati e liberi
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println("Stato attuale dei posti: ");
                for(int i = 0; i < R; i++){
                    for(int j = 0; j < C; j++){
                        boolean posto_occupato= false;
                        for(int x = 0; x < posto_r.size(); x++){
                            if(posto_r.get(x) == i && posto_c.get(x) == j){
                                System.out.print("X");
                                posto_occupato=true;
                                break;
                            }
                        }
                        if(!posto_occupato)
                            System.out.print("O");
                    }
                    System.out.println();
                }
                break;
            }
            Thread.sleep(1000);
            while(true){
                int posti_T= R+C;
                int posti_O= posto_r.size();
                int posti_L= posti_T - posti_O;

                System.out.println("I posti totali sono: "+ posti_T + "\nI posti prenotati sono: "+ posti_O + "\nI posti liberi sono: "+ posti_L);
                break;
            }
            Thread.sleep(1000);
            System.out.print("\033[H\033[2J");
            System.out.flush();
            
            System.out.print("Vuoi chiudere il programma? si/no\n");
            String scelta= str.nextLine();
            if(scelta.equals("si")){
                ripeti=false;
                str.close();
                num.close();
                System.out.print("Chiusura programma");
            }
                
            else{
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
                
        }
    }
}