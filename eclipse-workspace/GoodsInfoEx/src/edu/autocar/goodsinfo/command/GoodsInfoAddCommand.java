package edu.autocar.goodsinfo.command;

import edu.autocar.base.util.Input;
import edu.autocar.goodsinfo.dao.CrudDao;
import edu.autocar.goodsinfo.dao.GoodsInfoDao;
import edu.autocar.goodsinfo.domain.GoodsInfo;

public class GoodsInfoAddCommand implements Command {

	
	@Override
	public void execute() throws Exception {
		System.out.println("추가 상품 정보를 입력하세요.");
		GoodsInfo gInfo = getGoodsInfo();
		CrudDao<GoodsInfo,String> dao = new GoodsInfoDao();
		dao.insert(gInfo);
	}
	
	public GoodsInfo getGoodsInfo() {
		String code = Input.getString("상품코드: ");
		String name = Input.getString("상품명: ");
		int price = Input.getInt("상품가격: ");
		String maker = Input.getString("제조사: ");
		return new GoodsInfo(code,name,price,maker);
	}

}
