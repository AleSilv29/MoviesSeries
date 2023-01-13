package Repository;

import Model.User;

import java.util.List;

public interface IUserRepository extends ICrudRepository<Integer, User>{
    User remove(String id);

    User find(String id);

    User findByName(String firstName, String lastName);

    User findByIDAndPassword(String id, String password);


    List<User> getAll();
}
