package org.sopt;
import org.sopt.domain.Car.Porche;
import org.sopt.domain.Car.Sedan;
import org.sopt.domain.Load.HighWay;
import org.sopt.global.Car;

import java.util.ArrayList;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        List<Car> carList = new ArrayList<>();
        Porche porche = new Porche("2097", "도소현",140,true,"Red");
        carList.add(porche);
        Sedan sedan = new Sedan("9889", "누구");
        carList.add(sedan);

        HighWay load = new HighWay(carList);
    }
}