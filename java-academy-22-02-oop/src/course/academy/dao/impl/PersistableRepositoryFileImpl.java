package course.academy.dao.impl;

import course.academy.dao.Identifiable;

import java.io.*;
import java.util.Collection;

public class PersistableRepositoryFileImpl<K, V extends Identifiable<K>> extends AbstractPersistableRepository<K, V> {
    private String dbFileName;

    public PersistableRepositoryFileImpl(IdGenerator<K> idGenerator, String dbFileName) {
        super(idGenerator);
        this.dbFileName = dbFileName;
    }

    @Override
    public void load() {
        try (var out = new ObjectInputStream(
                new BufferedInputStream(
                        new FileInputStream(dbFileName)))) {
            var entities = (Collection<V>)out.readObject();
            for(var entity: entities) {
                create(entity);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void save() {
        try (var out = new ObjectOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(dbFileName)))) {
            out.writeObject(findAll());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
