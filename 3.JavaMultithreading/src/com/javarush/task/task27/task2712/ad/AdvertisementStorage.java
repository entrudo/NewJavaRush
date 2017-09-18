package com.javarush.task.task27.task2712.ad;

public class AdvertisementStorage {
    private static AdvertisementStorage advertisementStorage;

    private AdvertisementStorage() {
    }

    public static AdvertisementStorage getInstance() {
        if (advertisementStorage == null) {
            advertisementStorage = new AdvertisementStorage();
        }
        return advertisementStorage;
    }
}
