package cn.it.hotel.action;

import java.util.HashMap;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import cn.it.hotel.model.Business;
import cn.it.hotel.model.Room;

@Controller
@Scope("prototype")
public class BusinessAction extends BaseAction<Business> {

	public String queryJoinRoomAndRoomcategoryAndClientAndUser(){
		pageMap=new HashMap<String, Object>();
		System.out.println("bname:"+model.getBname());
		List<Business> businessList=businessService.queryJoinRoomAndRoomcategoryAndClientAndUser(model.getBname(), page, rows);
		pageMap.put("rows", businessList);
		pageMap.put("total", businessService.getCount(model.getBname()));
		return "jsonMap";
	}
	
	//查询营业收入
	public String queryIncome(){
		List<Object> jsonList=businessService.queryIncome(model.getBnumber());
		//直接将jsonList放到栈顶（好处：简单不用配）
		ActionContext.getContext().getValueStack().push(jsonList);
		return "jsonList";
	}
	
	//查询销量
	public String querySale(){
		List<Object> jsonList=businessService.querySale(model.getBnumber());
		//直接将jsonList放到栈顶（好处：简单不用配）
		ActionContext.getContext().getValueStack().push(jsonList);
		return "jsonList";
	}
	
	//查询预定量
	public String queryOrderin(){
		List<Object> jsonList=businessService.queryOrderin(model.getBnumber());
		//直接将jsonList放到栈顶（好处：简单不用配）
		ActionContext.getContext().getValueStack().push(jsonList);
		return "jsonList";
	}
	
	//查询销量
	public String queryOrderout(){
		List<Object> jsonList=businessService.queryOrderout(model.getBnumber());
		//直接将jsonList放到栈顶（好处：简单不用配）
		ActionContext.getContext().getValueStack().push(jsonList);
		return "jsonList";
	}
}
