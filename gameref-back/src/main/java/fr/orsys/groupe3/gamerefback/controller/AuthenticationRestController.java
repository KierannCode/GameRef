package fr.orsys.groupe3.gamerefback.controller;

import fr.orsys.groupe3.gamerefback.business.Moderator;
import fr.orsys.groupe3.gamerefback.business.User;
import fr.orsys.groupe3.gamerefback.exception.NotFoundException;
import fr.orsys.groupe3.gamerefback.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.data.util.Pair;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AuthenticationRestController {
    private UserService userService;

    @GetMapping("/login/{pseudo}/{password}")
    public Pair<User, Boolean> login(@PathVariable String pseudo, @PathVariable String password) throws NotFoundException {
        User user = userService.getUser(pseudo, password);
        return Pair.of(user, user instanceof Moderator);
    }
}
