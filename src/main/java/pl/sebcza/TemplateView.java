package pl.sebcza;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.*;

import java.io.File;

/**
 * Created by Sebastian on 07.06.2016.
 */
public class TemplateView extends VerticalLayout implements View {
    private HorizontalLayout headerSpacer;
    private AbsoluteLayout mainSpace;
    private VerticalLayout contentSpace;
    private Panel menuSpace;
    private Button goToList;
    private Button gotToAddNew;
    private Button goToLogin;

    public TemplateView() {
        setSizeFull();
        setDefaultComponentAlignment(Alignment.TOP_CENTER);
        setHeight(100, Unit.PERCENTAGE);

        mainSpace = new AbsoluteLayout();
        headerSpacer = new HorizontalLayout();
        contentSpace = new VerticalLayout();
        menuSpace = new Panel("Menu");
        mainSpace.setSizeFull();
        contentSpace.setSizeFull();


        ThemeResource resource = new ThemeResource("img/logo.png");
        Image logo = new Image("", resource);
        logo.setHeight(50, Unit.PIXELS);
        logo.setWidth(50, Unit.PIXELS);
        Label label = new Label("Car notes");
        label.setStyleName("h1");

        headerSpacer.setWidth(100, Unit.PERCENTAGE);
        headerSpacer.setHeight(100, Unit.PIXELS);

        headerSpacer.addComponent(logo);
        headerSpacer.addComponent(label);





        mainSpace.addComponent(headerSpacer, "left:0px;top:0px");
        mainSpace.addComponent(menuSpace, "left:0px;top:100px");
        mainSpace.addComponent(contentSpace, "left:0px;top:200px");


        addComponent(mainSpace);
        GenerateNavigationMenu();
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        setSizeFull();
        setHeight("100%");
    }

    public void GenerateNavigationMenu(){
        HorizontalLayout horizontal = new HorizontalLayout();
        goToList = new Button("Lista");
        gotToAddNew = new Button("Dodaj nową");
        goToLogin = new Button("LogIn");

        horizontal.addComponent(goToList);
        horizontal.addComponent(gotToAddNew);
        horizontal.addComponent(goToLogin);
        menuSpace.setContent(horizontal);


    }
}
