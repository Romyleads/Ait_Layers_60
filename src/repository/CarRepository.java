package repository;

import model.Car;
import utils.lists.MyList;

/*** Author: Roman Romashko Date: 17.03.2025 ***/

    /*
    CRUD - операции
    Create (создание) - добавление новых данных (новые объекты сущностей)
    Read (чтение) - получение данных из хранилища
    Update (обновление) - изменение существующих данных
    Delete (удаление) - удаление объекта
     */

public interface CarRepository {

    // Create - add
    Car addCar(String model, int year, double price);

    // Read

    // получить список всех машин

    MyList<Car> gettAllCars();

    // получение сущности по id
    Car getById(int id);

    // Получить список только свободных машин

    // получить список машин по модели
    MyList<Car> getCarsByModel(String model);

    // Update
    // Сохранить обновленный объект
    void saveCar(Car car);

    // Delete
    void deleteById(int id);



}
