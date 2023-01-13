package Repository;

public interface ICrudRepository<ID,E> {
    void add(E entity);
    E remove(ID id);
    void update(E newEntity, ID id);
    E find(ID id);
}

