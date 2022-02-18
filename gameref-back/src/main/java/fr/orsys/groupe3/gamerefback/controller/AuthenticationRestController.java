package fr.orsys.groupe3.gamerefback.controller;

import fr.orsys.groupe3.gamerefback.business.Moderator;
import fr.orsys.groupe3.gamerefback.business.User;
import fr.orsys.groupe3.gamerefback.exception.NotFoundException;
import fr.orsys.groupe3.gamerefback.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.data.util.Pair;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@AllArgsConstructor
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials = "true")
public class AuthenticationRestController {
    private UserService userService;

    private HttpSession httpSession;

    @GetMapping("/login/{pseudo}/{password}")
    public Pair<User, Boolean> login(@PathVariable String pseudo, @PathVariable String password) throws NotFoundException {
        User user = userService.getUser(pseudo, password);
        httpSession.setAttribute("user", user);
        System.out.println(httpSession.getId());
        return Pair.of(user, user instanceof Moderator);
    }

    @PostMapping("/logout")
    public void logout() {
        httpSession.invalidate();
    }
}
