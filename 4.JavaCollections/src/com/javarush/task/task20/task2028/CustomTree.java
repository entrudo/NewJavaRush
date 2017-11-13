package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;

/* 
Построй дерево(1)
*/
public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {

    Entry<String> root = new Entry<String>(String.valueOf(0));
    public static void main(String[] args) {
        List<String> list = new CustomTree();
        for (int i = 1; i < 16; i++) {
            list.add(String.valueOf(i));
        }
        System.out.println("Expected 3, actual is " + ((CustomTree) list).getParent("8"));
        list.remove("5");
        System.out.println("Expected null, actual is " + ((CustomTree) list).getParent("11"));
    }

    public static class Entry<T> implements Serializable {

        String elementName;
        int lineNumber;
        boolean availableToAddLeftChildren, availableToAddRightChildren;
        Entry<T> parent, leftChild, rightChild;

        public Entry(String elementName) {
            this.elementName = elementName;
            this.availableToAddLeftChildren = true;
            this.availableToAddRightChildren = true;
        }

        void checkChildren() {
            if (leftChild != null)
                this.availableToAddLeftChildren = false;
            if (rightChild != null)
                this.availableToAddRightChildren = false;
        }

        boolean isAvailableToAddChildren() {
            return (availableToAddLeftChildren || availableToAddRightChildren);
        }

    }


    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean add(String s) {

        Queue<Entry<String>> queue = new LinkedList<>();
        queue.add(root);
        int levelCounter = 1;
        Entry<String> currentNode;
        Entry<String> nodeForAdd = new Entry<>(s);

        while (!queue.isEmpty()) {
            currentNode = queue.poll();
            currentNode.checkChildren();
            if (currentNode.isAvailableToAddChildren()) {
                nodeForAdd.parent = currentNode;
                if (currentNode.availableToAddLeftChildren) {
                    currentNode.leftChild = nodeForAdd;
                    return true;
                }
                if (currentNode.availableToAddRightChildren) {
                    currentNode.rightChild = nodeForAdd;
                    return true;
                }

            } else {
                queue.add(currentNode.leftChild);
                queue.add(currentNode.rightChild);
                levelCounter += 1;
            }
        }

        return false;
    }

    public boolean remove(Object string) {

        String removeStr = String.valueOf(string);
        Queue<Entry> queue = new LinkedList();

        queue.add(root);
        while (!queue.isEmpty()) {
            Entry<String> currentNode = queue.poll();
            if (currentNode.leftChild.elementName.equals(removeStr)) {
                currentNode.leftChild = null;
                return true;
            }
            if (currentNode.rightChild.elementName.equals(removeStr)) {
                currentNode.rightChild = null;
                return true;
            } else {
                queue.add(currentNode.leftChild);
                queue.add(currentNode.rightChild);
            }
        }
        return true;
    }

    public String getParent(String elmentName) {

        String parentName = null;
        Queue<Entry> queue = new LinkedList();

        queue.add(root);
        while (!queue.isEmpty()) {
            Entry<String> currentNode = queue.poll();
            if (currentNode.elementName.equals(elmentName)) {
                parentName = currentNode.parent.elementName;
            } else {
                if (currentNode.leftChild != null) {
                    queue.add(currentNode.leftChild);
                }
                if (currentNode.rightChild != null) {
                    queue.add(currentNode.rightChild);
                }
            }
        }
        return parentName;
    }


    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {
        int couner = 0;
        Queue<Entry> queue = new LinkedList();

        queue.add(root);
        while (!queue.isEmpty()) {
            Entry<String> currentNode = queue.poll();
            if (currentNode.leftChild != null) {
                couner += 1;
                queue.add(currentNode.leftChild);
            }
            if (currentNode.rightChild != null) {
                couner += 1;
                queue.add(currentNode.rightChild);
            }

        }
        return couner;
    }
}