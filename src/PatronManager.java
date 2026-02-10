import java.util.ArrayList;

/*Author: Paulina Flores Colasante
 Course: Software Development 1
 Date: 2/9/2026

 Class PatronManager: This class will process any additions or removals to the patron list.
 
 */
public class PatronManager {

    private ArrayList<Patron> patrons = new ArrayList<>();
    //Making it final since we are not planning on replacing the list at runtime.

    /**
     * method: addPatron
     * return: boolean
     * purpose: to add patron from the list using ID. Should either give a confirmation or an error.
     */
    public boolean addPatron(Patron patron){
        if(patronExists(patron.getId())) {
            return false;
        }
        patrons.add(patron);
        return true;
    }

    /**
     * method: removePatronById
     * return: boolean
     * purpose: to remove patron from the list using ID. Should either give a confirmation or an error.
     */
    public boolean removePatronById(int patronId){
        for(Patron patron : patrons){
            if(patron.getId() == patronId){
                patrons.remove(patron);
                return true;
            }
        }
        return false;
    }

    /**
     * method: patronExists
     * return: boolean
     * purpose: to ensure there are no duplicates to the Patron list.
     */
    public boolean patronExists(int patronId){
        for(Patron patron : patrons){
            if(patron.getId() == patronId){
                return true;
            }
        }
        return false;
    }
    /**
     * method: getAllPatrons
     * return: patron information
     * purpose: to display the current list of all Patrons
     */
    public void getAllPatrons(){
        if(patrons.isEmpty()){
            System.out.println("No Patrons in the System");
            return;
        }
        System.out.println("Patrons in the System");
        for (Patron patron : patrons) {
            System.out.println(patron);
        }
    }
}

