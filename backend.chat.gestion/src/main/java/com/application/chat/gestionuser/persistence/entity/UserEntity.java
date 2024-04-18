package com.application.chat.gestionuser.persistence.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "tbl_user", schema = "esq_chat")
public class UserEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "use_id")
    private Long id;
    
    @Column(name = "use_username", nullable = false, length = 100)
    private String username;
    
    @Column(name = "use_password", nullable = false, length = 500)
    private String password;
    
    @Column(name = "usu_nickname", nullable = false, length = 100)
    private String nickname;
    
    @Column(name = "usu_role", nullable = false, length = 20)
    private String role;
    
    @Column(name = "usu_photo", columnDefinition = "TEXT")
    private String photo;

    @Column(name = "usu_record")
    private Timestamp recordNow = new Timestamp(System.currentTimeMillis());
}
