package day08Prac;

public class PageHandler {
	int pageSize; //한 페이지에 레코드 수
	int grpSize; //그룹의 사이즈
	int totRecords; //전체 레코드 수
	int currentPage; //현재 페이지
	int currentGrp; //현재 그룹
	int grpEndPage; //그룹의 끝
	int grpStartPage; //그룹의 시작
	int totalPage; //전체 페이지 수
	
	public PageHandler(int pageSize, int grpSize, int totRecords, int currentPage) {
		this.pageSize = pageSize;
		this.grpSize = grpSize;
		this.totRecords = totRecords;
		this.currentPage = currentPage;
		calc();
	}
	
	private void calc() {
		
		int remain = totRecords%pageSize;
		
		if(remain==0) {
			totalPage = totRecords/pageSize;
		}else {
			totalPage = totRecords/pageSize+1;
		}
		
		//현재 페이지에 대한 현재그룹 구하기
		int ramain2 = currentPage%grpSize;
		
		if(ramain2==0) {
			currentGrp = currentPage/grpSize;
		} else {
			currentGrp = currentPage/grpSize+1;
		}
		
		//현재 그룹의 시작, 끝
		grpEndPage = currentGrp*grpSize;
		grpStartPage = (currentGrp-1)*grpSize+1;
		
		//마지막 확인 (그룹의 마지막 페이지가 전제 페이지수보다 크다면 그룹의 마지막을 전체페이지수로 변경한다)
		if(grpEndPage>totalPage) {
			grpEndPage=totalPage;
		}
	}
	
	public int getPageSize() {
		return pageSize;
	}

	public int getGrpSize() {
		return grpSize;
	}

	public int getTotRecords() {
		return totRecords;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public int getCurrentGrp() {
		return currentGrp;
	}

	public int getGrpEndPage() {
		return grpEndPage;
	}

	public int getGrpStartPage() {
		return grpStartPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public static void main(String[] args) {
		PageHandler p = new PageHandler(5,4,33,6);
		
		int currentGrp = p.getCurrentGrp();
		int grpStart = p.getGrpStartPage();
		int grpEnd = p.getGrpEndPage();
		
		System.out.println(currentGrp);
		System.out.println(grpStart);
		System.out.println(grpEnd);
	}
}
