package com.javarush.task.task13.task1310;

/* 
CleverMan и SmartGirl
*/

public class Solution {
    public static void main(String[] args) throws Exception {
    }

    interface Person {
        void use(Person person);

        void startToWork();
    }

    interface Workable {
        boolean wantsToGetExtraWork();
    }

    interface Secretary {
    }

    interface Boss {
    }

    class CleverMan {
        public void use(Person person) {
            person.startToWork();
        }

        public void startToWork() {
        }

        public boolean wantsToGetExtraWork() {
            return true;
        }
    }

    class SmartGirl {
        public void use(Person person) {
        }

        public void startToWork() {
        }
    }
}
