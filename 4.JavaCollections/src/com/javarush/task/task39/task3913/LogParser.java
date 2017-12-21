package com.javarush.task.task39.task3913;

import com.javarush.task.task39.task3913.query.*;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogParser implements IPQuery, UserQuery, DateQuery, EventQuery, QLQuery {

    private Path logDir;
    private List<String> linesList;

    public LogParser(Path logDir) {
        this.logDir = logDir;
        linesList = getLinesList();
    }

    private List<String> getLinesList() {
        String[] files = logDir.toFile().list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".log");
            }
        });

        List<String> lines = new ArrayList<>();
        for (String file : files) {
            try {
                lines.addAll(Files.readAllLines(Paths.get(logDir + File.separator + file), Charset.defaultCharset()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return lines;
    }

    private void addStringEntity(Date after, Date before, Set<String> enteties, String[] parts, int part) {
        long lineDateTime = getDate(parts[2]).getTime();

        if (isCompatibleDate(lineDateTime, after, before)) {
            enteties.add(parts[part]);
        }
    }

    private void addDateEntity(Date after, Date before, Set<Date> enteties, String[] parts) {
        Date lineDate = getDate(parts[2]);
        long lineDateTime = getDate(parts[2]).getTime();

        if (isCompatibleDate(lineDateTime, after, before)) {
            enteties.add(lineDate);
        }
    }

    private void addEventEntity(Date after, Date before, Set<Event> enteties, String[] parts) {
        Event lineEvent = Event.valueOf(parts[3].split(" ")[0]);
        long lineDateTime = getDate(parts[2]).getTime();

        if (isCompatibleDate(lineDateTime, after, before)) {
            enteties.add(lineEvent);
        }
    }

    private boolean isCompatibleDate(long lineDateTime, Date after, Date before) {
        if (after == null && before == null) {
            return true;
        } else if (after == null) {
            if (lineDateTime <= before.getTime()) {
                return true;
            }
        } else if (before == null) {
            if (lineDateTime >= after.getTime()) {
                return true;
            }
        } else {
            if (lineDateTime >= after.getTime() && lineDateTime <= before.getTime()) {
                return true;
            }
        }
        return false;
    }

    private Date getDate(String part) {
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.ENGLISH);
        Date date = null;
        try {
            date = dateFormat.parse(part);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    @Override
    public int getNumberOfUniqueIPs(Date after, Date before) {
        return getUniqueIPs(after, before).size();
    }

    @Override
    public Set<String> getUniqueIPs(Date after, Date before) {
        Set<String> uniqueIPs = new HashSet<>();

        for (String line : linesList) {
            String[] parts = line.split("\\t");

            addStringEntity(after, before, uniqueIPs, parts, 0);
        }
        return uniqueIPs;
    }

    @Override
    public Set<String> getIPsForUser(String user, Date after, Date before) {
        Set<String> IPsForUser = new HashSet<>();

        for (String line : linesList) {
            String[] parts = line.split("\\t");

            if (user.equals(parts[1])) {
                addStringEntity(after, before, IPsForUser, parts, 0);
            }
        }
        return IPsForUser;
    }

    @Override
    public Set<String> getIPsForEvent(Event event, Date after, Date before) {
        Set<String> IPsForEvent = new HashSet<>();

        for (String line : linesList) {
            String[] parts = line.split("\\t");

            if (event.toString().equals(parts[3].split(" ")[0])) {
                addStringEntity(after, before, IPsForEvent, parts, 0);
            }
        }
        return IPsForEvent;
    }

    @Override
    public Set<String> getIPsForStatus(Status status, Date after, Date before) {
        Set<String> IPsForEvent = new HashSet<>();

        for (String line : linesList) {
            String[] parts = line.split("\\t");

            if (status.toString().equals(parts[4])) {
                addStringEntity(after, before, IPsForEvent, parts, 0);
            }
        }
        return IPsForEvent;
    }

    @Override
    public Set<String> getAllUsers() {
        Set<String> users = new HashSet<>();
        for (String line : linesList) {
            String[] parts = line.split("\\t");
            if (!users.contains(parts[1]))
                users.add(parts[1]);
        }
        return users;
    }

    @Override
    public int getNumberOfUserEvents(String user, Date after, Date before) {

        Set<String> userEvents = new HashSet<>();

        for (String line : linesList) {
            String[] parts = line.split("\\t");

            if (user.equals(parts[1])) {
                addStringEntity(after, before, userEvents, parts, 3);
            }
        }
        return userEvents.size();
    }

    @Override
    public Set<String> getUsersForIP(String ip, Date after, Date before) {
        Set<String> users = new HashSet<>();
        for (String line : linesList) {
            String[] parts = line.split("\\t");

            if (ip.equals(parts[0]) && !users.contains(parts[1])) {
                addStringEntity(after, before, users, parts, 1);
            }
        }
        return users;
    }

    @Override
    public int getNumberOfUsers(Date after, Date before) {
        Set<String> users = new HashSet<>();
        for (String line : linesList) {
            String[] parts = line.split("\\t");
            if (!users.contains(parts[1]))
                addStringEntity(after, before, users, parts, 1);
        }
        return users.size();
    }

    @Override
    public Set<String> getLoggedUsers(Date after, Date before) {
        Set<String> loggedUsers = new HashSet<>();

        for (String line : linesList) {
            String[] parts = line.split("\\t");

            if (Event.LOGIN.toString().equals(parts[3])) {
                addStringEntity(after, before, loggedUsers, parts, 1);
            }
        }
        return loggedUsers;
    }

    @Override
    public Set<String> getDownloadedPluginUsers(Date after, Date before) {
        Set<String> users = new HashSet<>();
        for (String line : linesList) {
            String[] parts = line.split("\\t");
            if (parts[3].equals(Event.DOWNLOAD_PLUGIN.toString()))
                addStringEntity(after, before, users, parts, 1);
        }
        return users;
    }

    @Override
    public Set<String> getWroteMessageUsers(Date after, Date before) {
        Set<String> users = new HashSet<>();
        for (String line : linesList) {
            String[] parts = line.split("\\t");
            if (parts[3].equals(Event.WRITE_MESSAGE.toString()))
                addStringEntity(after, before, users, parts, 1);
        }
        return users;
    }


    /**
     * 2.1. Метод getAllUsers() должен возвращать всех пользователей.
     * ?2.2. Метод getNumberOfUsers() должен возвращать количество уникальных пользователей.
     * 2.3. Метод getNumberOfUserEvents() должен возвращать количество событий от определенного пользователя.
     * 2.4. Метод getUsersForIP() должен возвращать пользователей с определенным IP.
     * Несколько пользователей могут использовать один и тот же IP.
     * 2.5. Метод getLoggedUsers() должен возвращать пользователей, которые были залогинены.
     * 2.6. Метод getDownloadedPluginUsers() должен возвращать пользователей, которые скачали плагин.
     * 2.7. Метод getWroteMessageUsers() должен возвращать пользователей, которые отправили сообщение.
     * 2.8. Метод getSolvedTaskUsers(Date after, Date before) должен возвращать пользователей, которые решали любую задачу.
     * 2.9. Метод getSolvedTaskUsers(Date after, Date before, int task) должен возвращать пользователей, которые решали задачу с номером task.
     * 2.10. Метод getDoneTaskUsers(Date after, Date before) должен возвращать пользователей, которые решали любую задачу.
     * 2.11. Метод getDoneTaskUsers(Date after, Date before, int task) должен возвращать пользователей, которые решали задачу с номером task.
     */

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before) {
        Set<String> users = new HashSet<>();
        for (String line : linesList) {
            String[] parts = line.split("\\t");
            if (parts[3].split(" ")[0].equals(Event.SOLVE_TASK.toString()))
                addStringEntity(after, before, users, parts, 1);
        }
        return users;
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before, int task) {
        Set<String> users = new HashSet<>();
        for (String line : linesList) {
            String[] parts = line.split("\\t");
            if (parts[3].split(" ")[0].equals(Event.SOLVE_TASK.toString()) && Integer.parseInt(parts[3].split(" ")[1]) == task)
                addStringEntity(after, before, users, parts, 1);
        }
        return users;
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before) {
        Set<String> users = new HashSet<>();
        for (String line : linesList) {
            String[] parts = line.split("\\t");
            if (parts[3].split(" ")[0].equals(Event.DONE_TASK.toString()))
                addStringEntity(after, before, users, parts, 1);
        }
        return users;
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before, int task) {

        Set<String> users = new HashSet<>();
        for (String line : linesList) {
            String[] parts = line.split("\\t");
            if (parts[3].split(" ")[0].equals(Event.DONE_TASK.toString()) && Integer.parseInt(parts[3].split(" ")[1]) == task)
                addStringEntity(after, before, users, parts, 1);
        }
        return users;
    }

    /**
     * 3.1. Метод getDatesForUserAndEvent() должен возвращать даты, когда определенный пользователь произвел определенное событие.
     * 3.2. Метод getDatesWhenSomethingFailed() должен возвращать даты, когда любое событие не выполнилось (статус FAILED).
     * 3.3. Метод getDatesWhenErrorHappened() должен возвращать даты, когда любое событие закончилось ошибкой (статус ERROR).
     * 3.4. Метод getDateWhenUserLoggedFirstTime() должен возвращать дату, когда пользователь залогинился впервые за указанный период.
     * Если такой даты в логах нет - null.
     * 3.5. Метод getDateWhenUserSolvedTask() должен возвращать дату, когда пользователь впервые попытался решить определенную задачу.
     * Если такой даты в логах нет - null.
     * 3.6. Метод getDateWhenUserDoneTask() должен возвращать дату, когда пользователь впервые решил определенную задачу. Если такой даты в логах нет - null.
     * 3.7. Метод getDatesWhenUserWroteMessage() должен возвращать даты, когда пользователь написал сообщение.
     * 3.8. Метод getDatesWhenUserDownloadedPlugin() должен возвращать даты, когда пользователь скачал плагин.
     */
    @Override
    public Set<Date> getDatesForUserAndEvent(String user, Event event, Date after, Date before) {
        Set<Date> dates = new HashSet<>();
        for (String line : linesList) {
            String[] parts = line.split("\\t");

            if (parts[1].equals(user) && parts[3].split(" ")[0].equals(event.toString()) && !dates.contains(getDate(parts[2]).getTime()))
                addDateEntity(after, before, dates, parts);
        }
        return dates;
    }

    @Override
    public Set<Date> getDatesWhenSomethingFailed(Date after, Date before) {
        Set<Date> dates = new HashSet<>();
        for (String line : linesList) {
            String[] parts = line.split("\\t");

            if (parts[4].equals(Status.FAILED.toString()))
                addDateEntity(after, before, dates, parts);
        }
        return dates;
    }

    @Override
    public Set<Date> getDatesWhenErrorHappened(Date after, Date before) {
        Set<Date> dates = new HashSet<>();
        for (String line : linesList) {
            String[] parts = line.split("\\t");

            if (parts[4].equals(Status.ERROR.toString()))
                addDateEntity(after, before, dates, parts);
        }
        return dates;
    }

    @Override
    public Date getDateWhenUserLoggedFirstTime(String user, Date after, Date before) {
        Date dateWhenUserLoggedFirstTime = new Date(Long.MAX_VALUE);
        boolean isDateChanged = false;
        for (String line : linesList) {
            String[] parts = line.split("\\t");
            if (user.equals(parts[1]) && Event.LOGIN.toString().equals(parts[3])) {
                if (getDate(parts[2]).getTime() < dateWhenUserLoggedFirstTime.getTime() && isCompatibleDate(getDate(parts[2]).getTime(), after, before)) {
                    dateWhenUserLoggedFirstTime = getDate(parts[2]);
                    isDateChanged = true;
                }
            }
        }
        return isDateChanged ? dateWhenUserLoggedFirstTime : null;
    }

    @Override
    public Date getDateWhenUserSolvedTask(String user, int task, Date after, Date before) {
        Date dateWhenUserSolvedTaskFirstTime = new Date(Long.MAX_VALUE);
        boolean isDateChanged = false;
        for (String line : linesList) {
            String[] parts = line.split("\\t");
            if (user.equals(parts[1])
                    && Event.SOLVE_TASK.toString().equals(parts[3].split(" ")[0])
                    && Integer.parseInt(parts[3].split(" ")[1]) == task) {
                if (getDate(parts[2]).getTime() < dateWhenUserSolvedTaskFirstTime.getTime() && isCompatibleDate(getDate(parts[2]).getTime(), after, before)) {
                    dateWhenUserSolvedTaskFirstTime = getDate(parts[2]);
                    isDateChanged = true;
                }
            }
        }
        return isDateChanged ? dateWhenUserSolvedTaskFirstTime : null;
    }

    @Override
    public Date getDateWhenUserDoneTask(String user, int task, Date after, Date before) {
        Date dateWhenUserDoneTaskFirstTime = new Date(Long.MAX_VALUE);
        boolean isDateChanged = false;
        for (String line : linesList) {
            String[] parts = line.split("\\t");
            if (user.equals(parts[1]) && Event.DONE_TASK.toString().equals(parts[3].split(" ")[0])
                    && Integer.parseInt(parts[3].split(" ")[1]) == task) {

                if (getDate(parts[2]).getTime() < dateWhenUserDoneTaskFirstTime.getTime() && isCompatibleDate(getDate(parts[2]).getTime(), after, before)) {
                    dateWhenUserDoneTaskFirstTime = getDate(parts[2]);
                    isDateChanged = true;
                }
            }
        }
        return isDateChanged ? dateWhenUserDoneTaskFirstTime : null;
    }

    @Override
    public Set<Date> getDatesWhenUserWroteMessage(String user, Date after, Date before) {
        return null;
    }

    @Override
    public Set<Date> getDatesWhenUserDownloadedPlugin(String user, Date after, Date before) {
        return null;
    }


    @Override
    public int getNumberOfAllEvents(Date after, Date before) {
        return getAllEvents(after, before).size();
    }

    @Override
    public Set<Event> getAllEvents(Date after, Date before) {
        Set<Event> userEvents = new HashSet<>();

        for (String line : linesList) {
            String[] parts = line.split("\\t");

            addEventEntity(after, before, userEvents, parts);

        }
        return userEvents;
    }

    @Override
    public Set<Event> getEventsForIP(String ip, Date after, Date before) {
        Set<Event> userEvents = new HashSet<>();

        for (String line : linesList) {
            String[] parts = line.split("\\t");
            if (parts[0].equals(ip))
                addEventEntity(after, before, userEvents, parts);

        }
        return userEvents;
    }

    @Override
    public Set<Event> getEventsForUser(String user, Date after, Date before) {
        Set<Event> userEvents = new HashSet<>();

        for (String line : linesList) {
            String[] parts = line.split("\\t");
            if (parts[1].equals(user))
                addEventEntity(after, before, userEvents, parts);

        }
        return userEvents;
    }

    @Override
    public Set<Event> getFailedEvents(Date after, Date before) {
        Set<Event> userEvents = new HashSet<>();

        for (String line : linesList) {
            String[] parts = line.split("\\t");
            if (parts[4].equals(Status.FAILED.toString()))
                addEventEntity(after, before, userEvents, parts);

        }
        return userEvents;
    }

    @Override
    public Set<Event> getErrorEvents(Date after, Date before) {
        Set<Event> userEvents = new HashSet<>();

        for (String line : linesList) {
            String[] parts = line.split("\\t");
            if (parts[4].equals(Status.ERROR.toString()))
                addEventEntity(after, before, userEvents, parts);

        }
        return userEvents;
    }

    @Override
    public int getNumberOfAttemptToSolveTask(int task, Date after, Date before) {
        int number = 0;
        for (String line : linesList) {
            String[] parts = line.split("\\t");
            if (parts[3].split(" ")[0].equals(Event.SOLVE_TASK.toString()) && Integer.parseInt(parts[3].split(" ")[1]) == task
                    && isCompatibleDate(getDate(parts[2]).getTime(), after, before))
                number++;
        }
        return number;
    }

    @Override
    public int getNumberOfSuccessfulAttemptToSolveTask(int task, Date after, Date before) {
        int number = 0;
        for (String line : linesList) {
            String[] parts = line.split("\\t");
            if (parts[3].split(" ")[0].equals(Event.DONE_TASK.toString()) && Integer.parseInt(parts[3].split(" ")[1]) == task
                    && isCompatibleDate(getDate(parts[2]).getTime(), after, before))
                number++;
        }
        return number;
    }

    @Override
    public Map<Integer, Integer> getAllSolvedTasksAndTheirNumber(Date after, Date before) {
        Map<Integer, Integer> map = new HashMap<>();
        for (String line : linesList) {
            String[] parts = line.split("\\t");
            if (parts[3].split(" ")[0].equals(Event.SOLVE_TASK.toString())
                    && isCompatibleDate(getDate(parts[2]).getTime(), after, before)) {
                Integer key = Integer.valueOf(parts[3].split(" ")[1]);
                if (!map.containsKey(key))
                    map.put(key, 1);
                else {
                    Integer value = map.get(key).intValue();
                    map.remove(key);
                    map.put(key, ++value);
                }
            }
        }
        return map;
    }

    @Override
    public Map<Integer, Integer> getAllDoneTasksAndTheirNumber(Date after, Date before) {
        Map<Integer, Integer> map = new HashMap<>();
        for (String line : linesList) {
            String[] parts = line.split("\\t");
            if (parts[3].split(" ")[0].equals(Event.DONE_TASK.toString())
                    && isCompatibleDate(getDate(parts[2]).getTime(), after, before)) {
                Integer key = Integer.valueOf(parts[3].split(" ")[1]);
                if (!map.containsKey(key))
                    map.put(key, 1);
                else {
                    Integer value = map.get(key).intValue();
                    map.remove(key);
                    map.put(key, ++value);
                }
            }
        }
        return map;
    }

    /**
     * 5.1. Реализуй интерфейс QLQuery у класса LogParser. Метод execute() пока должен поддерживать только следующие запросы:
     * 5.1.1. get ip
     * 5.1.2. get user
     * 5.1.3. get date
     * 5.1.4. get event
     * 5.1.5. get status
     * <p>
     * Пример: Вызов метода execute("get ip") должен вернуть Set<String>, содержащий все уникальные IP из лога
     * (это будет: 127.0.0.1, 12.12.12.12, 146.34.15.5, 192.168.100.2 для тестового файла). Аналогично должны работать и другие запросы.
     * <p>
     * Реальные объекты в возвращаемом множестве должны быть типа String для запросов ip и user,
     * для запроса date - тип объектов Date, для event и status - Event и Status соответственно.
     * <p>
     * 2. Вызов метода execute("get ip") класса LogParser должен возвращать множество (Set) содержащее все уникальные IP адреса.
     * 3. Вызов метода execute("get user") класса LogParser должен возвращать множество (Set) содержащее всех уникальных пользователей.
     * 4. Вызов метода execute("get date") класса LogParser должен возвращать множество (Set) содержащее все уникальные даты.
     * 5. Вызов метода execute("get event") класса LogParser должен возвращать множество (Set) содержащее все уникальные события.
     * 6. Вызов метода execute("get status") класса LogParser должен возвращать множество (Set) содержащее все уникальные статусы.
     */
    @Override
    public Set<Object> execute(String query) {

        String field1 = "";
        String field2 = "";
        String value1 = "";
        String value2 = "";
        String value3 = "";

        List<String> values = new ArrayList<>();
        Pattern pattern = Pattern.compile("\"[\\w \\.:]+\"");
        Matcher matcher = pattern.matcher(query);
        while (matcher.find()) {
            values.add(matcher.group().replace("\"", ""));
        }

        if (query.split(" ").length > 2) {
            field1 = query.split(" ")[1];
            field2 = query.split(" ")[3];
            value1 = values.get(0);
            if (values.size() > 1) {
                value2 = values.get(1);
                value3 = values.get(2);
            }
        }

        Set<Object> querySet = new HashSet<>();
        for (String line : linesList) {
            String[] lineParts = line.split("\\t");
            if (values.size() == 0) {
                switch (query) {
                    case "get ip":
                        querySet.add(lineParts[0]);
                        break;
                    case "get user":
                        querySet.add(lineParts[1]);
                        break;
                    case "get date":
                        Date date = getDate(lineParts[2]);
                        querySet.add(date);
                        break;
                    case "get event":
                        Event event = Event.valueOf(lineParts[3].split(" ")[0]);
                        querySet.add(event);
                        break;
                    case "get status":
                        Status status = Status.valueOf(lineParts[4]);
                        querySet.add(status);
                        break;
                }
            } else {
                switch (field1) {
                    case "ip":
                        switch (field2) {
                            case "ip":
                            case "user":
                            case "date":
                            case "status":
                                if (value1.equals(lineParts[getField2Index(field2)])) {
                                    if (values.size() == 3) {
                                        Date date = getDate(lineParts[2]);
                                        if (isCompatibleDate(date.getTime(), getDate(value2), getDate(value3))) {
                                            querySet.add(lineParts[0]);
                                        }
                                    } else {
                                        querySet.add(lineParts[0]);
                                    }
                                }
                                break;
                            case "event":
                                if (value1.equals(lineParts[3].split(" ")[0])) {
                                    if (values.size() == 3) {
                                        Date date = getDate(lineParts[2]);
                                        if (isCompatibleDate(date.getTime(), getDate(value2), getDate(value3))) {
                                            querySet.add(lineParts[0]);
                                        }
                                    } else {
                                        querySet.add(lineParts[0]);
                                    }
                                }
                                break;
                        }
                        break;
                    case "user":
                        switch (field2) {
                            case "ip":
                            case "user":
                            case "date":
                            case "status":
                                if (value1.equals(lineParts[getField2Index(field2)])) {
                                    if (values.size() == 3) {
                                        Date date = getDate(lineParts[2]);
                                        if (isCompatibleDate(date.getTime(), getDate(value2), getDate(value3))) {
                                            querySet.add(lineParts[1]);
                                        }
                                    } else {
                                        querySet.add(lineParts[1]);
                                    }
                                }
                                break;
                            case "event":
                                if (value1.equals(lineParts[3].split(" ")[0])) {
                                    if (values.size() == 3) {
                                        Date date = getDate(lineParts[2]);
                                        if (isCompatibleDate(date.getTime(), getDate(value2), getDate(value3))) {
                                            querySet.add(lineParts[1]);
                                        }
                                    } else {
                                        querySet.add(lineParts[1]);
                                    }
                                }
                                break;
                        }
                        break;
                    case "date":
                        switch (field2) {
                            case "ip":
                            case "user":
                            case "date":
                            case "status":
                                if (value1.equals(lineParts[getField2Index(field2)])) {
                                    if (values.size() == 3) {
                                        Date date = getDate(lineParts[2]);
                                        if (isCompatibleDate(date.getTime(), getDate(value2), getDate(value3))) {
                                            date = getDate(lineParts[2]);
                                            querySet.add(date);
                                        }
                                    } else {
                                        Date date = getDate(lineParts[2]);
                                        querySet.add(date);
                                    }
                                }
                                break;
                            case "event":
                                if (value1.equals(lineParts[3].split(" ")[0])) {
                                    if (values.size() == 3) {
                                        Date date = getDate(lineParts[2]);
                                        if (isCompatibleDate(date.getTime(), getDate(value2), getDate(value3))) {
                                            date = getDate(lineParts[2]);
                                            querySet.add(date);
                                        }
                                    } else {
                                        Date date = getDate(lineParts[2]);
                                        querySet.add(date);
                                    }
                                }
                                break;
                        }
                        break;
                    case "event":
                        switch (field2) {
                            case "ip":
                            case "user":
                            case "date":
                            case "status":
                                if (value1.equals(lineParts[getField2Index(field2)])) {
                                    if (values.size() == 3) {
                                        Date date = getDate(lineParts[2]);
                                        if (isCompatibleDate(date.getTime(), getDate(value2), getDate(value3))) {
                                            Event event = Event.valueOf(lineParts[3].split(" ")[0]);
                                            querySet.add(event);
                                        }
                                    } else {
                                        Event event = Event.valueOf(lineParts[3].split(" ")[0]);
                                        querySet.add(event);
                                    }
                                }
                                break;
                            case "event":
                                if (value1.equals(lineParts[3].split(" ")[0])) {
                                    if (values.size() == 3) {
                                        Date date = getDate(lineParts[2]);
                                        if (isCompatibleDate(date.getTime(), getDate(value2), getDate(value3))) {
                                            Event event = Event.valueOf(lineParts[3].split(" ")[0]);
                                            querySet.add(event);
                                        }
                                    } else {
                                        Event event = Event.valueOf(lineParts[3].split(" ")[0]);
                                        querySet.add(event);
                                    }
                                }
                                break;
                        }
                        break;
                    case "status":
                        switch (field2) {
                            case "ip":
                            case "user":
                            case "date":
                            case "status":
                                if (value1.equals(lineParts[getField2Index(field2)])) {
                                    if (values.size() == 3) {
                                        Date date = getDate(lineParts[2]);
                                        if (isCompatibleDate(date.getTime(), getDate(value2), getDate(value3))) {
                                            Status status = Status.valueOf(lineParts[4]);
                                            querySet.add(status);
                                        }
                                    } else {
                                        Status status = Status.valueOf(lineParts[4]);
                                        querySet.add(status);
                                    }
                                }
                                break;
                            case "event":
                                if (value1.equals(lineParts[3].split(" ")[0])) {
                                    if (values.size() == 3) {
                                        Date date = getDate(lineParts[2]);
                                        if (isCompatibleDate(date.getTime(), getDate(value2), getDate(value3))) {
                                            Status status = Status.valueOf(lineParts[4]);
                                            querySet.add(status);
                                        }
                                    } else {
                                        Status status = Status.valueOf(lineParts[4]);
                                        querySet.add(status);
                                    }
                                }
                                break;
                        }
                        break;
                }
            }
        }
        return querySet;
    }

    private int getField2Index(String field2) {
        switch (field2) {
            case "ip":
                return 0;
            case "user":
                return 1;
            case "date":
                return 2;
            case "event":
                return 3;
            case "status":
                return 4;
        }
        return -1;
    }

    private Set<Status> getUniqueStatuses() {
        Set<Status> statuses = new HashSet<>();
        for (String line : linesList) {
            String[] parts = line.split("\\t");
            if (!statuses.contains(Status.valueOf(parts[4])))
                statuses.add(Status.valueOf(parts[4]));
        }
        return statuses;
    }

    private Set<Date> getUniqueDates() {
        Set<Date> dates = new HashSet<>();
        for (String line : linesList) {
            String[] parts = line.split("\\t");
            if (!dates.contains(getDate(parts[2])))
                dates.add(getDate(parts[2]));
        }
        return dates;
    }
}