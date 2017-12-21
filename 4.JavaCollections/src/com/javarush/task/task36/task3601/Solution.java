package com.javarush.task.task36.task3601;

/*
MVC - простая версия
*/
public class Solution {
    public static void main(String[] args) {
        View view = new View();
        view.fireEventShowData();
//        new Solution().fireEventShowData();
    }

//    public List<String> getData() {
//        List<String> data = new ArrayList<String>() {{
//            add("First string");
//            add("Second string");
//            add("Third string");
//        }};
//        return data;
//    }

//    public void fireEventShowData() {
//        System.out.println(onDataListShow());
//    }

//    public List<String> getStringDataList() {
//        return getData();
//    }

//    public List<String> onDataListShow() {
//        return getStringDataList();
//    }
}
