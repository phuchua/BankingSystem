package framework.Observer;

import framework.RepositoryEvents;

import java.util.*;

public interface Observable<EventType,T> {
    Map<framework.EventType, Set<Observer>> observersList = new HashMap<>();

    default void addObserver(Observer observer, framework.EventType repositoryEvents){
        Set<Observer> observers;

        if(observersList.containsKey(repositoryEvents)){
            observers = observersList.get(repositoryEvents);
        }

        else{
            observers = new HashSet<>();
            observersList.put(repositoryEvents, observers);
        }
        observers.add(observer);
    }

    default void removeObserver(Observer observer, framework.EventType event){
        Set<Observer> observers = observersList.get(event);

        if(observers == null){
            throw new NullPointerException();
        }

        if(observers.contains(observer)){
            observers.remove(observer);
            observersList.put(event, observers);
        }
    }

    void notify(EventType event,T obj);

}
