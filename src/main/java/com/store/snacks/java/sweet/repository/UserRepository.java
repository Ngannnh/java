package com.store.snacks.java.sweet.repository;

import com.store.snacks.java.sweet.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ngan nnh on 5/14/2019
 * @project sweet
 */

public interface UserRepository extends JpaRepository<User,String> {

}
