package com.javarush.task.task27.task2712.ad;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AdvertisementManager {
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private int timeSeconds;

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos() {
        List<Advertisement> adList = storage.list();

        if (adList.isEmpty() || adList == null) throw new NoVideoAvailableException();

        Collections.sort(adList, new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                long diff = o2.getAmountPerOneDisplaying() - o1.getAmountPerOneDisplaying();
                if (diff == 0)
                    diff = o1.getAmountPerOneDisplaying() * 1000 / o1.getDuration() - o2.getAmountPerOneDisplaying() * 1000 / o2.getDuration();
                return (int) (diff);
            }
        });

        int totalDuration = 0;
        long totalAmount = 0;
        List<Advertisement> adsForShow = new ArrayList<>();
        for (Advertisement ad : adList) {
            totalAmount += ad.getAmountPerOneDisplaying();
            totalDuration += ad.getDuration();
            if (totalDuration <= timeSeconds && ad.getDuration() <= timeSeconds) {
                adsForShow.add(ad);
            } else {
                totalAmount -= ad.getAmountPerOneDisplaying();
                totalDuration -= ad.getDuration();
            }
        }

        StatisticManager.getInstance().register(new VideoSelectedEventDataRow(
                adsForShow, totalAmount, totalDuration));

        for (Advertisement ad : adsForShow) {
            ad.revalidate();
            ConsoleHelper.writeMessage(ad.getName() + " is displaying... " + ad.getAmountPerOneDisplaying() + ", " + ad.getAmountPerOneDisplaying() * 1000 / ad.getDuration());
        }

    }
}
