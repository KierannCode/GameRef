package fr.orsys.groupe3.gamerefback.business.mapper;

import fr.orsys.groupe3.gamerefback.business.Editor;
import fr.orsys.groupe3.gamerefback.business.dto.EditorDto;
import org.springframework.stereotype.Component;

@Component
public class EditorMapper {
    public Editor mapEditor(Editor editor, EditorDto dto) {
        if (dto.getName() != null) {
            editor.setName(dto.getName());
        }
        return editor;
    }
}
