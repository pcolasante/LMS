/*Author: Paulina Flores Colasante
 Course: Software Development 1
 Date: 2/9/2026

 Class: Patron: All information from the patron is held here.
 It will obtain the name, address, ID number, and amount overdue.
 
 */
public class Patron {

    int patronId;
    String name;
    String address;
    double overdueAmount;

    public Patron(int patronId, String name, String address, double overdueAmount) {

        if (overdueAmount < 0 || overdueAmount > 250) {
            throw new IllegalArgumentException("Overdue Amount must be between $0 and $250");
        }

        if (String.valueOf(patronId).length() != 7) {
            throw new IllegalArgumentException("Patron ID must be 7 digits");
        }

        this.patronId = patronId;
        this.name = name;
        this.address = address;
        this.overdueAmount = overdueAmount;


    }

    public int getId() {
        return patronId;


    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public double getOverdueAmount() {
        return overdueAmount;
    }

    @Override
    public String toString() {
        return "ID: " + patronId + ", Name: " + name + ", Address: " + address + ", Overdue: " + overdueAmount;

    }
}
