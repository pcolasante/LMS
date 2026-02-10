import java.util.ArrayList;

/*Author: Paulina Flores Colasante
 Course: Software Development 1
 Date: 2/9/2026

 Class PatronManager: This class will process any additions or removals to the patron list.
 
 */
public class PatronManager {

    private ArrayList<Patron> patrons = new ArrayList<>();
    //Making it final since we are not planning on replacing the list at runtime.

    public boolean addPatron(Patron patron){
        if(patronExists(patron.getId())) {
            return false;
        }
        patrons.add(patron);
        return true;
    }
    public boolean removePatronById(int patronId){
        for(Patron patron : patrons){
            if(patron.getId() == patronId){
                patrons.remove(patron);
                return true;
            }
        }
        return false;
    }

    public boolean patronExists(int patronId){
        for(Patron patron : patrons){
            if(patron.getId() == patronId){
                return true;
            }
        }
        return false;
    }

    public void getAllPatrons(){
        if(!patrons.isEmpty()){
            System.out.println("No Patrons in the System");
            return;
        }
        for (Patron patron : patrons) {
            System.out.println(patron);
        }
    }
}

