package paging;

import java.util.ArrayList;
import java.util.List;

public class Paging {

	// 모든 객체는 Object 를 상속
	private Object data;			    // 화면에 출력할 페이지 데이터(TopN 쿼리로 조회한 데이터)
	private List<Integer> pageList; 	// 전체 페이지 번호가 있는 리스트 
	private int currentPageNumber = 1;  // 현재 페이지 번호
	private int lastPageNumber;     	// 마지막 페이지 번호
	private int pageLimit = 10;		    // 화면에 출력할 목록 제한 수
	private int listLimit = 5;		    // 화면에 출력할 페이지 번호 제한 수
	
	public Paging(Object data, int lastPageNumber) {
		this(data, 1, lastPageNumber);
		setPageList();
	}
	

	private Paging(Object data, int currentPageNumber, int lastPageNumber) {
		this.data = data;
		this.lastPageNumber = lastPageNumber;
		this.currentPageNumber = currentPageNumber;
	} // 외부 공개 안할 생성자라 private
	
	public Paging(Object data, int currentPageNumber, int lastPageNumber, int pageLimit, int listLimit) {
		this(data, currentPageNumber, lastPageNumber);
		this.pageLimit = pageLimit;
		this.listLimit = listLimit;
		setPageList();
	}
	
	private void setPageList() {
		// 현재 페이지 번호, 마지막 페이지 번호, 페이지 번호 제한 수를 이용하여
		// 페이지 번호 목록을 생성
		// 현재 페이지가 : 1, 마지막 페이지 번호 : 10, 페이지 번호 제한 : 5
		// [1, 2, 3, 4, 5]
		// 현재 페이지가 : 3, 마지막 페이지 번호 : 10, 페이지 번호 제한 : 5
		// [3, 4, 5, 6, 7]
		// 현재 페이지가 : 7, 마지막 페이지 번호 : 10, 페이지 번호 제한 : 5
		// [7, 8, 9, 10]
		this.pageList = new ArrayList<Integer>();
		int max = this.currentPageNumber + this.listLimit - 1;
		if(max > this.lastPageNumber) {
			max = this.lastPageNumber;
		}
		for(int i = this.currentPageNumber; i <= max; i++) {
			pageList.add(i);
		}
	}
	
	public List<Integer> getPageList() {
		return this.pageList;
	}
	
	public Object getData() {
		return data;
	}
	
	public int getCurrentPageNumber() {
		return currentPageNumber;
	}
	
	public int getPrevPageNumber() {
		// 현재 페이지 3, 이전 페이지 2
		// 현재 페이지 1, 이전 페이지 0 -> -1로 변경하여 반환
		int prevPage = currentPageNumber - 1;
		return prevPage == 0 ? -1 : prevPage;
	}
	
	public int getNextPageNumber() {
		// 현재 페이지 3, 다음 페이지 4, 마지막 페이지 10
		// 현재 페이지 10, 다음 페이지 11, 마지막 페이지 10 -> -1로 변경하여 반환
		int nextPage = currentPageNumber + 1;
		return nextPage > lastPageNumber ? -1 : nextPage;
	}
	
	public int getLastPageNumber() {
		return lastPageNumber;
	}
	
	public int getPageLimit() {
		return pageLimit;
	}
}
	
