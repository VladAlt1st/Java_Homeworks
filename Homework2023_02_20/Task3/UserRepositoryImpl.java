package Homework2023_02_20.Task3;

public class UserRepositoryImpl implements UserRepository {
    @Override
    public User getUserById(int id) {
        // connect to db and get date
        return new User(100, "Test user", true);
    }

    @Override
    public void saveUser(User user) {
        // connect to db and save date
    }

    @Override
    public void deleteUser(int id) {
        // connect to db and delete date
    }
}
