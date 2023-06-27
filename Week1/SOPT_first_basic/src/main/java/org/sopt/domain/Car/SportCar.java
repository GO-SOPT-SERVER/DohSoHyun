package org.sopt.domain.Car;

import org.sopt.global.Car;

public class SportCar extends Car {
    int speed;
    boolean isFast;

    public SportCar(String car_Id, String car_Owner, int speed, boolean isFast){
        this.car_Id = car_Id;
        this.car_Owner = car_Owner;
        this.speed = speed;
        this.isFast =isFast;
    }

    @Override
    public void move(){
        System.out.println(car_Id + "번 차가 앞으로 전진합니다.");
    }

    @Override
    public void sound(){
        System.out.println(car_Owner + "가 스포츠 카의 클락션을 울립니다.");
    }
}
