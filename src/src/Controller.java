import java.util.ArrayList;

public class Controller {
    private Database db;

    public Controller(Database db) {
        this.db = db;
    }

    public void addSuperhero(String superheroName, String realName, String superpower, int creationYear, boolean hasSuperpowers, int strength) {
        db.addSuperhero(superheroName, realName, superpower, creationYear, hasSuperpowers, strength);
        System.out.println("Superhero added to the database.");
    }

    public ArrayList<Superhero> getDatabase() {
        return db.getDatabase();
    }
}
