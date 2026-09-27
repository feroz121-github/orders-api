package com.store.orders_api.user;

import java.util.Optional;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<UserResponse> getById(Long id) {
        return userRepository.findById(id).map(this::mapToResponse);
    }

    public List<UserResponse> getAll() {
        return userRepository.findAll(Sort.by("id"))
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    public UserResponse createUser(UserRequest userRequest) {
        User user = new User(userRequest.name(), userRequest.email());
        User savedUser = userRepository.save(user);
        return mapToResponse(savedUser);
    }

    public UserResponse updateUser(Long id, UserRequest userRequest) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User with Id " + id + " not found"));
        existingUser.setName(userRequest.name());
        existingUser.setEmail(userRequest.email());
        User updatedUser = userRepository.save(existingUser);
        return mapToResponse(updatedUser);
    }

    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User with Id " + id + " not found");
        }
        userRepository.deleteById(id);
    }

    public UserResponse mapToResponse(User user) {
        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getEmail());
    }
}
