package com.javarush.task.task28.task2810;

import com.javarush.task.task28.task2810.model.HHStrategy;
import com.javarush.task.task28.task2810.model.Model;
import com.javarush.task.task28.task2810.model.MoikrugStrategy;
import com.javarush.task.task28.task2810.model.Provider;
import com.javarush.task.task28.task2810.view.HtmlView;

public class Aggregator {
    public static void main(String[] args) {

        Provider provider = new Provider(new HHStrategy());
        Provider provider2 = new Provider(new MoikrugStrategy());
        HtmlView view = new HtmlView();
        view.get();
        Model model = new Model(view, provider, provider2);
        Controller controller = new Controller(model);
        view.setController(controller);
        view.userCitySelectEmulationMethod();
    }
}
