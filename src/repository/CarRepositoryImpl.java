package repository;

import model.Car;
import utils.lists.MyArrayList;
import utils.lists.MyList;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

/*** Author: Roman Romashko Date: 18.03.2025 ***/

public class CarRepositoryImpl implements CarRepository {

    // Все машины будут храниться в памяти нашего приложения
    private final MyList<Car> cars;

    // Объект, отвечающий за генерацию уникальных id
    private final AtomicInteger currentId = new AtomicInteger(1);


    public CarRepositoryImpl() {
        this.cars = new MyArrayList<>();
        addStartCars();
    }

    private void addStartCars(){

        cars.addAll(
          new Car(currentId.getAndIncrement(),"VW Golf",  20000.00, 2021),
                new Car(currentId.getAndIncrement(),"VW Golf",  20000.00, 2019),
                new Car(currentId.getAndIncrement(),"VW Passat",  3000.00, 2016),
                new Car(currentId.getAndIncrement(),"VW Passat",  20000.00, 2020),
                new Car(currentId.getAndIncrement(),"VW Tiguan",  20000.00, 2023)


        );

    }

    @Override
    public Car addCar(String model, int year, double price) {

        // Слой репозитория не должен делать проверки. Это задача сервиса
        //if (model == null) return null;

        Car car = new Car(currentId.getAndIncrement(),model, price, year);
        cars.add(car);
        return car;

    }

    @Override
    public MyList<Car> gettAllCars() {
        return cars;
    }

    @Override
    public Car getById(int id) {
        // перебрать все машины из хранилища
        // если ид совпадут - вернуть объект кар
        // если ничего - вернуть нул

        for (Car car : cars){

            if (car.getId() == id) return car;

        }

        return null;
    }

    @Override
    public MyList<Car> getCarsByModel(String model) {

        MyList<Car> result = new MyArrayList<>();

        // перебираем список машин
        // добавить ее в резалт

        for (Car car : cars){

            if (car.getModel().equalsIgnoreCase(model)) {result.add(car);}

        }

        return null;
    }

    @Override
    public void saveCar(Car car) {

    }

    @Override
    public void deleteById(int id) {

    }
}
