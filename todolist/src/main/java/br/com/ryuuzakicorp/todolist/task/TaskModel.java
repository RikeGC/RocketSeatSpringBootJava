package br.com.ryuuzakicorp.todolist.task;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "tb_tasks")
public class TaskModel {
    /* 
     * ID
     * Usuario
     * Descrição
     * Titulo
     * Data Inicio
     * Data Termino
     * Prioridade
     */
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    private String description;
    @Column(length = 50)
    private String title;
    private LocalDateTime startAt;
    private LocalDateTime endAt;
    private String priority;

    @CreationTimestamp
    private LocalDateTime createdAt;

    private UUID idUser;

    public void setTitle(String title) throws Exception{
        if(title.length()>50){
            throw new Exception("Titulo menor que 50 letras");
        }
        this.title = title;
    }
}
