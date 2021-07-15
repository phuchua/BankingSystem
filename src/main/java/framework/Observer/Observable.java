package framework.Observer;

import framework.RepositoryEvents;

import java.util.*;

public interface Observable<EventType,T> {
    Map<framework.EventType, Set<Observer>> getObserversList();

    default void addObserver(Observer observer, framework.EventType repositoryEvents){
        Set<Observer> observers;

        if(getObserversList().containsKey(repositoryEvents)){
            observers = getObserversList().get(repositoryEvents);
        }

        else{
            observers = new HashSet<>();
            getObserversList().put(repositoryEvents, observers);
        }
        observers.add(observer);
    }



    default void removeObserver(Observer observer, framework.EventType event){
        Set<Observer> observers = getObserversList().get(event);

        if(observers == null){
            throw new NullPointerException();
        }

        if(observers.contains(observer)){
            observers.remove(observer);
            getObserversList().put(event, observers);
        }
    }

    void notify(EventType event,T obj);

}
