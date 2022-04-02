package course.academy.dao.impl;

import course.academy.dao.IdGenerator;
import course.academy.dao.Identifiable;
import course.academy.dao.PersistableRepository;
import course.academy.exception.NonexistingEntityException;

import java.util.*;

public abstract class AbstractPersistableRepository<K,V extends Identifiable<K>>
        implements PersistableRepository<K,V> {
    private Map<K, V> books = new HashMap<>(); // O(1) find by ID
    private IdGenerator<K> idGenerator;

    public AbstractPersistableRepository(IdGenerator<K> idGenerator) {
        this.idGenerator = idGenerator;
    }

    @Override
    public Collection<V> findAll() {
        return books.values();
    }

    @Override
    public List<V> findAllSorted(Comparator<V> comparator) { //O(N* log N) => O(1)
        var sorted = new ArrayList<>(books.values());
        sorted.sort(comparator);
        return sorted;
    }

    @Override
    public V findById(K id) {
        return books.get(id);
    }

//    @Override
//    public V findById(K id, Class<V> cls) {
//        try {
//            var field = cls.getDeclaredField("id");
//            field.setAccessible(true);
//            System.out.println(">>> private ID = " + field.get((V) books.get(id)));
//            var ctor = cls.getConstructor();
//            V obj = ctor.newInstance();
//            if (cls.isInstance(obj)) {
//                System.out.println(">>>> Is instance of " + cls.getSimpleName());
//            }
//        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
//            e.printStackTrace();
//        } catch (NoSuchFieldException e) {
//            e.printStackTrace();
//        }
//        return books.get(id);
//    }

    @Override
    public V create(V entity) {
        entity.setId(idGenerator.getNextId());
        books.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public void addAll(Collection<V> entities) {
        for(var entity: entities) {
            books.put(entity.getId(), entity);
        }
    }

    @Override
    public void clear() {
        books.clear();
    }

    @Override
    public V update(V entity) throws NonexistingEntityException {
        V old = findById(entity.getId());
        if(old == null) {
            throw new NonexistingEntityException("Book with ID='" + entity.getId() + "' does not exist.");
        }
        books.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public V deleteById(K id) throws NonexistingEntityException {
        V old = books.remove(id);
        if(old == null) {
            throw new NonexistingEntityException("Book with ID='" + id + "' does not exist.");
        }
        return old;
    }

    @Override
    public long count() {
        return books.size();
    }

    public IdGenerator<K> getIdGenerator() {
        return idGenerator;
    }

    public void setIdGenerator(IdGenerator<K> idGenerator) {
        this.idGenerator = idGenerator;
    }
}










