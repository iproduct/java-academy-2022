package course.academy.dao.impl;

import course.academy.dao.Identifiable;

public class PersistableRepositoryFileImpl<K,V extends Identifiable<K>> extends AbstractPersistableRepository<K,V>{
    public PersistableRepositoryFileImpl(IdGenerator<K> idGenerator) {
        super(idGenerator);
    }

    @Override
    public void load() {

    }

    @Override
    public void save() {

    }
}
