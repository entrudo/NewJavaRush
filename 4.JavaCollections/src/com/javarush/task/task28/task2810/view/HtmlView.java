package com.javarush.task.task28.task2810.view;

import com.javarush.task.task28.task2810.Controller;
import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class HtmlView implements View {
    private Controller controller;
    private final String filePath = "./src/" + this.getClass().getPackage().getName().replace('.', '/') + "/vacancies.html";

    public void get() {
        System.out.println(filePath);
    }
    @Override
    public void update(List<Vacancy> vacancies) {
        updateFile(getUpdatedFileContent(vacancies));

        System.out.println(vacancies.size());

    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }


    public void userCitySelectEmulationMethod() {
        controller.onCitySelect("Odessa");
    }


    private String getUpdatedFileContent(List<Vacancy> list) {
        return null;
    }

    private void updateFile(String string) {


    }

    protected Document getDocument() throws IOException {
        return Jsoup.parse(new File(filePath), "UTF-8");

    }
}
