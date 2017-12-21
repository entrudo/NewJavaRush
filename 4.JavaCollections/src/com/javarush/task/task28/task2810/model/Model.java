package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.view.View;
import com.javarush.task.task28.task2810.vo.Vacancy;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private View view;
    private Provider[] providers;

    public Model(View view, Provider... providers) {
        this.view = view;
        this.providers = providers;
        if (providers == null || view == null || providers.length == 0) {
            throw new IllegalArgumentException();
        }
    }

    public void selectCity(String city) {
        List<Vacancy> vacancies = new ArrayList<>();
        for (Provider provider : providers) {
            try {
                vacancies.addAll(provider.getJavaVacancies(city));
            } catch (NullPointerException ignored) {
            }
        }
        view.update(vacancies);
    }
}
