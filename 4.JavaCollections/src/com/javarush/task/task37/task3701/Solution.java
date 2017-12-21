package com.javarush.task.task37.task3701;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Consumer;

/* 
Круговой итератор
*/
public class Solution<T> extends ArrayList<T> {
    public static void main(String[] args) {
        Solution<Integer> list = new Solution<>();
        list.add(1);
        list.add(2);
        list.add(3);

        int count = 0;
        for (Integer i : list) {
            //1 2 3 1 2 3 1 2 3 1
            System.out.print(i + " ");
            count++;
            if (count == 10) {
                break;
            }
        }
    }

    public class RoundIterator implements Iterator<T> {
        Iterator<T> iterator = Solution.super.iterator();
        int navigation = 0;

        @Override
        public void forEachRemaining(Consumer<? super T> action) {
            iterator.forEachRemaining(action);
        }

        @Override
        public void remove() {
            iterator.remove();
        }

        @Override
        public boolean hasNext() {
            if (size() == 0)
                return false;

            if (navigation >= size()) {
                iterator = Solution.super.iterator();
                navigation = 0;
            }

            return true;
        }

        @Override
        public T next() {
            navigation++;
            return iterator.next();
        }
    }

    public RoundIterator iterator() {
        return new RoundIterator();
    }
}
