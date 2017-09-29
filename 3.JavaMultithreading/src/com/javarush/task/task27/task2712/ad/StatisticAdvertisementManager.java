package com.javarush.task.task27.task2712.ad;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class StatisticAdvertisementManager {
    private static StatisticAdvertisementManager ourInstance = new StatisticAdvertisementManager();
    private AdvertisementStorage storage = AdvertisementStorage.getInstance();

    public static StatisticAdvertisementManager getInstance() {
        return ourInstance;
    }

    private StatisticAdvertisementManager() {
    }

    public Map<String, Integer> getActiveVideoSet() {
        Map<String, Integer> res = new TreeMap<String, Integer>();
        List<Advertisement> videos = storage.list();
        for (Advertisement ad : videos) {
            if (ad.getHits() >= 1)
                res.put(ad.getName(), ad.getHits());
        }
        return res;
    }

    public List<Advertisement> getInactiveVideoSet() {
        List<Advertisement> result = new ArrayList<>();
        for (Advertisement advertisement : storage.list()) {
            if (advertisement.getHits() == 0) {
                result.add(advertisement);
            }
        }
        return result;
    }
}
