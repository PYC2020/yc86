package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.google.gson.Gson;

import dao.FavoriteMapper;
import dao.TagMapper;
import yc.favorite.util.MyBatisHelper;

@WebServlet("/queryFavs.do")
public class QueryFanvs extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// 设置响应对象的字符集
		response.setCharacterEncoding("UTF-8");
		// 设置网页的字符集
		response.setContentType("text/html;charset=utf-8");
		SqlSession session=MyBatisHelper.openSession();
		
		FavoriteMapper tm=session.getMapper(FavoriteMapper.class);
		String sTid=request.getParameter("tid");
		Integer iTid;
		if(sTid==null||sTid.trim().isEmpty()||"null".equals(sTid)) {
			iTid=null;
		}else {
			iTid=Integer.valueOf(sTid);
		}
		Gson gson=new Gson();
		String json=gson.toJson(tm.selectByTid(iTid));
		response.getWriter().append(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
