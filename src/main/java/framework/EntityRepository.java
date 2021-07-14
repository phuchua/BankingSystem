package framework;

import framework.Observer.Observable;
import framework.Observer.Observer;
import framework.Storage.Storable;

import java.util.*;


public abstract class EntityRepository<O extends Storable<K>,K> implements Observable<RepositoryEvents,O> {
    DAO<O,K> dao;

    public Map<RepositoryEvents, Set<Observer>> actionListeners(){
        return new HashMap<RepositoryEvents, Set<Observer>>();
    }

    @Override
    public void notify(RepositoryEvents event,O obj ){
        if (!observersList.containsKey(event)) {
          return;
        }

        for(Observer observer : observersList.get(event)){
            observer.update(obj);
        }
    }

    public final void save(O obj){
        notify(RepositoryEvents.PRE_SAVE,obj);
        this.dao.create(obj);
        notify(RepositoryEvents.POST_SAVE,obj);
    }

    public final void update(O obj){
        notify(RepositoryEvents.PRE_UPDATE,obj);
        this.dao.update(obj);
        notify(RepositoryEvents.POST_UPDATE,obj);
    }

    public final O loadOne(K k){
        O obj = this.dao.loadOne( k);
        notify(RepositoryEvents.POST_LOAD,obj);
        return obj;
    }

    public final Collection<O> getAll(K k){
        return this.dao.getAll();
    }
}

