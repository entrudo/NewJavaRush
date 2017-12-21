package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HHStrategy implements Strategy {
    private static final String URL_FORMAT = "http://hh.ua/search/vacancy?text=java+%s&page=%d";

    protected Document getDocument(String searchString, int page) throws IOException {
        Document doc = null;
        try {
            doc = Jsoup.connect(String.format(URL_FORMAT, searchString, page))
                    .userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.94 Safari/537.36")
                    .referrer("http://google.com")
                    .timeout(5000)
                    .get();
            doc.html();
            System.out.println();
        } catch (IOException e) {
        }
        return doc;
    }

    @Override
    public List<Vacancy> getVacancies(String searchString) {

        List<Vacancy> vacancyList = new ArrayList<>();
        int pageNum = 0;
        while (true) {
            try {

                Document doc = getDocument(searchString, pageNum);
                Elements elements = doc.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy");
                if (elements.size() == 0) break;

                for (Element element : elements) {

                    Vacancy vacancy = new Vacancy();
                    vacancy.setTitle(element.select("a[data-qa=\"vacancy-serp__vacancy-title\"]").text());
                    vacancy.setCity(element.select("span[data-qa=\"vacancy-serp__vacancy-address\"]").text());
                    vacancy.setCompanyName(element.select("a[data-qa=\"vacancy-serp__vacancy-employer\"]").text());
                    vacancy.setSiteName(URL_FORMAT);
                    vacancy.setUrl(element.select("a[data-qa=\"vacancy-serp__vacancy-title\"]").attr("href"));

                    String salary = element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-compensation").text();
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
}
