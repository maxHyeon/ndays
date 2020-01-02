package com.maxhyeon.ndays.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.maxhyeon.ndays.entity.User;
public interface UserJpaRepo extends JpaRepository<User,Long> {
}
