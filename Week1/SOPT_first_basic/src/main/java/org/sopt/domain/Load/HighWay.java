package org.sopt.domain.Load;

import org.sopt.global.Car;
import org.sopt.global.Load;
import java.util.List;

//인터페이스 상속 받기
public class HighWay implements Load {

    //제네릭 사용
    public HighWay(List<Car> carList){
        for(int i = 0; i< carList.size();i++){
            System.out.println("고속도로에 현재 " + carList.get(i).car_Id + "번 차가 지나가고 있습니다.");
        }
    }
    @Override
    public String howManyCar(int cars) {
        return cars + "개의 차가 고속도로를 지나고 있습니다.";
    }

}
