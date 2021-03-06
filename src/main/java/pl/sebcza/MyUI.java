package pl.sebcza;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
@Widgetset("pl.sebcza.MyAppWidgetset")
public class MyUI extends UI {
    protected static final String ADDVIEW = "add";
    static Navigator navigator;
    @Override
    protected void init(VaadinRequest vaadinRequest) {
        getPage().setTitle("Sebastian Czarnecki - CarNotes in Vaadin");

        navigator = new Navigator(this, this);
        navigator.addView("", new ListView());
        navigator.addView(ADDVIEW, new AddView());
        navigator.addView("login", new LoginView());
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(widgetset = "pl.sebcza.MyAppWidgetset", ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
