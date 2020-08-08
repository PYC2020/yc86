package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import yc.favorite.bean.Favorite;
import yc.favorite.bean.favoriteBiz;
import yc.favorite.util.MyBatisHelper;

@WebServlet("/addFavs.do")
public class addfav extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// 设置响应对象的字符集
		response.setCharacterEncoding("UTF-8");
		// 设置网页的字符集
		response.setContentType("text/html;charset=utf-8");
		SqlSession session=MyBatisHelper.openSession();
		favoriteBiz fb = new favoriteBiz();
		Favorite f = new Favorite();
		String flable=request.getParameter("flable");
		String furl=request.getParameter("furl");
		String ftags=request.getParameter("ftags");
		String fdesc=request.getParameter("fdesc");
		f.setFlabel(flable);
		f.setFurl(furl);
		f.setFdesc(fdesc);
		f.setFtags(ftags);
		fb.addFavorite(f);
		response.getWriter().append("添加成功！");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
