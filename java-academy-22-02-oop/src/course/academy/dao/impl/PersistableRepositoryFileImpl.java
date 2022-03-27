package course.academy.dao.impl;

import course.academy.dao.IdGenerator;
import course.academy.dao.Identifiable;
import course.academy.dao.LongIdGenerator;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;

public class PersistableRepositoryFileImpl<K, V extends Identifiable<K>> extends AbstractPersistableRepository<K, V> {
    private String dbFileName;

    public PersistableRepositoryFileImpl(IdGenerator<K> idGenerator, String dbFileName) {
        super(idGenerator);
        this.dbFileName = dbFileName;
    }

    @Override
    public void load() {
        try (var in = new ObjectInputStream(
                new BufferedInputStream(
                        new FileInputStream(dbFileName)))) {
            clear();
            getIdGenerator().reset((K) in.readObject());
            addAll((Collection<V>)in.readObject());
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
            out.writeObject(getIdGenerator().getCurrentId());
            out.writeObject(new ArrayList(findAll()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
