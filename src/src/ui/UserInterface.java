package ui;

import domain.Controller;
import domain.Superhero;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterface {
    private Scanner scanner = new Scanner(System.in);
    private Controller controller = new Controller();

    public void startProgram() {
        int input = -1;
        boolean checkMark = false;
        do {
            try {
                printStartMessage();
                input = scanner.nextInt();
                scanner.nextLine();
                switch (input) {
                    case 1 -> {
                        createSuperhero();
                        checkMark = true;
                    }
                    case 2 -> viewSuperhero();
                    case 3 -> searchSuperhero();
                    case 4 -> getListOfSpecificSuperheroes();

                    case 5 -> {
                        edit();
                        checkMark = true;
                    }

                    case 6 -> {
                        removeSuperhero();
                        checkMark = true;
                    }
                    case 7 -> {
                        if (checkMark && !controller.getDatabase().isEmpty()) {
                            controller.saveSuperheroes(controller.getDatabase());
                            System.out.println("Superheros is saved");
                        } else System.out.println("No changes have been made. Please change or load the list to save");
                    }
                    case 8 -> controller.loadSuperheroes(controller.getDatabase());
                    case 9 -> {
                        sortSuperhero();
                        checkMark = true;
                    }
                    case 10 -> System.out.println("Program ended");
                    default -> System.out.println("Try again with the values stated under: ");
                }
            } catch (InputMismatchException e) {
                System.out.println("not possible input. Press ENTER to continue");
                scanner.nextLine();
            }
        }

        while (input != 10);
    }

    private void createSuperhero() {
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

    private void edit() {
        System.out.println("Select a superhero to edit:");
        for (int i = 0; i < controller.size(); i++) {
            System.out.println(i + 1 + ". " + controller.getIndexedSuperheroName(i));
        }

        System.out.print("Enter the index of the superhero you want to edit: ");
        int choice = scanner.nextInt();

        if (choice > 0 && choice <= controller.size()) {
            Superhero selectedSuperhero = controller.get(choice - 1);

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
                System.out.println(selectedSuperhero);
                editOrEnd = scanner.nextInt();
                scanner.nextLine();
                switch (editOrEnd) {
                    case 1 -> {
                        System.out.println("Old superhero name: " + selectedSuperhero.getName());
                        System.out.println("Set new superhero name: ");
                        String name = scanner.nextLine();
                        selectedSuperhero.setName(name);
                        System.out.println("New name set to: " + selectedSuperhero.getName());
                    }
                    case 2 -> {
                        System.out.println("Old name: " + selectedSuperhero.getRealName());
                        System.out.println("set new real name: ");
                        String realName = scanner.nextLine();
                        selectedSuperhero.setRealName(realName);
                        System.out.println("New real name set to: " + selectedSuperhero.getRealName());
                    }
                    case 3 -> {
                        System.out.println("Old superpower: " + selectedSuperhero.getSuperPower());
                        System.out.println("set new superpower: ");
                        String superPower = scanner.nextLine();
                        selectedSuperhero.setSuperPower(superPower);
                        System.out.println("New superpower set to: " + selectedSuperhero.getSuperPower());
                    }
                    case 4 -> {
                        System.out.println("Old creation year: " + selectedSuperhero.getYearCreated());
                        System.out.println("New creation year");
                        int creationYear = scanner.nextInt();
                        selectedSuperhero.setYearCreated(creationYear);
                        System.out.println("New creation year set to: " + selectedSuperhero.getYearCreated());
                    }
                    case 5 -> {
                        boolean validInput = false;
                        while (!validInput) {
                            System.out.println("Is superhero human: " + selectedSuperhero.isHuman());
                            System.out.print("Set superhero as human? [y/n]: ");
                            String input = scanner.next().trim().toLowerCase();

                            if (input.equals("y")) {
                                selectedSuperhero.setIsHuman(true);
                                validInput = true;
                            } else if (input.equals("n")) {
                                selectedSuperhero.setIsHuman(false);
                                validInput = true;
                            } else {
                                System.out.println("Invalid choice. Please enter 'y' or 'n'.");
                            }
                        }
                        System.out.println("Updated superhero is human: " + selectedSuperhero.isHuman());
                    }
                    case 6 -> {
                        System.out.println("Old Strength: " + selectedSuperhero.getStrength());
                        System.out.println("set new Strength: ");
                        int strength = scanner.nextInt();
                        selectedSuperhero.setStrength(strength);
                        System.out.println("New strength set to: " + selectedSuperhero.getStrength());
                    }
                    case 7 -> System.out.println("Editing ended.");

                    default -> System.out.println("Invalid option. Please try again.");
                }
            } while (editOrEnd != 7);
        } else {
            System.out.println("Invalid choice. Please try again.");
        }
    }

    private void viewSuperhero() {
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

    private void searchSuperhero() {
        System.out.println("Search for superhero:");
        String search = scanner.nextLine();
        Superhero foundSuperhero = controller.findSuperhero(search);
        if (foundSuperhero == null) {
            System.out.println("No superhero was found");
        } else System.out.println(foundSuperhero);

    }

    private void getListOfSpecificSuperheroes() {
        System.out.println("Search for superhero");
        String search = scanner.nextLine();

        ArrayList<Superhero> findAllSuperheroList = controller.findAllSuperhero(search);

        if (findAllSuperheroList == null) {
            System.out.println("No superheroes with that name");
        } else System.out.println(findAllSuperheroList);
    }

    private void removeSuperhero() {
        System.out.println("Select a superhero to remove:");
        for (int i = 0; i < controller.size(); i++) {
            System.out.println(i + 1 + ". " + controller.getIndexedSuperheroName(i));
        }
        int searchIndex = scanner.nextInt() - 1;
        controller.removeSuperhero(searchIndex);
        System.out.println("Superhero is removed");
    }

    private void sortSuperhero() {
        System.out.println("""
                What primary attribute do you want to sort the database by?
                        1. Superhero name:
                        2. Real name:
                        3. Superpower:
                        4. Creation year:
                        5. Is human:
                        6. Strength:
                                                
                """);
        int choice = scanner.nextInt();
        System.out.println("""
                What secondary attribute do you want to sort the list by?
                If you choose the same attribute as before it will only sort by that attribute:
                        1. Superhero name:
                        2. Real name:
                        3. Superpower:
                        4. Creation year:
                        5. Is human:
                        6. Strength:
                                            
                """);
        int choice2 = scanner.nextInt();


        controller.sortSuperheroes(choice, choice2);
        System.out.println("List sorted");
    }

    private void printStartMessage() {
        System.out.println("""
                Press 1 to create superhero
                Press 2 to show superheroes
                Press 3 to find first Superhero
                Press 4 to get list of superheroes of search criteria
                Press 5 to edit superhero
                Press 6 to remove superhero from list
                Press 7 to save superheroes
                Press 8 to load superheroes from database
                Press 9 to sort list by attribute
                Press 10 to end
                """);
    }
}