package course.academy.dao;

public interface PersistableRepository<K, V extends Identifiable<K>> extends Repository<K,V>, Persistable {
}
