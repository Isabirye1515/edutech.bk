package org.edutech.parent.services;

import java.util.List;
import org.edutech.parent.valueholder.dto.ParentDTO;

public interface ParentService {

  void saveParent(ParentDTO dto);

  ParentDTO getParentById(int id);

  void updateParent(ParentDTO dto);

  void deleteParent(int id);

  List<ParentDTO> getAllParents();
}
