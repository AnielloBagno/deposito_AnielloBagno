public class User {
    private String nome;
    private String password; 
    private int punteggio;
    private int livello;

    public User(String nome, String password){
        this.nome = nome;
        this.password = password;
        this.punteggio = 0;
        this.livello = 1;
    }

    public String getName(){
        return nome;
    }
    public void setName(String nome){
        this.nome = nome;
    }
    public String getPass(){
        return password;
    }
    public void setPass(String password){
        this.password = password;
    }
    public int getPoints() {
        return punteggio;
    }
    public void setPoints(int punteggio) {
        this.punteggio = punteggio;
    }
    public int getLevel() {
        return livello;
    }
    public void setLevel(int livello) {
        this.livello = livello;
    }
    public void updatePoints(int points){
        punteggio +=points;
        if(punteggio >= 10 && livello == 1) 
            livello = 2;
        if(livello >= 20 && livello == 2)
            livello = 3;
    }
}
