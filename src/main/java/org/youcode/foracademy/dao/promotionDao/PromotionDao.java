package org.youcode.foracademy.dao.promotionDao;

import org.youcode.foracademy.models.Promotion;

import java.util.List;

public interface PromotionDao {
    public long delete(long id);
    public List<Promotion> findAll();
    public Promotion findById(long id);
    public void insert(Promotion promotion);
    public void update(Promotion promotion);
}
