import java.util.ArrayList;
import java.util.Scanner;

public class Database {
    private ArrayList<Superhero> database;

    public Database() {
        database = new ArrayList<>();
    }

    public void addSuperhero(String superheroName, String realName, String superpower, int creationYear, boolean isHuman, int strength) {
        Superhero superhero = new Superhero(superheroName, realName, superpower, creationYear, isHuman, strength);
        database.add(superhero);
    }

    public void addDataSuperheroes() {
        Superhero superhero = new Superhero("Batman", "Bruce Wayne", "Money", 1939, true, 98);
        Superhero superhero1 = new Superhero("Superman", "Clark Kent", "Flying, Laser eyes, superhuman strength", 1941, false, 99);
        Superhero superhero2 = new Superhero("Batgirl", "Anne Davis", "Fighting, tech", 1963, true, 93);
        Superhero superhero3 = new Superhero("The Flash", "Barry", "Speed", 1966, true, 99);
        Superhero superhero4 = new Superhero("Wonder Woman", "Diana", "Strength, power", 1945, false, 95);
        database.add(superhero);
        database.add(superhero1);
        database.add(superhero2);
        database.add(superhero3);
        database.add(superhero4);

    }

    public ArrayList<Superhero> getDatabase() {
        return database;
    }

    public ArrayList<Superhero> findAllSuperhero(String search) {
        ArrayList<Superhero> searchResult = new ArrayList<>();
        for (Superhero s : database) {
            if (s.getName().contains(search)) {
                searchResult.add(s);

            }

        }
        if (searchResult.isEmpty()) {
            return null;
        } else
            return searchResult;
    }

    public Superhero findSuperhero(String search) {
        for (Superhero s : database) {
            if (s.getName().contains(search)) {
                return s;
            }
        }

        System.out.println("No superheroes in the list with that name");
        return null;
    }

    public void editSuperhero(Superhero s) {

    }

    public int size() {
        return database.size();
    }

    public Superhero get(int index) {
        if (index >= 0 && index < database.size()) {
            return database.get(index);
        } else {
            return null;
        }
    }

    public void removeSuperhero(int index) {
        database.remove(get(index));

    }


}
