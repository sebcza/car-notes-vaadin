package pl.sebcza;

import com.google.gwt.thirdparty.guava.common.collect.Lists;

import java.util.ArrayList;

/**
 * Created by Sebastian on 08.06.2016.
 */
public class CarBean {
    public static Car loggedUser = null;
    private static ArrayList<Car> carList = new ArrayList<>(Lists.newArrayList(
            new Car("wci5et", "tajne"),
            new Car("gda01", "haslo")
    ));

    public static Car logIn(String logIn, String pass){
        for (Car c:carList){
            if(c.getRegistrationNumber()==logIn && c.getPassword()==pass){
                return c;
            }
        }
        return null;
    }

}
class Car {
    public Car(String registrationNumber, String password) {
        this.registrationNumber = registrationNumber;
        this.password = password;
    }

    private String registrationNumber;
    private String password;

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
