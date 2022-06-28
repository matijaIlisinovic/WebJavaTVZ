package hr.tvz.ilisinovic.hardwareapp.security.service;


import hr.tvz.ilisinovic.hardwareapp.security.command.LoginCommand;
import hr.tvz.ilisinovic.hardwareapp.security.domain.User;
import hr.tvz.ilisinovic.hardwareapp.security.dto.LoginDTO;
import hr.tvz.ilisinovic.hardwareapp.security.repository.UserRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.Optional;
import java.util.function.Function;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final JwtService jwtService;
    private final UserRepository userRepository;


    public AuthenticationServiceImpl(JwtService jwtService, UserRepository userRepository) {
        this.jwtService = jwtService;
        this.userRepository = userRepository;
    }

    @Override
    public Optional<LoginDTO> login(LoginCommand command) {
        Optional<User> user = userRepository.findByUsername(command.getUsername());

        if (user.isEmpty() || !isMatchingPassword(command.getPassword(), user.get().getPassword())) {
            return Optional.empty();
        }

        return Optional.of(
                new LoginDTO(jwtService.createJwt(user.get()))
        );
    }

    private boolean isMatchingPassword(String rawPassword, String encryptedPassword) {
        if(new BCryptPasswordEncoder().matches(rawPassword,encryptedPassword)){
            return true;
        }else{
            return false;
        }
    }

}

