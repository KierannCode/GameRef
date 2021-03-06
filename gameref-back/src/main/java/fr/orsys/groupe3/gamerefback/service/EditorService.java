package fr.orsys.groupe3.gamerefback.service;

import fr.orsys.groupe3.gamerefback.business.Editor;
import fr.orsys.groupe3.gamerefback.business.dto.EditorDto;
import fr.orsys.groupe3.gamerefback.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EditorService {
    Editor createEditor(EditorDto dto);

    Editor getEditor(Long id) throws NotFoundException;

    List<Editor> getEditors();
}
