package org.sopt.global;

public abstract class Car {
    //다형성 : 추상 메소드 사용하기
    public String car_Id;
    public String car_Owner;
    public abstract void move();
    public abstract void sound();
}
