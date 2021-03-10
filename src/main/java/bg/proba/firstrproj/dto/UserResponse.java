package bg.proba.firstrproj.dto;

import java.time.OffsetDateTime;
import javax.persistence.Column;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserResponse {
  private long id;
  private String username;
  private OffsetDateTime lastLoginTime;
  private OffsetDateTime registrationTime;

  public long getId() {
    return id;
  }

  public UserResponse setId(long id) {
    this.id = id;
    return this;
  }

  public String getUsername() {
    return username;
  }

  public UserResponse setUsername(String username) {
    this.username = username;
    return this;
  }

  public OffsetDateTime getLastLoginTime() {
    return lastLoginTime;
  }

  public UserResponse setLastLoginTime(OffsetDateTime lastLoginTime) {
    this.lastLoginTime = lastLoginTime;
    return this;
  }

  public OffsetDateTime getRegistrationTime() {
    return registrationTime;
  }

  public UserResponse setRegistrationTime(OffsetDateTime registrationTime) {
    this.registrationTime = registrationTime;
    return this;
  }
}
