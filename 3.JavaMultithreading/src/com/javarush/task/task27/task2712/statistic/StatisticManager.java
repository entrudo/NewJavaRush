package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StatisticManager {
    private StatisticStorage statisticStorage = new StatisticStorage();
    private static StatisticManager instance = new StatisticManager();

    public static StatisticManager getInstance() {
        return instance;
    }

    private StatisticManager() {
    }

    public void register(EventDataRow data) {
        if (data != null)
            statisticStorage.put(data);
    }

    private class StatisticStorage {
        private Map<EventType, List<EventDataRow>> storage = new HashMap<EventType, List<EventDataRow>>();

        private StatisticStorage() {
            for (EventType eventType : EventType.values()) {
                storage.put(eventType, new ArrayList<EventDataRow>());
            }
        }

        private void put(EventDataRow data) {
            storage.get(data.getType()).add(data);
        }
    }
}
