package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream("File.txt");
            InputStream inputStream = new FileInputStream("File.txt");

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User user = new User();
            user.setFirstName("Ivan");
            user.setLastName("Ivanov");
            Date birthDay = new SimpleDateFormat( "dd.MM.yyyy" ).parse("13.02.1988");
            user.setBirthDate(birthDay);
            user.setMale(true);
            user.setCountry(User.Country.UKRAINE);
            javaRush.users.add(user);
            User user2 = new User();
            user2.setFirstName("Ivan");
            user2.setLastName("Ivanov");
            Date birthDay2 = new SimpleDateFormat( "dd.MM.yyyy" ).parse("13.02.1988");
            user2.setBirthDate(birthDay2);
            user2.setMale(true);
            user2.setCountry(User.Country.UKRAINE);
            javaRush.users.add(user2);

            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны
            boolean result = javaRush.equals(loadedObject);
            System.out.println(result);
            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
//            e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
//            e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter printWriter = new PrintWriter(outputStream);
            String isPresentUsers = users != null ? "yes" : "no";
            printWriter.println(isPresentUsers);
            if (users != null) {
                for (User user : users) {
                    printWriter.println("yes");
                    printWriter.println(user.getFirstName());
                    printWriter.println(user.getLastName());
                    printWriter.println(user.getBirthDate());
                    printWriter.println(user.isMale());
                    printWriter.println(user.getCountry());
                }
            }
            printWriter.flush();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String isUserPresent = reader.readLine();
            if (isUserPresent.equals("yes")) {

                while (reader.ready()) {
                    User user = new User();
                    if (reader.readLine().equals("yes")) {
                        user.setFirstName(reader.readLine());
                        user.setLastName(reader.readLine());
                        user.setBirthDate(new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy").parse
                                (reader.readLine()));
                        user.setMale(reader.readLine().equals("true"));
                        switch (reader.readLine()) {
                            case ("UKRAINE"): {
                                user.setCountry(User.Country.UKRAINE);
                                break;
                            }
                            case ("RUSSIA"): {
                                user.setCountry(User.Country.RUSSIA);
                                break;
                            }
                            case ("OTHER"): {
                                user.setCountry(User.Country.OTHER);
                                break;
                            }
                        }
                        users.add(user);
                    }
                }

            }

        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
