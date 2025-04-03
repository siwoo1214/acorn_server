package acorn;

import java.util.ArrayList;

//

public class AcornService {

	AcornDAO dao  = new AcornDAO();
	
	//회원정보 등록하기
	public void registerMember( Acorn acorn ) {		
		
		// 
		dao.insertMember(acorn);
		
		
	}
	
	public ArrayList<Acorn> getMemberList(){
		ArrayList<Acorn> list = dao.selectAll();
		
		System.out.println(list);
		return list;
	}
	
	public Acorn getMemberInfo(String id) {
		Acorn acorn = dao.selectOne(id);
		return acorn;
	}
	
	public void modifyMember(String id, String pw) {
		dao.update(id, pw);
	}
	
	//회원 삭제하기
	public void deleteMember(String id) {
		dao.delete(id);
		
	}
}
