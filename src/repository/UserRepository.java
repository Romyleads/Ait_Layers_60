package repository;

import model.User;

/*** Author: Roman Romashko Date: 17.03.2025 ***/

public interface UserRepository {

    /*
    CRUD - операции
    Create (создание) - добавление новых данных (новые объекты сущностей)
    Read (чтение) - получение данных из хранилища
    Update (обновление) - изменение существующих данных
    Delete (удаление) - удаление объекта
     */

    User addUser(String email, String password);
    boolean isEmailExist(String email);

    User getUserByEmail(String email);

    // Update
    boolean updatePassword(String email, String newPassword);




}
