package info.webappborysevychlab_2.dao;

import java.util.List;

public interface InterfaceDAO<Entity> {
    List<Entity> getAllList();
    Entity findById(Long id);
    boolean insert(Entity entityToInsert);
    boolean update(Long idOfUpdatableRow, Entity entityToUpdate);
    boolean delete(Entity entityToDelete);
}
