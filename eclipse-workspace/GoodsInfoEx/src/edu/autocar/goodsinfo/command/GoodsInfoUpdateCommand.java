package edu.autocar.goodsinfo.command;

import edu.autocar.base.util.Input;
import edu.autocar.goodsinfo.dao.CrudDao;
import edu.autocar.goodsinfo.dao.GoodsInfoDao;
import edu.autocar.goodsinfo.domain.GoodsInfo;

public class GoodsInfoUpdateCommand implements Command {

	@Override
	public void execute() throws Exception {
		CrudDao<GoodsInfo,String> dao = new GoodsInfoDao();
		
		System.out.println("업데이트할 상품 정보를 입력하세요.");
		String code = Input.getString("상품코드: ");
		GoodsInfo gInfo = dao.selectOne(code);
		if(gInfo == null) {
			System.out.println(code + " 상품이 존재하지 않습니다.");
			return;
		}
		
		gInfo = getGoodsinfo(gInfo);
		dao.update(gInfo);
		System.out.println("<수정 완료>");
	}
	
	public GoodsInfo getGoodsinfo(GoodsInfo gInfo) {
		
		String name = Input.getString("상품명: " , gInfo.getName());
		int price = Input.getInt("상품가격: " , gInfo.getPrice());
		String maker = Input.getString("제조사: " , gInfo.getMaker());
		
		return new GoodsInfo(gInfo.getCode(),name,price,maker);
	}

}
