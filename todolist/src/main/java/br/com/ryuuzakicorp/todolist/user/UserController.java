package br.com.ryuuzakicorp.todolist.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import at.favre.lib.crypto.bcrypt.BCrypt;

/*
 * Modificador
 * public
 * private
 * protected
 */
@RestController
@RequestMapping("/users")
public class UserController {
    /*
     * String texto
     * Integer numero inteiro
     * Double numero quebrado
     * Float numero quebrado
     * char A C
     * Date Data
     * void
     */
    @Autowired
    private IUserRepository userRepository;

    @PostMapping("/")
    public ResponseEntity create(@RequestBody UserModel userModel){
        var user = this.userRepository.findByUsername(userModel.getUsername());

        if(user!=null){
            // System.out.println("Usuario já existe");
            // Mensagem de Erro
            // Status code
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuario já existe");
        }

        var passwordHashred = BCrypt.withDefaults().hashToString(12, userModel.getPassword().toCharArray());

        userModel.setPassword(passwordHashred);

        // System.out.println(userModel.getUsername());
        var userCreate = this.userRepository.save(userModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(userCreate);
    }
}
