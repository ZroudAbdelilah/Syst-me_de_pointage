package org.youcode.foracademy.interfaces;

import org.youcode.foracademy.models.Promotion;

import java.util.List;

public interface PromotionDao {
    public boolean delete(long id);
    public List<Promotion> findAll();
    public Promotion findById(long id);
    public Promotion insert(Promotion promotion);
    public Promotion update(Promotion promotion);
}
