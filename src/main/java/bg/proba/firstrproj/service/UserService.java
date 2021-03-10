package bg.proba.firstrproj.service;

import bg.proba.firstrproj.model.User;
import bg.proba.firstrproj.repository.UserRepository;
import java.time.OffsetDateTime;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService implements UserDetailsService {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  public UserService(UserRepository userRepository,
      PasswordEncoder passwordEncoder) {
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
  }

  @Override
  @Transactional
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    if (userRepository.count() == 0) {
      register("admin", "admin", "admin");
    }

    Optional<User> user = userRepository.findByUsername(username);
    if (!user.isPresent()) {
      throw new UsernameNotFoundException("Not Found.");
    }

    User realUser = user.get();
    realUser.setLastLoginTime(OffsetDateTime.now());
    return userRepository.save(realUser);
  }

  public Page<User> listUsers(Pageable pageable) {
    return userRepository.findAll(pageable);
  }

  public User changePassword(User user, String oldPassword, String newPassword) {
    String currentHash = user.getPassword();
    if (!passwordEncoder.matches(oldPassword, newPassword)) {
      throw new IllegalArgumentException("The password doesn't match.");
    }
    if (passwordEncoder.matches(newPassword, currentHash)) {
      throw new IllegalArgumentException("The passwords are the same.");
    }
    user.setPassword(passwordEncoder.encode(newPassword));
    return userRepository.save(user);
  }

  public User register(String username, String password, String passConfirmation) {
    if (!password.equals(passConfirmation)) {
      throw new IllegalArgumentException("The password doesn't match.");
    }
    if (userRepository.findByUsername(username).isPresent()){
      throw new IllegalArgumentException("The username already exists.");
    }
    User user = new User();
    user.setUsername(username);
    user.setPassword(passwordEncoder.encode(password));
    user.setLastLoginTime(OffsetDateTime.now());
    return userRepository.save(user);
  }
}
