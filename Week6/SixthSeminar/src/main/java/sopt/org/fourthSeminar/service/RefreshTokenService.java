package sopt.org.fourthSeminar.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import sopt.org.fourthSeminar.config.jwt.JwtService;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class RefreshTokenService {

    private final JwtService jwtService;
    @Autowired
    StringRedisTemplate redisTemplate;

    @Transactional
    public void saveRefreshToken(String userId, String refreshToken){

        ValueOperations<String, String> stringStringValueOperations = redisTemplate.opsForValue();
        stringStringValueOperations.set(userId, refreshToken);
    }


}
