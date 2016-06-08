package pl.sebcza;

import com.google.gwt.thirdparty.guava.common.collect.Lists;

import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Label;
import static pl.sebcza.MyUI.navigator;
import java.util.Collection;
import java.util.Date;

/**
 * Created by Sebastian on 08.06.2016.
 */
public class ListView extends  TemplateView {

    private Grid listNotes;
    private AbsoluteLayout layView;
    private Label label;

    public ListView() {
        layView = new AbsoluteLayout();
        layView.setHeight("100%");
        layView.setWidth("100%");


        label = new Label("List of Notes");
        label.setStyleName("h1");
        loadData();
        contentSpace.addComponent(layView);
    }

    private void loadData(){
        layView.removeAllComponents();
        listNotes = new Grid();
        listNotes.setWidth(100, Unit.PERCENTAGE);
        listNotes.addColumn("Date", String.class);
        listNotes.addColumn("Miltage", Integer.class);
        listNotes.addColumn("Comment", String.class);
        listNotes.addColumn("Capacity", Double.class);
        for (CarNote carn: CarNotesBean.GetList()){
            listNotes.addRow(carn.getNoteDate().toString(), carn.getMiltage(), carn.getComment(), carn.getPetrolCapacity());
        }
        layView.addComponent(label, "left:0px; top:0px;");
        layView.addComponent(listNotes, "left:0px; top:100px;");

    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        super.enter(viewChangeEvent);
        if(CarBean.loggedUser == null){
            navigator.navigateTo("login");
        }
        loadData();
    }
}
