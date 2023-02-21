package Homework2023_02_20.Task3;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    private UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public boolean isActive(int id){
        User user = repository.getUserById(id);
        return user.isActive();
    }

    public void deactivate(int id){
        User user = repository.getUserById(id);
        user.setActive(false);
        repository.saveUser(user);
    }

    public void deleteInactive(List<User> users){
        for (User user : users) {
            if (!user.isActive()) {
                repository.deleteUser(user.getId());
            }
        }
    }
    //В классе UserService (см. код занятия в репозитории) реализовать метод public void deleteInactive(List users),
    //который будет удалять с помощью метода UserRepository deleteUser(int id) из БД всех неактивных пользователей из списка.
    //Составить тест на данный метод с применением Mockito.
}

/*
import org.junit.jupiter.api.BeforeEach;
        import org.junit.jupiter.api.Test;
        import org.mockito.Mockito;

        import java.util.ArrayList;
        import java.util.List;

        import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    private static UserService service;
    private static UserRepository repository;
    private static List<User> users;

    @BeforeEach
    public void init() {
        repository = Mockito.mock(UserRepository.class);
        service = new UserService(repository);
        users = List.of(
                new User(1, "Test user 1", true),
                new User(2, "Test user 2", false),
                new User(3, "Test user 3", false),
                new User(4, "Test user 4", true)
        );
    }

    @Test
    void deleteInactive() {
        service.deleteInactive(users);
        Mockito.verify(repository, Mockito.times(1)).deleteUser(2);
        Mockito.verify(repository, Mockito.times(1)).deleteUser(3);
        users = null;
        assertThrows(NullPointerException.class, () -> service.deleteInactive(users));
        users = new ArrayList<>();
        users.add(new User(1, "Test user 1", true));
        users.add(new User(2, "Test user 2", false));
        users.add(null);
        assertThrows(NullPointerException.class, () -> service.deleteInactive(users));
    }
}*/
