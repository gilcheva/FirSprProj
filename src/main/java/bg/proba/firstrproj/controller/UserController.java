package bg.proba.firstrproj.controller;

import bg.proba.firstrproj.model.User;
import bg.proba.firstrproj.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

  private UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping
  public Page<User> listUsers(
      @RequestParam(name="page", required = false,defaultValue="0") int pageNumber,
      @RequestParam(name="size", required = false,defaultValue="20") int pageSize) {
    return userService.listUsers(PageRequest.of(pageNumber, pageSize));
  }
}
