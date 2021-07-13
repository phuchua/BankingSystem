package framework;

import java.util.*;

public abstract class EntityRepository<O extends Storable<K>,K> {
    DAO<O,K> dao;

    public Map<RepositoryEvents, Set<Observer>> actionListeners(){
        return new HashMap<RepositoryEvents,Set<Observer>>();
    }

    private void updateEventListeners(RepositoryEvents E,O obj){

    }

    public final void save(O obj){
        updateEventListeners(RepositoryEvents.PRE_SAVE,obj);
        this.dao.create(obj);
        updateEventListeners(RepositoryEvents.POST_SAVE,obj);
    }
}
