package bg.proba.firstrproj.service;

import bg.proba.firstrproj.model.User;
import bg.proba.firstrproj.repository.UserRepository;
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
      User user = new User();
      user.setUsername("admin");
      user.setPassword(passwordEncoder.encode("admin"));
      userRepository.save(user);
    }
    return userRepository.findByUsername(username)
        .orElseThrow(() -> new UsernameNotFoundException("Not Found."));
  }
}
