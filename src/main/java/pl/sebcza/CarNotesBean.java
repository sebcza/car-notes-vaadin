package pl.sebcza;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Sebastian on 08.06.2016.
 */
public class CarNotesBean {
    private static ArrayList<CarNote> carNotes = new ArrayList<CarNote>();
    public static void AddNote(CarNote note){
        carNotes.add(note);
    }
    public static ArrayList<CarNote> GetList(){
        return carNotes;
    }
}

class CarNote{
    public CarNote(Date noteDate, int miltage, String comment, double petrolCapacity) {
        this.noteDate = noteDate;
        this.miltage = miltage;
        this.comment = comment;
        this.petrolCapacity = petrolCapacity;
    }

    public Date noteDate;
    public int miltage;
    public String comment;
    public double  petrolCapacity;

    public Date getNoteDate() {
        return noteDate;
    }

    public void setNoteDate(Date noteDate) {
        this.noteDate = noteDate;
    }

    public int getMiltage() {
        return miltage;
    }

    public void setMiltage(int miltage) {
        this.miltage = miltage;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public double getPetrolCapacity() {
        return petrolCapacity;
    }

    public void setPetrolCapacity(double petrolCapacity) {
        this.petrolCapacity = petrolCapacity;
    }
}
