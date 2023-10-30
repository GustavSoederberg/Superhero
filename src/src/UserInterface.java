import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterface {
    private Controller controller;

    public void startProgram() {
        UserInterface ui = new UserInterface();
        Database database = new Database();
        Controller controller = new Controller(database);
        Scanner scanner = new Scanner(System.in);
        int isRunning = -1;
        do {
            ui.controller.printStartMessage();
            try {
                isRunning = scanner.nextInt();
                scanner.nextLine();
                switch (isRunning) {
                    case 1 -> {
                        System.out.println("Enter superhero details:");

                        System.out.print("Superhero Name: ");
                        String superheroName = scanner.nextLine();

                        System.out.print("Real Name: ");
                        String realName = scanner.nextLine();

                        System.out.print("Superpower: ");
                        String superpower = scanner.nextLine();

                        int creationYear;
                        while (true) {
                            try {
                                System.out.print("Creation Year: ");
                                creationYear = scanner.nextInt();
                                break;
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid input. Please enter a valid year.");
                                scanner.nextLine();
                            }
                        }

                        boolean isHuman;
                        while (true) {
                            try {
                                System.out.print("Is the superhero human? (y/n): ");
                                char yesOrNo = scanner.next().charAt(0);
                                if (yesOrNo == 'y' || yesOrNo == 'Y') {
                                    isHuman = true;
                                    break;
                                } else if (yesOrNo == 'n' || yesOrNo == 'N') {
                                    isHuman = false;
                                    break;
                                } else {
                                    System.out.println("Invalid input. Please enter 'y' or 'n'.");
                                }
                            } catch (StringIndexOutOfBoundsException e) {
                                System.out.println("Invalid input. Please enter 'y' or 'n'.");
                                scanner.nextLine();
                            }
                        }
                        int strength;
                        while (true) {
                            try {
                                System.out.print("Strength: ");
                                strength = scanner.nextInt();
                                break;
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid input. Please enter a Strength.");
                                scanner.nextLine();
                            }
                        }

                        controller.addSuperhero(superheroName, realName, superpower, creationYear, isHuman, strength);
                        System.out.println("Superhero added to database");
                    }
                    case 2 -> { //TODO må ikke snakke med superhero direkte
                        ArrayList<Superhero> superheroes = controller.getDatabase();
                        for (Superhero superhero : superheroes) {
                            System.out.println("Superhero Name: " + superhero.getName());
                            System.out.println("Real Name: " + superhero.getRealName());
                            System.out.println("Superpower: " + superhero.getSuperPower());
                            System.out.println("Creation Year: " + superhero.getYearCreated());
                            if (superhero.isHuman()) {
                                System.out.println("Is human: Yes");
                            } else {
                                System.out.println("Is human: No");
                            }
                            System.out.println("Strength: " + superhero.getStrength());
                            System.out.println();
                        }
                    }
                    case 3 -> {
                        System.out.println("Search for superhero:");
                        String search = scanner.nextLine();
                        Superhero foundSuperhero = controller.findSuperhero(search);
                        if (foundSuperhero == null) {
                            System.out.println("No superhero was found");
                        } else System.out.println(foundSuperhero);

                    }
                    case 4 -> {
                        System.out.println("Search for superhero");
                        String search = scanner.nextLine();

                        ArrayList<Superhero> findAllsuperheroList = controller.findAllSuperhero(search);

                        if (findAllsuperheroList == null) {
                            System.out.println("No superheroes with that name");
                        } else System.out.println(findAllsuperheroList);
                    }
                    case 5 -> ui.controller.editSuperheroDetails();
                    case 6 -> {
                        System.out.println("Select a superhero to remove:");
                        for (int i = 0; i < database.size(); i++) {
                            System.out.println(i + 1 + ". " + database.get(i).getName());
                        }
                        int searchIndex = scanner.nextInt() - 1;
                        controller.removeSuperhero(searchIndex);
                        System.out.println(database);
                    }
                    case 9 -> System.out.println("Program ended");
                    default -> System.out.println("Try again with the values stated under: ");
                }
            } catch (InputMismatchException e) {
                System.out.println("not possible input. Press ENTER to continue");
                scanner.nextLine();
            }

        } while (isRunning != 9);

        scanner.close();
    }

}
