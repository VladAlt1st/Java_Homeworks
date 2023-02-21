package Homework2023_02_20.Task3;

public interface UserRepository {

    User getUserById(int id);

    void saveUser(User user);

    void deleteUser(int id);
}
