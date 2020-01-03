package com.maxhyeon.ndays.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.maxhyeon.ndays.entity.Users;
public interface UserJpaRepo extends JpaRepository<Users,Long> {
}
