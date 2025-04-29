package org.example;

public class AuthManager {
    private final UserRepository userRepository;
    private final HashPassword passwordHasher;

    public AuthManager(UserRepository userRepository, HashPassword passwordHasher) {
        this.userRepository = userRepository;
        this.passwordHasher = passwordHasher;
    }

    public User login(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (passwordHasher.matches(password, user.getHashedPassword())) {
            return user;
        } else {
            throw new InvalidCredentialsException("Incorrect password");
        }
    }
}
