package br.com.ryuuzakicorp.todolist.user;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity(name="tb_users")
@Data/*@Getters + @Setters */
public class UserModel{

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    /*@Getters + @Setters */
    // @Column(name="Usuarios")
    @Column(unique = true)
    private String username;
    private String name;
    
    private String password;

    @CreationTimestamp
    private LocalDateTime createdAt;
    
    // /*Setters */
    // public void setUsername(String username) {
    //     this.username = username;
    // }
    // public void setName(String name) {
    //     this.name = name;
    // }
    // public void setPassword(String password) {
    //     this.password = password;
    // }
    
    // /*Getters */
    // public String getName() {
    //     return name;
    // }
    // public String getPassword() {
    //     return password;
    // }
    // public String getUsername() {
    //     return username;
    // }
}