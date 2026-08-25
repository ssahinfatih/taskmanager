package com.fatihsahin.taskmanager.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Entity
@Table(name = "task")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title",length = 100)
    private String title;
    @Column(name = "description",length = 500)
    private String description;
    @Column(name = "complated")
    private boolean completed;
    @Column(name = "created_at",nullable = false,updatable = false)
    private LocalDateTime createdAt;

    @PrePersist//Veritabanına kaydetmeden hemen önce çalışır.
    protected void onCreate() {//oluşturma işleminde oluşturulma tarihini localdatetime.now a eşitliyoruz.
        this.createdAt = LocalDateTime.now();
    }
}
