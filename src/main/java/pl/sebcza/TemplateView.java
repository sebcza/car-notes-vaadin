package pl.sebcza;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.VerticalLayout;

/**
 * Created by Sebastian on 07.06.2016.
 */
public class TemplateView extends VerticalLayout implements View {
    private HorizontalLayout headerSpacer;
    private VerticalLayout mainSpace;
    private MenuBar barMenu;

    public TemplateView() {
        setSizeFull();
        setDefaultComponentAlignment(Alignment.TOP_CENTER);
        setHeight(100, Unit.PERCENTAGE);

        mainSpace = new VerticalLayout();
        headerSpacer = new HorizontalLayout();
        barMenu = new MenuBar();

        mainSpace.setSizeFull();
        headerSpacer.setWidth(100, Unit.PERCENTAGE);
        headerSpacer.setHeight(150, Unit.PIXELS);

        barMenu.setWidth(100, Unit.PERCENTAGE);

        mainSpace.addComponent(headerSpacer);
        mainSpace.addComponent(barMenu);

        addComponent(mainSpace);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {

    }
}
