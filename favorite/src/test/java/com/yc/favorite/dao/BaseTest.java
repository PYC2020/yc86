package com.yc.favorite.dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import dao.FavoriteMapper;
import dao.TagFavoriteMapper;
import dao.TagMapper;
import yc.favorite.bean.Favorite;
import yc.favorite.bean.favoriteBiz;
import yc.favorite.util.MyBatisHelper;

public class BaseTest {
//	@Test
//	public void test1() {
//		SqlSession session=MyBatisHelper.openSession();
//		FavoriteMapper fm=session.getMapper(FavoriteMapper.class);
//		TagMapper tm=session.getMapper(TagMapper.class);
//		TagFavoriteMapper tfm=session.getMapper(TagFavoriteMapper.class);
//		
//		Favorite f=new Favorite();
//		f.setFlabel("淘宝");
//		f.setFurl("taobao.com");
//		f.setFdesc("败家网站");
//		f.setFtags("购物生活");
//		fm.insert(f);
//		session.commit();
//		session.close();
//	}
//	@Test
//	public void test2() {
//		favoriteBiz fb = new favoriteBiz();
//		Favorite f = new Favorite();
//		f.setFlabel("淘宝");
//		f.setFurl("taobao.com");
//		f.setFdesc("败家网站");
//		f.setFtags("购物,生活");
//		fb.addFavorite(f);
//	}
//	@Test
//	public void test3() {
//		favoriteBiz fb = new favoriteBiz();
//		Favorite f = new Favorite();
//		f.setFlabel("网易");
//		f.setFurl("163.com");
//		f.setFdesc("好网站");
//		f.setFtags("门户,军事,生活");
//		fb.addFavorite(f);
//	}
	@Test
	public void test4() {
		SqlSession session=MyBatisHelper.openSession();
		FavoriteMapper fm=session.getMapper(FavoriteMapper.class);
		fm.selectByTid(null);
		fm.selectByTid(1);
		fm.selectByTid(0);
	}
}
