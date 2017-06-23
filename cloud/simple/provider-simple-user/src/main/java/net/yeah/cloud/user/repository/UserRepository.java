package net.yeah.cloud.user.repository;

import net.yeah.cloud.user.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
