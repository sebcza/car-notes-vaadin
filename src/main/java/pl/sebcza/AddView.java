package pl.sebcza;

import com.google.gwt.thirdparty.guava.common.collect.Lists;
import com.google.gwt.user.datepicker.client.DatePicker;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import static pl.sebcza.MyUI.ADDVIEW;
import static pl.sebcza.MyUI.navigator;import static pl.sebcza.MyUI.navigator;
/**
 * Created by Sebastian on 08.06.2016.
 */
public class AddView extends  TemplateView {

    private Grid listNotes;
    private FormLayout form;
    private  DateField noteDate;
    private TextField mileage;
    private TextArea comment;
    private TextField petrolCapacity;
    private Button submit;

    public AddView() {
         form = new FormLayout();

         noteDate = new DateField("Data wpisu");


         mileage = new TextField("Przebieg");

         comment = new TextArea("Komentarz");

         petrolCapacity = new TextField("Ilość paliwa");

         submit = new Button("Dodaj notatkę");
        submit.setDisableOnClick(true);

        form.addComponent(noteDate);
        form.addComponent(mileage);
        form.addComponent(comment);
        form.addComponent(petrolCapacity);
        form.addComponent(submit);

        form.setWidth(100, Unit.PERCENTAGE);


        submit.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                CarNote carN = new CarNote(noteDate.getValue(), Integer.parseInt(mileage.getValue()),
                       comment.getValue(), Double.parseDouble(petrolCapacity.getValue()));
                CarNotesBean.AddNote(carN);
                navigator.navigateTo("");
            }
        });



        contentSpace.addComponent(form);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        super.enter(viewChangeEvent);
        if(CarBean.loggedUser == null){
            navigator.navigateTo("login");
        }
        noteDate.setValue(new Date());
        mileage.setValue("");
        comment.setValue("");
        petrolCapacity.setValue("");
        submit.setEnabled(true);
    }
}
