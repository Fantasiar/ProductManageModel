package com.neuedu.model.dao;

import java.util.List;

import com.neuedu.model.po.FirstCategory;

public interface CategoryDao {

	void addFirstCategory(FirstCategory fc, int operator_id);

	List<FirstCategory> searchPageFc(int pageNum);

	int searchFcPageCount();

	FirstCategory getFirstCategoryById(int fc_id);

	void updateFirstCategory(FirstCategory fc, int operator_id);

	void deleteFirstCategory(int[] ids, int operator_id);

}
