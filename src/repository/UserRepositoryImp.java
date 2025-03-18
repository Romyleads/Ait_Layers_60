package repository;

import model.User;
import utils.lists.MyArrayList;
import utils.lists.MyList;

/*** Author: Roman Romashko Date: 18.03.2025 ***/

public class UserRepositoryImp implements UserRepository {

    private final MyList<User> users;

    // public UserRepositoryImp(MyList<User> users) {
    // this.users = users;
    // }

    public UserRepositoryImp() {
        users = new MyArrayList<>();
        addUsers();

    }

    private void addUsers() {

        User admin = new User("1", "1");
        // Todo добавить роль админа


        User user = new User("2", "2");
        // Todo добавить роль юзера

        users.addAll(admin, user);

    }


    @Override
    public User addUser(String email, String password) {

        // валидация - емейл и пароль будут провалиированы в сервисе
        User user = new User(email, password);
        users.add(user);
        return user;
    }

    public boolean isEmailExist(String email) {
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    public User getUserByEmail(String email) {
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public boolean updatePassword(String email, String newPassword) {


        return false;
    }
}
