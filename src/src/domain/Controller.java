package domain;

import data.FileHandler;

import java.util.ArrayList;


public class Controller {
    private Database db = new Database();
    private FileHandler fileHandler = new FileHandler();

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

    public void saveSuperheroes(ArrayList<Superhero> database){
        fileHandler.saveSuperheroes(database);
    }

    public void loadSuperheroes(ArrayList<Superhero> database){
        fileHandler.loadSuperheros(database);
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
    public void sortSuperheroes(int choice, int choice2){
        db.sortSuperheroes(choice, choice2);
    }

    public void removeSuperhero(int index) {
        db.removeSuperhero(index);
    }
}
