package pl.sebcza;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Sebastian on 08.06.2016.
 */
public class CarNotesBean {

}

class CarNote{
    private Date noteDate;
    private int miltage;
    private String comment;
    private double  petrolCapacity;

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
