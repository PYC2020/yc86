package dao;


import org.apache.ibatis.annotations.Insert;

import yc.favorite.bean.TagFavorite;

public interface TagFavoriteMapper {
	@Insert("insert into tagfavorite values(#{tid},#{fid})")
	int insert(TagFavorite f);
}
