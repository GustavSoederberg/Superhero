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
        System.out.println("Superhero added to the database.");
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

    public void editSuperhero(Superhero s) {
        int editOrEnd;
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
            System.out.println(s);
            Scanner scanner = new Scanner(System.in);
            editOrEnd = scanner.nextInt();
            scanner.nextLine();
            switch (editOrEnd) {
                case 1 -> {
                    System.out.println("Old superhero name: " + s.getName());
                    System.out.println("Set new superheroname: ");
                    String name = scanner.nextLine();
                    s.setName(name);
                    System.out.println("New name set to: " + s.getName());
                }
                case 2 -> {
                    System.out.println("Old name: " + s.getRealName());
                    System.out.println("set new real name: ");
                    String realName = scanner.nextLine();
                    s.setRealName(realName);
                    System.out.println("New real name set to: " + s.getRealName());
                }
                case 3 -> {
                    System.out.println("Old superpower: " + s.getSuperPower());
                    System.out.println("set new superpower: ");
                    String superPower = scanner.nextLine();
                    s.setSuperPower(superPower);
                    System.out.println("New superpower set to: " + s.getSuperPower());
                }
                case 4 -> {
                    System.out.println("Old creation year: " + s.getYearCreated());
                    System.out.println("New creation year");
                    int creationYear = 0;
                    s.setYearCreated(creationYear);
                    System.out.println("New creation year set to: " + s.getYearCreated());
                }
                case 5 -> {
                    boolean validInput = false;
                    while (!validInput) {
                        System.out.println("Is superhero human: " + s.isHuman());
                        System.out.print("Set superhero as human? [y/n]: ");
                        String input = scanner.next().trim().toLowerCase();

                        if (input.equals("y")) {
                            s.setIsHuman(true);
                            validInput = true;
                        } else if (input.equals("n")) {
                            s.setIsHuman(false);
                            validInput = true;
                        } else {
                            System.out.println("Invalid choice. Please enter 'y' or 'n'.");
                        }
                    }
                    System.out.println("Updated superhero is human: " + s.isHuman());
                }
                case 6 -> {
                    System.out.println("Old Strength: " + s.getStrength());
                    System.out.println("set new Strength: ");
                    int strength = scanner.nextInt();
                    s.setStrength(strength);
                    System.out.println("New strength set to: " + s.getStrength());
                }
                case 7 -> System.out.println("Editing ended.");
                default -> System.out.println("Invalid option. Please try again.");
            }
        } while (editOrEnd != 7);
    }

    public int size() {
        return database.size();
    }

    public Superhero get(int index) {
        if (index >= 0 && index < database.size()) {
            return database.get(index);
        } else {
            System.out.println("Index out of bounds: " + index);
            return null;
        }
    }

    public void removeSuperhero(int index) {
        System.out.println(database);
        database.remove(get(index));

    }


}
