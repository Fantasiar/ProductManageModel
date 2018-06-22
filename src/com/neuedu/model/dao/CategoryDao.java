package com.neuedu.model.dao;

import java.util.List;

import com.neuedu.model.po.FirstCategory;
import com.neuedu.model.po.SecondCategory;
import com.neuedu.model.po.Supplier;

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

	void updateSecondCategory(SecondCategory sc, int operator_id);

	void deleteSecondCategory(int[] ids, int operator_id);

	List<SecondCategory> searchScByFcId(int fc_id);

	List<Supplier> searchAllSup();

	SecondCategory getSecondCategoryByName(String sc_name);

	String searchFcNameById(int fc_id);

	String searchScNameById(int sc_id);

}
