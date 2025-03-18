package service;

import model.Car;
import model.User;
import repository.CarRepository;
import repository.UserRepository;
import utils.lists.MyList;

import java.net.CacheRequest;

/*** Author: Roman Romashko Date: 17.03.2025 ***/

public interface MainService {






    User registerUser(String email, String password);

    boolean loginUser(String email, String password);

    void logout();

    boolean takeCar(int carId);

    Car addCar(String model, int year, double price);

    MyList<Car> getAllCars();

    MyList<Car> gerCarsByModel(String model);

    MyList<Car> getFreeCars();

    void deleteCar(int carId);

    public void logoutUser();

    User getActiveUser();




}
