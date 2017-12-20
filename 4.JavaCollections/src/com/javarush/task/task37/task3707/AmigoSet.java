package com.javarush.task.task37.task3707;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

public class AmigoSet<E> extends AbstractSet implements Serializable, Cloneable, Set {

    private static final Object PRESENT = new Object();

    private transient HashMap<E, Object> map;

    AmigoSet() {
        map = new HashMap<>();
    }

    AmigoSet(Collection<? extends E> collection) {
        int capacity = Math.max(16, (int) (collection.size() / .75f + 1));
        map = new HashMap<>(capacity);
        this.addAll(collection);
    }


    @Override
    public boolean add(Object o) {
        Object obj = map.put((E) o, PRESENT);
        return obj == null;
    }

    @Override
    public Iterator iterator() {
        return map.keySet().iterator();
    }

    @Override
    public int size() {
        return map.size();
    }

    /*
* boolean isEmpty()
* boolean contains(Object o)
* void clear()
* boolean remove(Object o)
     */

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean contains(Object object) {
        return super.contains(object);
    }

    @Override
    public boolean remove(Object object) {
        return super.remove(object);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public Object clone() {
        try {
            AmigoSet<E> cloneSet = new AmigoSet<>(this);
            cloneSet.map = (HashMap<E, Object>) map.clone();
            return cloneSet;
        } catch (Exception e) {
            throw new InternalError(e);
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {

        /*
Для сериализации:
* сериализуй сет
* сериализуй capacity и loadFactor у объекта map, они понадобятся для десериализации.
Т.к. эти данные ограничены пакетом, то воспользуйся утилитным классом HashMapReflectionHelper, чтобы достать их.
        */
        objectOutputStream.defaultWriteObject();
        int capacity = HashMapReflectionHelper.callHiddenMethod(map, "capacity");
        float loadFactor = HashMapReflectionHelper.callHiddenMethod(map, "loadFactor");
        int size = map.size();
        objectOutputStream.writeInt(capacity);
        objectOutputStream.writeFloat(loadFactor);
        objectOutputStream.writeInt(size);
        Set<E> set = map.keySet();
        for (E element : set) {
            objectOutputStream.writeObject(element);
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int capacity = objectInputStream.readInt();
        float loadFactor = objectInputStream.readFloat();
        int size = objectInputStream.readInt();
        map = new HashMap<>(capacity, loadFactor);
        for (int i = 0; i < size; i++) {
            map.put((E) objectInputStream.readObject(), PRESENT);
        }
    }

}
