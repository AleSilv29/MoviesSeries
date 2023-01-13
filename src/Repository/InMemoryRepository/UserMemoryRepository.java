package Repository.InMemoryRepository;

import Model.User;
import Repository.IUserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserMemoryRepository implements IUserRepository {
    private List<User> allUsers = new ArrayList<>();


    @Override
    public void add(User u) {
        allUsers.add((User) u);
    }

    @Override
    public User remove(Integer integer) {
        return null;
    }

    @Override
    public User remove(String id) {
        allUsers.removeIf(u -> u.getId().equals(id));
        return null;
    }

    @Override
    public void update(User newEntity, Integer id) {
        newEntity.setId(id);

    }

    @Override
    public User find(Integer integer) {
        return null;
    }

    @Override
    public User find(String id) {
        for (User u : allUsers) {
            if (u.getId().equals(id))
                return u;
        }
        return null;
    }

    @Override
    public User findByName(String firstName, String lastName) {
        for (User u : allUsers) {
            if (Objects.equals(u.getFirstName(), firstName) && Objects.equals(u.getLastName(), lastName))
                return u;
        }
        return null;
    }

    @Override
    public User findByIDAndPassword(String id, String password) {
        for (User u : allUsers) {
            if (Objects.equals(u.getId(), id) && Objects.equals(u.getPassword(), password))
                return u;
        }
        return null;
    }

    @Override
    public List<User> getAll() {
        return new ArrayList<>(allUsers);
    }
}
