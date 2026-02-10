/*Author: Paulina Flores Colasante
 Course: Software Development 1
 Date: 2/9/2026

 Class: Patron: All information from the patron is held here.
 It will obtain and return the name, address, ID number, and amount overdue.
 
 */
public class Patron {

    int patronId;
    String name;
    String address;
    double overdueAmount;

    /**
     * method: Patron
     * return: Patron
     * purpose: to obtain and return the Patron Information of the patron
     */
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
    /**
     * method: getId
     * return: int
     * no parameters
     * purpose: to obtain and return the ID of the patron
     */
    public int getId() {
        return patronId;


    }
    /**
     * method: getName
     * return: String
     * no parameters
     * purpose: to obtain and return the name of the patron
     */
    public String getName() {
        return name;
    }

    /**
     * method: getAddress
     * return: String
     * no parameters
     * purpose: to obtain and return the address of the patron
     */
    public String getAddress() {
        return address;
    }

    /**
     * method: getOverdueAmount
     * return: double
     * no parameters
     * purpose: to obtain and return the overdue amount of the patron
     */
    public double getOverdueAmount() {
        return overdueAmount;
    }


    @Override
    public String toString() {
        return "ID: " + patronId + ", Name: " + name + ", Address: " + address + ", Overdue: " + overdueAmount;

    }
}
