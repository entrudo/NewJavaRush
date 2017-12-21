package com.javarush.task.task28.task2810.view;

import com.javarush.task.task28.task2810.Controller;
import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
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
        Document document;
        try {
            document = getDocument();
            Elements elementVacancy = document.select("tr[class=\"vacancy\"]");
            for (Element element : elementVacancy) {
                element.remove();
            }
            Element elementTemplate = document.getElementsByClass("template").first();
            Element cloneElementTemplate = elementTemplate.clone();
            cloneElementTemplate.removeClass("template");
            cloneElementTemplate.removeAttr("style");


            for (Vacancy vacancy : list) {

                Element htmlVacancy = cloneElementTemplate.clone();
                htmlVacancy.select("a[href=\"url\"]").first().text(vacancy.getTitle()).attr("href", vacancy.getUrl());
                htmlVacancy.select("td[class=\"city\"]").first().text(vacancy.getCity());
                htmlVacancy.select("td[class=\"companyName\"]").first().text(vacancy.getCompanyName());
                htmlVacancy.select("td[class=\"salary\"]").first().text(vacancy.getSalary());
                elementTemplate.before(htmlVacancy.outerHtml());

            }

        } catch (IOException e) {
            e.printStackTrace();
            return "Some exception occurred";
        }


        return document.toString();
    }

    private void updateFile(String string) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {

            bw.write(string);

        } catch (IOException e) {
            System.out.println("Запись в vacancies не удалась" + e.toString());
        }

    }

    protected Document getDocument() throws IOException {
        return Jsoup.parse(new File(filePath), "UTF-8");

    }
}
