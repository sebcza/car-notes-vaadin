package pl.sebcza;

import com.google.gwt.thirdparty.guava.common.collect.Lists;

import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Label;

import java.util.Collection;
import java.util.Date;

/**
 * Created by Sebastian on 08.06.2016.
 */
public class ListView extends  TemplateView {

    private Grid listNotes;

    public ListView() {
        AbsoluteLayout layView = new AbsoluteLayout();
        layView.setHeight("100%");
        layView.setWidth("100%");
        Collection<CarNote> people = Lists.newArrayList(
                new CarNote(new Date(2016,5,1), 1234, "Spkok", 34.5),
                new CarNote(new Date(2016,5,1), 1234, "Spkok", 34.5),
                new CarNote(new Date(2016,5,1), 1234, "Spkok", 34.5)
                );

        listNotes = new Grid();
        listNotes.setWidth(100, Unit.PERCENTAGE);
        listNotes.addColumn("Date", String.class);
        listNotes.addColumn("Miltage", Integer.class);
        listNotes.addColumn("Comment", String.class);
        listNotes.addColumn("Capacity", Double.class);


        for (CarNote carn: people)
            listNotes.addRow(carn.getNoteDate().toString(), carn.getMiltage(), carn.getComment(), carn.getPetrolCapacity());
        Label label = new Label("List of Notes");
        label.setStyleName("h1");
        layView.addComponent(label, "left:0px; top:0px;");
        layView.addComponent(listNotes, "left:0px; top:100px;");
        contentSpace.addComponent(layView);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        super.enter(viewChangeEvent);
    }
}
