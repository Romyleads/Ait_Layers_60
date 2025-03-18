package model;

import utils.lists.MyArrayList;
import utils.lists.MyList;

import java.util.Objects;

/*** Author: Roman Romashko Date: 17.03.2025 ***/

public class User {

    private String email;
    private String password;
    private final MyList<Car> userCars;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
        userCars = new MyArrayList<>();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof User)) return false;

        User user = (User) o;
        return Objects.equals(email, user.email) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(email);
        result = 31 * result + Objects.hashCode(password);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", userCars=" + userCars.size() +
                '}';
    }

    public MyList<Car> getUserCars() {
        return userCars;
    }


}
