package contorller;

import java.io.Console;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HttpServletBean;

import dao.OrderDetailDao;
import dao.dinnerTableDao;
import dao1.CaixiangxiDao;
import dao1.CarDao;
import dao1.caidan_listDAO;
import dao1.caidan_someDAO;
import dao1.caixi_listDAO;
import dao1.foodtypeDAO;
import entity.Detail;
import entity.dinnerTable;
import entity1.Caixiangxi;
import entity1.caidan_list;
import entity1.caixi_list;
import entity1.foodtype;
import util.DBUtil;

@Controller
public class Contorller extends HttpServletBean {
	//禁止刷新，false为防止刷新网页，而数量菜品数量++
	private boolean isClick=true;

	@Resource(name = "abv")
	private dinnerTableDao Table;

	@RequestMapping("/toindex.web")
	public String index(HttpServletRequest req) {
		dinnerTableDao dao = new dinnerTableDao();
		List<dinnerTable> table = Table.findall();
		req.setAttribute("table", table);
		return "index";
	}

	@RequestMapping("/caidan.web")
	public String caidan(HttpServletRequest req) {
		try {
			req.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String tableId = req.getParameter("tableId");
		req.setAttribute("tableId", tableId);
		// 获取搜索的参数
		String name = req.getParameter("foodName");
		caidan_listDAO dao = new caidan_listDAO();
		foodtypeDAO dao2 = new foodtypeDAO();
		// 获取所有的菜品种
		List<foodtype> foodtype_list = dao2.findfoodtype();
		// 获取所有的菜
		// 分页功能
		String p = req.getParameter("page");
		Integer page = null;
		if (p == null || "".equals(p)) {
			page = new Integer(1);
		} else {
			page = new Integer(p);
			if (page < 1 || page > 8) {
				page = new Integer(1);
			}
		}
		int pageSize = 6;
		int start = (page - 1) * pageSize + 1;
		int end = page * pageSize;
		caidan_list caidan = new caidan_list();
		caidan.setStart(start);
		caidan.setEnd(end);
		List<caidan_list> caidan_list = dao.findcaidan(caidan);
		// 判断是不是通过搜索查询出来的菜
		if (name != null) {
			// 获取通过搜索 得到的菜
			caidan.setFoodname(name);
		} else {
			req.setAttribute("list", caidan_list);
		}
		req.setAttribute("foodtype_list", foodtype_list);
		req.setAttribute("page", page);
		req.setAttribute("searchname", name);
		return "caidan";
	}

	@RequestMapping("/caidan_search.web")
	public String caidan_search(HttpServletRequest req) {
		try {
			req.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String tableId = req.getParameter("tableId");
		req.setAttribute("tableId", tableId);
		caidan_someDAO dao_2 = new caidan_someDAO();
		foodtypeDAO dao2 = new foodtypeDAO();
		// 获取所有的菜品种
		List<foodtype> foodtype_list = dao2.findfoodtype();
		// 获取搜索的参数
		String name = req.getParameter("foodName");
		String p = req.getParameter("page");
		Integer page = null;
		if (p == null || "".equals(p)) {
			page = new Integer(1);
		} else {
			page = new Integer(p);
			if (page < 1 || page > 8) {
				page = new Integer(1);
			}
		}
		int pageSize = 6;
		int start = (page - 1) * pageSize + 1;
		int end = page * pageSize;
		caidan_list caidan = new caidan_list();
		caidan.setStart(start);
		caidan.setEnd(end);
		caidan.setFoodname(name);
		List<caidan_list> caidan_some = dao_2.findsome(caidan);
		req.setAttribute("list", caidan_some);
		req.setAttribute("page", page);
		req.setAttribute("name", name);
		req.setAttribute("foodtype_list", foodtype_list);
		return "caidan_search";
	}

	@Resource(name = "cai")
	private CaixiangxiDao caixiangxi;

	@RequestMapping("caixiangxi.web")
	public String caixiangxi(HttpServletRequest req) {
		String tableId = req.getParameter("tableId");
		req.setAttribute("tableId", tableId);
		foodtypeDAO dao2 = new foodtypeDAO();
		// 获取所有的菜品种
		List<foodtype> foodtype_list = dao2.findfoodtype();
		int id = Integer.valueOf(req.getParameter("id"));
		req.setAttribute("id", id);
		Caixiangxi list = caixiangxi.findById(id);
		req.setAttribute("caipin", list);
		req.setAttribute("foodtype_list", foodtype_list);
		isClick=true;
		return "caixiangxi";
	}

	@RequestMapping("/chuancai.web")
	public String chuancai(HttpServletRequest req) {
		String tableId = req.getParameter("tableId");
		req.setAttribute("tableId", tableId);
		String caixi = req.getParameter("caixi");
		String p = req.getParameter("page");
		Integer page = null;
		foodtypeDAO dao2 = new foodtypeDAO();
		// 获取所有的菜品种
		List<foodtype> foodtype_list = dao2.findfoodtype();
		if (p == null || p.equals("")) {
			page = new Integer(1);
		} else {
			page = new Integer(p);
			if (page < 1 || page > 8) {
				page = new Integer(1);
			}
		}
		caixi_list clist = new caixi_list();
		clist.setFoodname(caixi);
		int pagesize = 6;
		int start = (page - 1) * pagesize + 1;
		int end = page * pagesize;
		clist.setStart(start);
		clist.setEnd(end);
		clist.setFoodtype_id(caixi);
		caixi_listDAO dao = new caixi_listDAO();
		List<caixi_list> list = dao.findcaixi(clist);
		req.setAttribute("caixi", list);
		req.setAttribute("caixi2", caixi);
		req.setAttribute("page", page);
		req.setAttribute("foodtype_list", foodtype_list);
		return "chuancai";
	}

	// 购物车按钮
	//一.添数据到数据库 ，重复的菜品，加数量，没有则添加菜品
	@RequestMapping("/clientCart.web")
	public void clientCart(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int tableId = Integer.valueOf(req.getParameter("tableId"));
		req.setAttribute("tableId", tableId);
		int foodid = Integer.valueOf(req.getParameter("foodid"));
		String f = req.getParameter("isClick");
		System.out.println("203isClick:"+f);
		
		CarDao dao = new CarDao();
		// 判断这个订单是否预订了该菜品（即：判断菜名是否点过）
		Boolean flag = dao.findByfoodid(tableId, foodid);
		if (flag == true) {
			// 点过这个菜
			// 1.从数据库获取该菜的数量
			// 2.判断是否刷新网页，isClick＝true,表示数量+1
			if(isClick){
					//3.从数据中读取原来的菜品数量，然后自增+1
					int foodcount = dao.getFoodNumber(tableId, foodid);
					++foodcount;
					//4.执行sql语句修改数量
					dao.saveNumber(foodcount, tableId, foodid);
					//5.修改状态，刷新网页时不允许数量++
					isClick=false;
			}
		} else {
			// 未点过这个菜
			//1.先判断订单表是否存在餐桌id,false则执行添加该餐桌id到dd_id字段
			Boolean dd_id = dao.findByDdid(tableId);
			if(!dd_id){
				//2.不存在(false)，在订单表插入数据
				//订单id,  餐桌名，  时间，总金额，状态(付款)
				//(dd_id,  orderid,  null,  null,    0)
				dao.CreateDd_id(tableId);
			}
			//3.添加菜品到详细表
			dao.save(tableId, foodid);
			//4.修改状态，刷新网页时不允许数量++
			isClick=false;
		}
		//转发
		req.getRequestDispatcher("scarlist.web").forward(req,res);
	}
	//二.打开购物车页面
	@RequestMapping("/scarlist.web")
	public String scarlist(HttpServletRequest req, HttpServletResponse res){
		int tableId = Integer.valueOf(req.getParameter("tableId"));
		int foodid = Integer.valueOf(req.getParameter("foodid"));
		req.setAttribute("tableId", tableId);
		CarDao dao = new CarDao();
		foodtypeDAO dao2 = new foodtypeDAO();
		List<foodtype> foodtype_list = dao2.findfoodtype();
		req.setAttribute("foodtype_list", foodtype_list);
		List<Detail> list = dao.findAll(tableId);
		req.setAttribute("listcar", list);
		return  "clientCart";
	}
	//删除菜品
	@RequestMapping("/removeSorder.web")
	public void removeSorder(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int tableId = Integer.valueOf(req.getParameter("tableId"));
		int foodid = Integer.valueOf(req.getParameter("foodid"));
		System.out.println("removeSorder-tableId"+tableId);
		CarDao dao = new CarDao();
		dao.delete(tableId, foodid);
		//转发
		req.getRequestDispatcher("scarlist.web").forward(req,res);
	}
	//修改菜品数量
	@RequestMapping("/alterSorder.web")
	public String alterSorder(HttpServletRequest req, HttpServletResponse res) {
		int tableId = Integer.valueOf(req.getParameter("tableId"));
		int foodid = Integer.valueOf(req.getParameter("foodid"));
		int number = Integer.valueOf(req.getParameter("number"));
		req.setAttribute("tableId", tableId);
		CarDao dao = new CarDao();
		dao.saveNumber(number, tableId, foodid);
		foodtypeDAO dao2 = new foodtypeDAO();
		List<foodtype> foodtype_list = dao2.findfoodtype();
		req.setAttribute("foodtype_list", foodtype_list);
		List<Detail> list = dao.findAll(tableId);
		req.setAttribute("listcar", list);
		return "clientCart";
	}


	// 清单列表按钮
	@RequestMapping("/clientOrderList.web")
	public String clientOrderList(HttpServletRequest req, HttpServletResponse res) {
		int tableId = Integer.valueOf(req.getParameter("tableId"));
		//System.out.println("tableId" + tableId);
		req.setAttribute("tableId", tableId);
		
		CarDao dao = new CarDao();
		List<Detail> list = dao.findAll(tableId);
		foodtypeDAO dao2 = new foodtypeDAO();
		List<foodtype> foodtype_list = dao2.findfoodtype();
		req.setAttribute("foodtype_list", foodtype_list);
		req.setAttribute("list", list);
		dao.updateState(tableId);
		return "clientOrderList";
	}

	// 结账
	@RequestMapping("/jiezhang.web")
	public String jiezhang(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		double totalPrice = Double.valueOf(req.getParameter("totalPrice"));
		int tableId = Integer.valueOf(req.getParameter("tableId"));
		CarDao dao = new CarDao();
		dao.payMent(totalPrice, tableId);
		return "jiezhang";
	}
}
