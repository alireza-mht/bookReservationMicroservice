package io.github.alirezamht.book.repository;

import io.github.alirezamht.book.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {


   // Boolean existsUserByUsernameAndPassword(@Param("username") String username,@Param("password") String password);

}
