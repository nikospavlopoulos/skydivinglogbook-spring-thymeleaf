package com.nikospavlopoulos.skydivinglogbook.service;

import com.nikospavlopoulos.skydivinglogbook.core.exceptions.EntityAlreadyExistsException;
import com.nikospavlopoulos.skydivinglogbook.dto.UserInsertDTO;
import com.nikospavlopoulos.skydivinglogbook.mapper.Mapper;
import com.nikospavlopoulos.skydivinglogbook.model.User;
import com.nikospavlopoulos.skydivinglogbook.repository.UserRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.Optional;

/**
 * Service class for managing User-related operations.
 * It acts as an intermediary between the controller and repository layers.
 * Interacts with the repository to fetch or save users and ensures that passwords are encrypted before saving, enhancing security.
 */

@Service
@RequiredArgsConstructor
public class UserServiceImpl {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final Mapper mapper;

    @Transactional
    public boolean existsByUsername(String username) {
        return userRepository.findByUsername(username).isPresent();
    }

    @Transactional
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Transactional(rollbackOn = Exception.class)
    public User saveUser(UserInsertDTO dto) throws EntityAlreadyExistsException {

        if (existsByUsername(dto.getUsername())) {
            throw new EntityAlreadyExistsException("User", dto.getUsername() + " already exists");
        }

        User user = mapper.mapToUserEntity(dto);

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
}
