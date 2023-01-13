package Controller;

import Model.User;
import Repository.IUserRepository;
import Repository.InMemoryRepository.UserMemoryRepository;

import java.util.List;

public class UserController {
    IUserRepository userRepo = new UserMemoryRepository();

    public UserController(List<User> users) {
        for (User user : users)
            userRepo.add(user);
    }

    public List<User> getUsers() {
        return userRepo.getAll();
    }

    public boolean FindUser(String firstname, String lastname){
        User u = userRepo.findByName(firstname, lastname);
        return u.getFirstName().equals(firstname)&& u.getLastName().equals(lastname);
    }

    public User FindUserByIDAndPassword(String id, String password){
        return userRepo.findByIDAndPassword(id, password);
    }
}
