package com.application.chat.gestionuser.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.application.chat.gestionuser.persistence.entity.FriendEntity;
import com.application.chat.gestionuser.util.interfaces.IFriends;

public interface FriendRepository extends JpaRepository<FriendEntity, Long> {

    @Query(value = """
            select 
                tu.use_id as id, 
                tu.use_username as name,
                tu.usu_nickname as nickname
            from tbl_friend tf
            inner join tbl_user tu on tf.use_id = tu.use_id
            inner join tbl_cluster tc on tf.fri_id = tc.fri_id
            where
                tc.clu_accept = true and
                tc.use_id_a = :id and 
                tu.use_id != :id
                    """, nativeQuery = true)
    public List<IFriends> findFriendsById(Long id);
}
