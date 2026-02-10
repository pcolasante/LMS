import java.io.File;
import java.util.Scanner;

/*Author: Paulina Flores Colasante
 Course: Software Development 1
 Date: 2/9/2026

 Class textFileHandler: Will read text files and compute them into the application.
 
 */
public class textFileHandler {
    public static void loadFromFile(String fileName, PatronManager manager) {
    try{
        File file = new File(fileName);
        Scanner fileScanner = new Scanner(file);
        int lineNumber = 0;

        while (fileScanner.hasNextLine()) {
            lineNumber++;
            String line = fileScanner.nextLine();
            line = line.trim();
            if(line.isEmpty()){
                continue;
            }
            if (line.isBlank()) {
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
                manager.addPatron(patron); //am I being redundant PLEASE REMOVE THIS

                if (!manager.addPatron(patron)) {
                    System.out.println("Duplicate ID: " + patronId);
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
        }
