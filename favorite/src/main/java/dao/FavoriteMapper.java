package dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;

import yc.favorite.bean.Favorite;

public interface FavoriteMapper {
	@Insert("insert into favorite values(null"
			+ ",#{flabel},#{furl},#{fdesc},#{ftags})")
	@Options(useGeneratedKeys = true
			, keyColumn = "fid", keyProperty = "fid")
	int insert(Favorite f);
	List<Favorite>selectByTid(@Param("tid")Integer tid);
	
}
