package org.sopt.domain.Car;

public class Porche extends SportCar {
    //같은 패키지 안에 있는 SportCar 상속
    String color;

    //super method
    public Porche(String car_Id, String car_Owner, int speed, boolean isFast, String color){
        super(car_Id,car_Owner,speed,isFast);
        this.color = color;
    }
}