package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        
        ArrayList<String> list = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        for (int i = 0; i < 10; i++){
            String temp = reader.readLine();
            list.add(temp);
        }
        
        int smallItem = list.get(0).length();
        int bigItem = list.get(0).length();
    
        for (String s : list){
            if (s.length() < smallItem) {
                smallItem = s.length();
            } else if (s.length() > bigItem) {
                bigItem = s.length();
            }
        }
        
        for (String s : list){
            if (s.length() == smallItem) {
                System.out.println(s);
                return;
            } else if (s.length() == bigItem) {
                System.out.println(s);
                return;
            }
        }

        
    }
}
