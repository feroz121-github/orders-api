package com.store.orders_api.user;

// import java.util.Map;
// import java.util.Optional;
// import java.util.Comparator;
// import java.util.List;
// import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

// @Repository
// public class UserRepository {

//     private final Map<Long, User> users = Map.of(
//     1L, new User(1L, "Feroz", "feroz@gmail.com"),
//     2L, new User(2L, "Tanuja", "Tanuja@gmail.com"),
//     3L, new User(3L, "Yashika", "yashika@gmail.com"),
//     4L, new User(4L, "Mummy", "amma@gmail.com"));

//     public Optional<User> findById(Long id) {
//     return Optional.ofNullable(users.get(id));
//     }

//     public List<User> findAll() {
//     return
//     users.values().stream().sorted(Comparator.comparing(User::id)).toList();
//     }
// }

public interface UserRepository extends JpaRepository<User, Long> {

}