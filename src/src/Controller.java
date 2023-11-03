import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Controller {
    private Database db = new Database();


    public Controller() {
    }

    public void addDataSuperheroes(){
        db.addDataSuperheroes();
    }

    public ArrayList<Superhero> findAllSuperhero(String search) {
        return db.findAllSuperhero(search);
    }

    public Superhero findSuperhero(String search) {
        return db.findSuperhero(search);
    }

    public ArrayList<Superhero> getDatabase() {
        return db.getDatabase();
    }

    public void addSuperhero(String superheroName, String realName, String superpower, int creationYear, boolean isHuman, int strength) {
        db.addSuperhero(superheroName, realName, superpower, creationYear, isHuman, strength);
    }

    public int size() {
        return db.size();
    }



    public String getIndexedSuperheroName(int index){
        return db.get(index).getName();
    }

    public Superhero get(int index){
        return db.get(index);
    }

    public void sortSuperheroes(int choice){
        db.sortSuperheroes(choice);
    }

    public void removeSuperhero(int index) {
        db.removeSuperhero(index);
    }
}
