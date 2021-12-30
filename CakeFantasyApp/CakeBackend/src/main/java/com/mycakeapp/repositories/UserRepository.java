package com.mycakeapp.repositories;

import com.mycakeapp.entities.User;
import com.mycakeapp.entities.UserDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    @Query(nativeQuery = true, value = "SELECT  User FROM  User  where  email=user.email AND password = user.password")
    User findByEmail(@Param("user") UserDto userDto);

}
