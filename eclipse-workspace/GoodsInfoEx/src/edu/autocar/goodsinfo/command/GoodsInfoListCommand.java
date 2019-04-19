package edu.autocar.goodsinfo.command;

import java.util.List;

import edu.autocar.goodsinfo.dao.CrudDao;
import edu.autocar.goodsinfo.dao.GoodsInfoDao;
import edu.autocar.goodsinfo.domain.GoodsInfo;

public class GoodsInfoListCommand implements Command {


	@Override
	public void execute() throws Exception {
		CrudDao<GoodsInfo,String> dao = new GoodsInfoDao();
		List<GoodsInfo> list = dao.selectlist();
		print(list);

	}
	
	public void print(List<GoodsInfo> list) {
		System.out.println("상품코드 상품명 \t\t가격 제조사");
		System.out.println("--------------------------------------");
		
		for(GoodsInfo gi : list) {
			System.out.printf("%8s %s \t%12d %s%n",
					gi.getCode(), gi.getName(),
					gi.getPrice(), gi.getMaker());
		}
		System.out.println("---------------------------------------");
		
	}

}
