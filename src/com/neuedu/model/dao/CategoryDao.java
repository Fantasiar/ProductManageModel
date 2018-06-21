package com.neuedu.model.dao;

import java.util.List;

import com.neuedu.model.po.FirstCategory;
import com.neuedu.model.po.SecondCategory;

public interface CategoryDao {

	void addFirstCategory(FirstCategory fc, int operator_id);

	List<FirstCategory> searchPageFc(int pageNum);

	int searchFcPageCount();

	FirstCategory getFirstCategoryById(int fc_id);

	void updateFirstCategory(FirstCategory fc, int operator_id);

	void deleteFirstCategory(int[] ids, int operator_id);

	List<FirstCategory> searchAllFc();

	FirstCategory getFirstCategoryByName(String fc_name);

	void addSecondCategory(SecondCategory sc, int operator_id);

	List<SecondCategory> searchPageSc(int pageNum);

	int searchScPageCount();

	SecondCategory getSecondCategoryById(int sc_id);

}
