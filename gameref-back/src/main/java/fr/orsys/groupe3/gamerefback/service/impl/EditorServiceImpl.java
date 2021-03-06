package fr.orsys.groupe3.gamerefback.service.impl;

import fr.orsys.groupe3.gamerefback.business.Editor;
import fr.orsys.groupe3.gamerefback.dao.EditorDao;
import fr.orsys.groupe3.gamerefback.business.dto.EditorDto;
import fr.orsys.groupe3.gamerefback.exception.NotFoundException;
import fr.orsys.groupe3.gamerefback.business.mapper.EditorMapper;
import fr.orsys.groupe3.gamerefback.service.EditorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EditorServiceImpl implements EditorService {
    private EditorMapper editorMapper;

    private EditorDao editorDao;

    @Override
    public Editor createEditor(EditorDto dto) {
        Editor editor = new Editor();
        editorMapper.mapEditor(editor, dto);
        return editorDao.save(editor);
    }

    @Override
    public Editor getEditor(Long id) throws NotFoundException {
        return editorDao.findById(id).orElseThrow(() -> new NotFoundException("editor", "Aucun éditeur trouvé avec l'id " + id));
    }

    @Override
    public List<Editor> getEditors() {
        return editorDao.findAll();
    }
}
