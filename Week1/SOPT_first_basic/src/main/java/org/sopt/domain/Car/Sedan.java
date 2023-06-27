package org.sopt.domain.Car;

import org.sopt.global.Car;

//상속 구현하기
public class Sedan extends Car {
    int acceptable;

    public Sedan(String car_Id, String car_Owner, int acceptable) {
        //this. 키워드 사용
        this.car_Id = car_Id;
        this.car_Owner = car_Owner;
        this.acceptable = acceptable;
        //같은 패키지 안에 있지 않은 default 접근 제어자를 가진 car_Type은 접근할 수 없다.
    }

    //오버로딩
    public Sedan(String car_Id, String car_Owner){
        this(car_Id, car_Owner, 6);
        //this() 사용
    }

    //오버라이딩
    @Override
    public void move(){
        System.out.println(this.car_Id+ "번 차가 전진합니다.");
    }

    @Override
    public void sound(){
        System.out.println(this.car_Owner + "님께서 본인 Sedan의 클락션을 울리셨습니다.");
    }

}
