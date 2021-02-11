package bg.proba.firstrproj.model;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class User {

  @Id
  @GeneratedValue
  private long id;

  @Size(min = 5,max = 10)
  @Pattern(regexp = "[a-zA-Z0-9]+")
  @Column(unique = true)
  private String username;

  @Size(max = 1024)
  private String password;

  public long getId() {
    return id;
  }

  public User setId(long id) {
    this.id = id;
    return this;
  }

  public String getUsername() {
    return username;
  }

  public User setUsername(String username) {
    this.username = username;
    return this;
  }

  public String getPassword() {
    return password;
  }

  public User setPassword(String password) {
    this.password = password;
    return this;
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
