package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MoikrugStrategy implements Strategy {
    @Override
    public List<Vacancy> getVacancies(String searchString) {
        List<Vacancy> vacancyList = new ArrayList<>();
        int pageNum = 0;
        while (true) {
            try {
                Document doc = getDocument(searchString, pageNum);
                Elements elements = doc.getElementsByClass("Job");
                if (elements.size() == 0) break;

                for (Element element : elements) {

                    Vacancy vacancy = new Vacancy();
                    vacancy.setTitle(element.select("div[class=\"title\"]").text());
                    vacancy.setCity(element.select("span[class=\"location\"]").text());
                    String companyName = element.getElementsByClass("company_name").text();
                    vacancy.setCompanyName(companyName);
                    vacancy.setSiteName("https://moikrug.ru");
                    vacancy.setUrl("https://moikrug.ru" + element.select("div[class=\"title\"]").first().child(0).attr("href"));
                    String salary = element.select("div[class=\"salary\"]").text();

                    if (salary != null)

                        vacancy.setSalary(salary);

                    else vacancy.setSalary("");
                    vacancyList.add(vacancy);

                }
            } catch (IOException e) {
                System.out.println("Connection lose" + e.getStackTrace());
                break;
            }
            pageNum++;

        }
        return vacancyList;
    }

    private static final String URL_FORMAT = "https://moikrug.ru/vacancies?q=java+%s&page=%d";

    protected Document getDocument(String searchString, int page) throws IOException {
        String URL = String.format(URL_FORMAT, searchString, page);

        Document doc = Jsoup.connect(URL).userAgent("Mozilla/5.0 (jsoup)").referrer("https://moikrug.ru/vacancies?page=1&q=java+Moscow").get();

        return doc;
    }
}
