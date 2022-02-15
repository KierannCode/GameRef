package fr.orsys.groupe3.gamerefback.service;

import fr.orsys.groupe3.gamerefback.business.Editor;
import fr.orsys.groupe3.gamerefback.dto.EditorDto;
import fr.orsys.groupe3.gamerefback.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EditorService {
    Editor createEditor(EditorDto dto);

    List<Editor> getEditors();

    Editor getEditor(Long id) throws NotFoundException;
}
