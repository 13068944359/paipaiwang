package com.paipaiwang.po;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 封装分页数据
 * @author xiaojiazhou
 * @version 1.0.0
 */
public class Page<T> implements Serializable {

	private static final long serialVersionUID = 337297181251071639L;
	
	private Integer page=1;//当前页
	private Integer rows=5;//页大小
	private Integer totalRecord;// 总记录 数
	private List<T> list;//页面数据列表
	private String keyWord;//查询关键字；设备管理中，代表的是当前要查询的设备历史的设备id；
	private Map<String,Object> keyWordMap = new HashMap<String, Object>() ;//查询关键字组合
	private Integer start;//需要这里处理
	private Map<String, Object> pageMap = new HashMap<String, Object>() ;

	private Integer lastPage;//setTotalRecord时赋值
	private Integer nextPage;//setTotalRecord时赋值
	private Integer totalPage;//setTotalRecord时赋值
	
	public Map<String, Object> getKeyWordMap() {
		this.start = (page-1)*rows;
		keyWordMap.put("start", start);
		keyWordMap.put("rows", rows);
		return keyWordMap;
	}

	public void setPageMap(Map<String, Object> pageMap) {
		this.pageMap = pageMap;
	}

	public void setKeyWordMap(Map<String, Object> keyWordMap) {
		this.keyWordMap = keyWordMap;
	}

	public Map<String, Object> getPageMap() {
		return pageMap;
	}
	
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getRows() {
		return rows;
	}
	public void setRows(Integer rows) {
		this.rows = rows;
	}
	public Integer getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(Integer totalRecord) {
		
		if( page!=1 ){			
			lastPage = page - 1;		//如果等于1，则不为null值，也就是上一页按钮有效
		}else{
			lastPage = 1;
		}
		totalPage = totalRecord%rows == 0?totalRecord/rows:totalRecord/rows+1;//计算出总页数（向上取整）
		if(totalPage != page){	
			nextPage = page+1;	//如果当前页等于总页数，则不为null值，也就是下一页按钮有效
		}else{
			nextPage = page;
		}
		
		this.totalRecord = totalRecord;

		pageMap.put("totalPage", totalPage);
		pageMap.put("page", page);
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		pageMap.put("rows", list);
		this.list = list;
	}
	public String getKeyWord() {
		return keyWord;
	}
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	public Integer getStart() {
		this.start = (page-1)*rows;
		return start;
	}
	public void setStart(Integer start) {
		this.start = start;
	}
	public final Integer getLastPage() {
		return lastPage;
	}
	public final Integer getNextPage() {
		return nextPage;
	}
	public final Integer getTotalPage() {
		return totalPage;
	}

	@Override
	public String toString() {
		return "Page [page=" + page + ", rows=" + rows + ", totalRecord="
				+ totalRecord + ", list=" + list + ", keyWord=" + keyWord
				+ ", keyWordMap=" + keyWordMap + ", start=" + start
				+ ", pageMap=" + pageMap + ", lastPage=" + lastPage
				+ ", nextPage=" + nextPage + ", totalPage=" + totalPage + "]";
	}
	
	
}
