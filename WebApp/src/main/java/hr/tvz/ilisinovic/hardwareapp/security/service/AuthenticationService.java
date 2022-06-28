package hr.tvz.ilisinovic.hardwareapp.security.service;



import hr.tvz.ilisinovic.hardwareapp.security.command.LoginCommand;
import hr.tvz.ilisinovic.hardwareapp.security.dto.LoginDTO;

import java.util.Optional;

public interface AuthenticationService {

    Optional<LoginDTO> login(LoginCommand command);

}
