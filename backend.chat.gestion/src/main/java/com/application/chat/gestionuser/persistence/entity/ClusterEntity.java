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
@Table(name = "tbl_cluster")
@AllArgsConstructor
public class ClusterEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "clu_id")
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "fri_id", nullable = false)
    private FriendEntity friend;
    
    @Column(name = "use_id_a", nullable = false)
    private Long userIdA;
    
    @Column(name = "use_id_b", nullable = false)
    private Long userIdB;
    
    @Column(name = "clu_accept", columnDefinition = "BOOLEAN DEFAULT FALSE")
    private Boolean accept;
    
    @Builder.Default
    @Column(name = "clu_record")
    private Timestamp recordNow = new Timestamp(System.currentTimeMillis());
}
