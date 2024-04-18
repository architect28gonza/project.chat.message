package com.application.chat.gestionuser.persistence.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@Entity
@Table(name = "tbl_friend", schema = "esq_chat")
@AllArgsConstructor
public class FriendEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "fri_id")
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "use_id", nullable = false)
    private UserEntity user;
    
    @Builder.Default
    @Column(name = "fri_record")
    private Timestamp recordNow = new Timestamp(System.currentTimeMillis());
}
