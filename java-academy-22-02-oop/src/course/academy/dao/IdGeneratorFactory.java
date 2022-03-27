package course.academy.dao;

public interface IdGeneratorFactory<K> {
    IdGenerator<K> createIdGenerator(Class<K> idClass);
}
