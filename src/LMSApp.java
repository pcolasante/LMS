/*Author: Paulina Flores Colasante
 Course: Software Development 1
 Date: 2/9/2026
 
 
 Program Objective: Build a Library Management System for a local library to maintain and keep record of their patrons. 
 This includes adding, removing, and displaying a list of current patrons. It should also be able to exit the program.
 The user will be asked to input patron details to either add/remove.
 The program will return the patron list, and a confirmation.

 Class: LMSApp (Main class): Will launch the main console-based application.
 
 */

import java.util.Scanner;

public class LMSApp {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        PatronManager manager = new PatronManager();

        int selectChoice;

        do {
            System.out.println("\n--- LMS - LIBRARY MANAGEMENT SYSTEM ---\n");
            System.out.println("1. Add New Patron");
            System.out.println("2. Remove Patron");
            System.out.println("3. List Patrons");
            System.out.println("4. Load Patron From File");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");

            selectChoice = scanner.nextInt();
            scanner.nextLine(); // clear buffer
            switch (selectChoice) {
                case 1:
                    System.out.println("\n--- Add New Patron ---\n");
                    try {
                        System.out.println("Enter 7-Digit Patron ID: ");
                        int patronId = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println("Enter Patron Name: ");
                        String name = scanner.nextLine();

                        System.out.println("Enter Patron Address: ");
                        String address = scanner.nextLine();

                        System.out.println("Enter Patron Overdue Amount: ");
                        double overdueAmount = scanner.nextDouble();

                        Patron patron = new Patron(patronId, name, address, overdueAmount);

                        if (manager.addPatron(patron)) {
                            System.out.println("Patron added successfully!");
                            manager.getAllPatrons();
                        } else {
                            System.out.println("Patron could not be added!");
                            manager.getAllPatrons();
                        }

                    } catch (Exception e) {
                        System.out.println("INVALID INPUT: " + e.getMessage());
                        scanner.nextLine();
                    }
                    break;
                case 2:
                    System.out.println("\n--- Remove Patron ---\n");
                    try {
                        System.out.println("Enter 7-Digit Patron ID: ");
                        int removePatronById = scanner.nextInt();

                        if (manager.removePatronById(removePatronById)) {
                            System.out.println("Patron removed successfully!");
                            manager.getAllPatrons();
                        } else {
                            System.out.println("Patron could not be removed.");
                            manager.getAllPatrons();
                        }
                    } catch (Exception e) {
                        System.out.println("INVALID INPUT: " + e.getMessage());
                        scanner.nextInt();
                    }
                    break;
                case 3:
                    manager.getAllPatrons();
                    break;
                case 4:
                    System.out.println("\n--- Load Patron From File ---\n");
                    System.out.println("Enter file using the file path: ");
                    String fileName = scanner.nextLine();
                    textFileHandler.loadFromFile(fileName, manager);
                    manager.getAllPatrons();
                    break;
                case 5:
                    System.out.println("EXITING LIBRARY MANAGEMENT SYSTEM");
                    break;
                default:
                    System.out.println("INVALID SELECTION");
            }

        }
        while (selectChoice != 5);

        scanner.close();
    }
}
