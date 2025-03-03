import java.util.ArrayList;
import java.util.List;
public class reg_utenti{
    private List<User> users = new ArrayList<>();

    public Boolean sign_user(String nome, String password){
        for (User user : users){
            if(user.getName().equals(nome)){
                return false;
            }
        }
        users.add(new User(nome, password));
        return true;
    }

    public User login(String nome, String password){
        for(User user : users){
            if(user.getName().equals(nome) && user.getPass().equals(password)){
                return user;
            }
        }
        return null;
    }

    public void printUsers(){
        for (User u : users){
            System.out.println("Nome: "+ u.getName() + ", Punteggio: "+ u.getPoints()+ ", Livello: "+ u.getLevel());
        }
    }
}