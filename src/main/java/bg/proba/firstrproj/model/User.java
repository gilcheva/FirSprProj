package bg.proba.firstrproj.model;

import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class User implements UserDetails {

  @Id
  @GeneratedValue
  private long id;

  @Size(min = 5,max = 10)
  @Pattern(regexp = "[a-zA-Z0-9]+")
  @Column(unique = true)
  private String username;

  @Size(max = 1024)
  private String password;

  private OffsetDateTime lastLoginTime;

  public long getId() {
    return id;
  }

  public User setId(long id) {
    this.id = id;
    return this;
  }

  @Override
  public String getUsername() {
    return username;
  }

  public User setUsername(String username) {
    this.username = username;
    return this;
  }

  @Override
  public String getPassword() {
    return password;
  }

  public User setPassword(String password) {
    this.password = password;
    return this;
  }

  public OffsetDateTime getLastLoginTime() {
    return lastLoginTime;
  }

  public User setLastLoginTime(OffsetDateTime lastLoginTime) {
    this.lastLoginTime = lastLoginTime;
    return this;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return Arrays.asList(new SimpleGrantedAuthority("user"));
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    User user = (User) o;
    return id == user.id && username.equals(user.username) && password.equals(user.password);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, username, password);
  }
}
