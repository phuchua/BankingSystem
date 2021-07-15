package framework;

import framework.Storage.Storable;
import framework.Observer.Observable;
import framework.observer.Observer;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public abstract class EntityRepository<O extends Storable<K>,K> implements Observable<RepositoryEvents,O> {
    DAO<O,K> dao;
    Map<EventType, Set<Observer>> observersList = new HashMap<>();

    public Map<EventType, Set<Observer>> getObserversList(){
        return observersList;
    }

    public EntityRepository(){
        this.dao = getDao();
    }

    public abstract DAO<O,K> getDao();

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

    public final Collection<O> getAll(){
        return this.dao.getAll();
    }

}

