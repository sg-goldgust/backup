package edu.autocar.goodsinfo.command;

import edu.autocar.base.util.Input;
import edu.autocar.goodsinfo.dao.CrudDao;
import edu.autocar.goodsinfo.dao.GoodsInfoDao;
import edu.autocar.goodsinfo.domain.GoodsInfo;

public class GoodsInfoDeleteCommand implements Command {

	
	@Override
	public void execute() throws Exception {
		
		String k = Input.getString("삭제할 키를 입력하세요.");
		CrudDao<GoodsInfo,String> dao = new GoodsInfoDao();
		int result = dao.delete(k);
		
		if (result == 1) {
			System.out.println("삭제");
		} else {
			System.out.println("없다");
		}
		
//		(result == 1) ? System.out.println("삭제") : System.out.println("없다");
	}
	
	
}
