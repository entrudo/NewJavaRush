package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.List;

public class HHStrategy implements Strategy {
    private static final String URL_FORMAT = "http://hh.ua/search/vacancy?text=java+%s&page=%d";

    @Override
    public List<Vacancy> getVacancies(String searchString) {
        try {
            Document doc = Jsoup.connect(String.format(URL_FORMAT, "Kiev", 1)).get();
            String str = doc.html();
            System.out.println(doc.title());
        } catch (IOException e) {
        }
        return null;
    }
}
