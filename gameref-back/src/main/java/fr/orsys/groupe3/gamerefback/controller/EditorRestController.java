package fr.orsys.groupe3.gamerefback.controller;

import fr.orsys.groupe3.gamerefback.business.Editor;
import fr.orsys.groupe3.gamerefback.service.EditorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", maxAge = 3600)
@AllArgsConstructor
public class EditorRestController {

    private EditorService editorService;


    @GetMapping("/editors")
    public List<Editor> getEditors() {
        return editorService.getEditors();
    }
}
