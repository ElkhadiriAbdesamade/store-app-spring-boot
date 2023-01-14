package com.gestion.service.api.dataaccess.user.dao;

import com.gestion.service.api.dataaccess.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

public interface UserDAO extends JpaRepository<User, Integer> {





   @Transactional
    @Modifying
    @Query("""
            update User u set u.first_name = :first_name, u.last_name = :last_name, u.phone = :phone, u.address = :address, u.country = :country, u.email = :email, u.password = :password, u.role = :role
            where u.id = :id""")
    int updateById(String first_name, String last_name, String phone, String address, String country, String email, String password, String role, int id);

    @Query(value = "SELECT * FROM users u WHERE u.id = :id",nativeQuery = true)
    User getUserById(@Param("id") BigDecimal id);

    @Query(value = "SELECT * FROM users",nativeQuery = true)
    List<User> getAllUsers();
    @Query(value = "SELECT * FROM users u WHERE u.email = :email and u.psw = :psw",nativeQuery = true)
    User getUserByEmail_psw(@Param("email") String email,@Param("psw") String psw);
    @Query(value = "SELECT * FROM users u WHERE u.email = :email",nativeQuery = true)
    User getUserByEmail(@Param("email") String email);

    @Query(value = "insert into users(first_name,last_name,phone,address,country,email,password) values(:first_name,:last_name,:phone,:address,:country,:email,:password)",nativeQuery = true)
    User registerUserTo(@Param("first_name") String first_name,@Param("last_name") String last_name,@Param("phone") String phone,
                        @Param("address") String address,@Param("country") String country,@Param("email") String email,@Param("password") String password);

  /*  @Query(value = "update User u set u.first_name = :first_name, u.last_name = :last_name, u.phone = :phone, u.address = :address, u.country = :country, u.email = :email, u.password = :password, u.role = :role where u.id = :id",nativeQuery = true)
    User updateById(@Param("id") BigDecimal id, @Param("first_name") String first_name,@Param("last_name") String last_name,@Param("phone") String phone,
                        @Param("address") String address,@Param("country") String country,@Param("email") String email,@Param("password") String password,@Param("role") String role);*/

    @Query(value = "DELETE FROM users WHERE id = :id",nativeQuery = true)
    void deleteUserById(@Param("id") Integer id);
}
