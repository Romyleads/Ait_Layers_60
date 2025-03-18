package service;

import model.Car;
import model.User;
import repository.CarRepository;
import repository.UserRepository;
import utils.UserValidation;
import utils.lists.MyList;

/*** Author: Roman Romashko Date: 18.03.2025 ***/

public class MainServiceImpl implements MainService{

    private final CarRepository carRepository;
    private final UserRepository userRepository;

    private User activeUser;

    public MainServiceImpl(CarRepository carRepository, UserRepository userRepository) {
        this.carRepository = carRepository;
        this.userRepository = userRepository;

    }


    @Override
    public User registerUser(String email, String password) {

        /*
        1. Валидация еmail / password (если не пройдено возвращаем null)
        2. Проверить уникальность email (что пользователя с таким email еще нет
        3. Создаю нового пользователя и сохраняю его в хранилище данных
        4. Возвращаем созданного пользователя в слой view
        */

        if (!UserValidation.isEmailValid(email)){

            System.out.println("Емейл не прошел проверку!");
            return null;

        }


        if (!UserValidation.isPasswordValid(password)){

            System.out.println("Пароль не прошел проверку!");
            return null;

        }

        if (userRepository.isEmailExist(email)){

            System.out.println("Пользователь уже есть тк емейл уже есть!");
            return null;

        }


        User user = userRepository.addUser(email,password);
        return user;
    }

    @Override
    public boolean loginUser(String email, String password) {

        /*
        Получить из хранилища пользователя с таким email
        Если такого нет - закончить метод false

        Проверить, совпадает ли у пользователя пароль из БД с паролем, в который пришел метод

        Если совпадает - пользователь залогинился.
         */

        User user = userRepository.getUserByEmail(email);
        if (user == null) return false;

        if (user.getPassword().equals(password)) {
            activeUser = user; // Исправлено
            return true;}

        return false;
    }

    @Override
    public void logout() {
        activeUser = null;

    }

    @Override
    public boolean takeCar(int carId) {
        return false;
    }

    @Override
    public Car addCar(String model, int year, double price) {
        return null;
    }

    @Override
    public MyList<Car> getAllCars() {
        return null;
    }

    @Override
    public MyList<Car> gerCarsByModel(String model) {
        return null;
    }

    @Override
    public MyList<Car> getFreeCars() {
        return null;
    }

    @Override
    public void deleteCar(int carId) {

    }

    @Override
    public void logoutUser() {

    }

    public User getActiveUser(){

        return activeUser;

    }
}
