package hr.tvz.ilisinovic.hardwareapp.security.service;


import hr.tvz.ilisinovic.hardwareapp.security.domain.User;

public interface JwtService {

    boolean authenticate(String token);

    String createJwt(User user);

}
