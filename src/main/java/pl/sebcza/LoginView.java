package pl.sebcza;

import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;

import java.util.Date;

import static pl.sebcza.MyUI.navigator;

/**
 * Created by Sebastian on 08.06.2016.
 */
public class LoginView extends  TemplateView {

    private FormLayout form;
    private TextField login;
    private PasswordField password;
    private Button submit;

    public LoginView() {
         form = new FormLayout();

        login = new TextField("Login");

        password = new PasswordField("Hasło");

        submit = new Button("LogIn");
        submit.setDisableOnClick(true);

        form.addComponent(login);
        form.addComponent(password);
        form.addComponent(submit);

        form.setWidth(100, Unit.PERCENTAGE);


        submit.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                Car logged = CarBean.logIn(login.getValue(), password.getValue());
                if(logged == null){
                    CarBean.loggedUser = null;
                    Label errormsg = new Label("Złe hasło lub login");
                    form.addComponent(errormsg);
                }
                else{
                    CarBean.loggedUser = logged;
                    navigator.navigateTo("");
                }


            }
        });



        contentSpace.addComponent(form);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        super.enter(viewChangeEvent);
        password.setValue("");
        login.setValue("");
        submit.setEnabled(true);
    }
}
