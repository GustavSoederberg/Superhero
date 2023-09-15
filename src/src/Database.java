import java.util.ArrayList;
import java.util.Scanner;

public class Database {
    ArrayList<Superhero> database = new ArrayList<>();

    public Database() {
        database = new ArrayList<>();
    }
    public void addSuperhero(String superheroName, String realName, String superpower, int creationYear, boolean isHuman, int strength) {
        Superhero superhero = new Superhero(superheroName, realName, superpower, creationYear, isHuman, strength);
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

    public void editSuperhero(Superhero s){
        int editOrEnd = -1;
        do {
            System.out.println("""
                What do you want to edit?
                1. Superhero name:
                2. Real name:
                3. Superpower:
                4. Creation year:
                5. Is human:
                6. Strength:
                7. End editing:
                """);

            System.out.println("\n" + getIndexedSuperheroDatabase());
            Scanner scanner = new Scanner(System.in);
            editOrEnd = scanner.nextInt();
            scanner.nextLine();
            switch (editOrEnd){
                case 1:
                    System.out.println("Old superhero name: " + s.getName());
                    System.out.println("Set new superheroname: ");
                    String name = scanner.nextLine();
                    s.setName(name);
                    System.out.println("New name set to: " + s.getName());
                    break;
                case 2:
                    System.out.println("Old name: " + s.getRealName());
                    System.out.println("set new real name: ");
                    String realName = scanner.nextLine();
                    s.setRealName(realName);
                    System.out.println("New real name set to: "+ s.getRealName());
                    break;
                case 3:
                    System.out.println("Old superpower: " + s.getSuperPower());
                    System.out.println("set new superpower: ");
                    String superPower = scanner.nextLine();
                    s.setSuperPower(superPower);
                    System.out.println("New superpower set to: " + s.getSuperPower());
                    break;
                case 4:
                    System.out.println("Old creation year: " + s.getYearCreated());
                    System.out.println("New creation year");
                    int creationYear= 0;
                    s.setYearCreated(creationYear);
                    System.out.println("New creation year set to: " + s.getYearCreated());
                    break;
                case 5:
                    System.out.println("Is human is set to: " + s.isHuman());
                    System.out.println("Superhero is human? [true/false]");
                    boolean isHuman = scanner.hasNext();
                    s.isHuman(isHuman);
                    System.out.println("The superhero is human: " + s.isHuman());
                    break;
                case 6:
                    System.out.println("Old Strength: " + s.getStrength());
                    System.out.println("set new Strength: ");
                    int strength = scanner.nextInt();
                    s.setStrength(strength);
                    System.out.println("New strength set to: " + s.getStrength());
                    break;
                case 7:
                    System.out.println("Editing ended.");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        } while(editOrEnd != 7);
    }
    public String getIndexedSuperheroDatabase() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Superhero superhero : database) {
            stringBuilder.append(database.indexOf(superhero) + 1);
            stringBuilder.append(" ");
            stringBuilder.append(superhero);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
    public int size() {
        return database.size();
    }
    public Superhero get(int index) {
        if (index >= 0 && index < database.size()) {
            return database.get(index);
        } else {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
    }

}
