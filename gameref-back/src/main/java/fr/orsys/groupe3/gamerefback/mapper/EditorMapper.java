package fr.orsys.groupe3.gamerefback.mapper;

import fr.orsys.groupe3.gamerefback.business.Editor;
import fr.orsys.groupe3.gamerefback.dto.EditorDto;
import org.springframework.stereotype.Component;

@Component
public class EditorMapper {
    public Editor mapEditor(Editor editor, EditorDto dto) {
        editor.setName(dto.getName());
        return editor;
    }
}
