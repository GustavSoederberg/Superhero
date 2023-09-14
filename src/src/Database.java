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

    public ArrayList<Superhero> findAllSuperhero(String search) {
        ArrayList<Superhero> searchResult = new ArrayList<Superhero>();
        for (Superhero s : database) {
            if (s.getName().contains(search)) {
                searchResult.add(s);

            }

        }
        if (!searchResult.isEmpty())
            for (Superhero s : searchResult) {
                System.out.println(s);
            }
        else {
            System.out.println("No superheroes in the list with that name");
        }
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


}
