import java.util.Scanner;
public class Sistema_inserimento{
    public static void main(String[] args) throws InterruptedException{
        Scanner Name;
        Scanner Pass;
        Scanner Age;
        String Nome=" ";
        String Password=" ";
        int Eta=0;
        do{
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("Inserisci il nome, la password e l'eta': ");

            Name=new Scanner (System.in);
            Pass=new Scanner (System.in);
            Age= new Scanner (System.in);

            Nome=Name.nextLine();
            Password=Pass.nextLine();
            Eta=Age.nextInt();

        }while(Nome.isEmpty() || Password.isEmpty() || Eta==0);

        for (int i = 0; i < 3; i++){
            String x;
            String y;
            int z;

            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("Inserisci di nuovo i dati: ");

            Name=new Scanner (System.in);
            Pass=new Scanner (System.in);
            Age=new Scanner (System.in);

            x=Name.nextLine();
            y=Pass.nextLine();
            z=Age.nextInt(); 

            if((x.equals(Nome))&&(y.equals(Password))&& (z == Eta))
                System.out.println("I dati coincidono");
            else    
                System.out.println("I dati non coincidono");
        }
        Name.close();
        Pass.close();
        Age.close();
        
        Thread.sleep(2000);
        System.out.print("\033[H\033[2J");
        System.out.flush();
        
    }
}