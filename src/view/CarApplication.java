package view;

import repository.CarRepository;
import repository.CarRepositoryImpl;
import repository.UserRepository;
import repository.UserRepositoryImp;
import service.MainService;
import service.MainServiceImpl;

/*** Author: Roman Romashko Date: 18.03.2025 ***/

public class CarApplication {
    public static void main(String[] args) {

        CarRepository carRepository = new CarRepositoryImpl();
        UserRepository userRepository = new UserRepositoryImp();


        MainService service = new MainServiceImpl(carRepository,userRepository);
        Menu menu = new Menu(service);
        menu.start();
    }
}
