package com.javarush.task.task37.task3702;

import com.javarush.task.task37.task3702.male.MaleFactory;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new MaleFactory().getPerson(99));
        System.out.println(new MaleFactory().getPerson(4));
        System.out.println(new MaleFactory().getPerson(15));
    }
}
