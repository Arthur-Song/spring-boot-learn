package com.arthursong.demo.repository;

import com.arthursong.demo.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2018/7/5.
 */
public interface UserRepository extends  JpaRepository<User,Long> {

    User findByName(String name);

    User findByNameOrEmail(String name, String email);

    Long deleteById(Long id);

    Long countByName(String userName);

    List<User> findByEmailLike(String email);

    User findByNameIgnoreCase(String userName);

    List<User> findByNameOrderByEmailDesc(String email);

    Page<User> findALL(Pageable pageable);

    Page<User> findByName(String name,Pageable pageable);

    User findTopByOrderByAgeDesc();

    Page<User> queryFirst10ByName(String name, Pageable pageable);

    List<User> findFirst10ByName(String name, Sort sort);

    List<User> findTop10ByName(String name, Pageable pageable);

    @Modifying
    @Query("update User u set u.name = ?1 where u.id = ?2")
    int modifyByIdAndUserId(String name, Long id);

    @Transactional
    @Modifying
    @Query("delete from User where id = ?1")
    void deleteByUserId(Long id);

    @Transactional(timeout = 10)
    @Query("select u from User u where u.email = ?1")
    User findByEmail(String email);
}
