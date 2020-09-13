package dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import bean.Category;

public interface CategoryMapper {

	@Select("select * from category")
	List<Category> selectAll();
}
