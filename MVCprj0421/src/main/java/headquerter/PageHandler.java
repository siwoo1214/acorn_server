package headquerter;

public class PageHandler {
	int pageSize;
	int grpSize;
	int totRecords;
	int currentPage;
	int currentGrp;
	int grpEndPage;
	int grpStartPage;
	int totalPage;
	
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
		
		int ramain2 = currentPage%grpSize;
		
		if(ramain2==0) {
			currentGrp = currentPage/grpSize;
		} else {
			currentGrp = currentPage/grpSize+1;
		}
		
		grpEndPage = currentGrp*grpSize;
		grpStartPage = (currentGrp-1)*grpSize+1;
		
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
