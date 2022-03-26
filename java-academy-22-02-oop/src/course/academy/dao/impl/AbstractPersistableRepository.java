package course.academy.dao.impl;

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
    public V create(V book) {
        book.setId(idGenerator.getNextId());
        books.put(book.getId(), book);
        return book;
    }

    @Override
    public V update(V book) throws NonexistingEntityException {
        V old = findById(book.getId());
        if(old == null) {
            throw new NonexistingEntityException("Book with ID='" + book.getId() + "' does not exist.");
        }
        books.put(book.getId(), book);
        return book;
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
}










