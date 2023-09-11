import java.util.ArrayList;

public class Database {
    ArrayList<Superhero> database;

    public Database() {
        database = new ArrayList<>();
    }
    public void addSuperhero(String superheroName, String realName, String superpower, int creationYear, boolean hasSuperpowers, int strength) {
        Superhero superhero = new Superhero(superheroName, realName, superpower, creationYear, hasSuperpowers, strength);
        database.add(superhero);
        System.out.println("Superhero added to the database.");
    }
    public ArrayList<Superhero> getDatabase() {
        return database;
    }
}
