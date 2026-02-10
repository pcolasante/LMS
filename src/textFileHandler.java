import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*Author: Paulina Flores Colasante
 Course: Software Development 1
 Date: 2/9/2026

 Class textFileHandler: Will read text files and compute them into the application.
 
 */

/**
 * method: textFileHandler
 * purpose: to read and load the Patron information to the application
 */
public class textFileHandler {
    public static void loadFromFile(String fileName, PatronManager manager) {
        try {
            File file = new File(fileName);

            System.out.println("Looking for file at: " + file.getAbsolutePath());

            if (!file.exists()) {
                System.out.println("File does not exist.");
                return;
            }

            Scanner fileScanner = new Scanner(file);
            int lineNumber = 0;

            while (fileScanner.hasNextLine()) {
                lineNumber++;
                String line = fileScanner.nextLine();
                line = line.trim();
                if (line.isEmpty()) {
                    continue;
                }
                try {
                    // Split using hyphen
                    String[] parts = line.split("-");

                    if (parts.length != 4) {
                        throw new IllegalArgumentException("Incorrect format.");
                    }
                    int patronId = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    String address = parts[2];
                    double overdueAmount = Double.parseDouble(parts[3]);

                    Patron patron = new Patron(patronId, name, address, overdueAmount);

                    if (manager.addPatron(patron)) {
                        System.out.println("Added: " + patronId);
                    } else {
                        System.out.println("Duplicate ID skipped: " + patronId);
                    }

                } catch (Exception e) {
                    System.out.println("Error on line " + lineNumber + ": " + e.getMessage());
                }

            }

            fileScanner.close();
            System.out.println("File loading complete.");

        } catch (Exception e) {
            System.out.println("Could not open file: " + e.getMessage());
        }
    }

    /**
     * method: saveToFile
     * purpose: to save patron information to the text file, similar to a database.
     */
    public static void saveToFile(String fileName, List<Patron> patrons) {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(fileName));
            for (Patron patron : patrons) {
                writer.println(patron.getId() + "-" + patron.getName() + "-" + patron.getAddress() + "-" + patron.getOverdueAmount());
            }

            writer.close();
            System.out.println("File saving complete.");
        } catch (IOException e) {
            System.out.println("Could not save file: " + e.getMessage());
        }
    }
}
