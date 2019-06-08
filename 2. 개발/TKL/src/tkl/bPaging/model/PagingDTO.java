package tkl.bPaging.model;

import java.sql.*;

public class PagingDTO {
	private int crrentPage;
	private int cp;
	private int curBlock;
	private int curPage;
	private int tableRowNum;
	private int pageSizePerBlock;
	private int totalRecodeSize;
	private int beginNum;
	private int pageSize;
	private int startPage;
	private int endPage;
	
	PagingDTO(){}

	public PagingDTO(int crrentPage, int cp, int curBlock, int curPage, int tableRowNum, int pageSizePerBlock,
			int totalRecodeSize, int beginNum, int pageSize, int startPage, int endPage) {
		super();
		this.crrentPage = crrentPage;
		this.cp = cp;
		this.curBlock = curBlock;
		this.curPage = curPage;
		this.tableRowNum = tableRowNum;
		this.pageSizePerBlock = pageSizePerBlock;
		this.totalRecodeSize = totalRecodeSize;
		this.beginNum = beginNum;
		this.pageSize = pageSize;
		this.startPage = startPage;
		this.endPage = endPage;
	}

	public int getCrrentPage() {
		return crrentPage;
	}

	public void setCrrentPage(int crrentPage) {
		this.crrentPage = crrentPage;
	}

	public int getCp() {
		return cp;
	}

	public void setCp(int cp) {
		this.cp = cp;
	}

	public int getCurBlock() {
		return curBlock;
	}

	public void setCurBlock(int curBlock) {
		this.curBlock = curBlock;
	}

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public int getTableRowNum() {
		return tableRowNum;
	}

	public void setTableRowNum(int tableRowNum) {
		this.tableRowNum = tableRowNum;
	}

	public int getPageSizePerBlock() {
		return pageSizePerBlock;
	}

	public void setPageSizePerBlock(int pageSizePerBlock) {
		this.pageSizePerBlock = pageSizePerBlock;
	}

	public int getTotalRecodeSize() {
		return totalRecodeSize;
	}

	public void setTotalRecodeSize(int totalRecodeSize) {
		this.totalRecodeSize = totalRecodeSize;
	}

	public int getBeginNum() {
		return beginNum;
	}

	public void setBeginNum(int beginNum) {
		this.beginNum = beginNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	
	
}
