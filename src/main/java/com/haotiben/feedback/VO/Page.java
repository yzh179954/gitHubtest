package com.haotiben.feedback.VO;

import java.io.Serializable;

public class Page implements Serializable {
	private static final long serialVersionUID = 1L;
	private int rowTotal;// 总记录数
	private int pageSize = 3;// 每页记录数
	private int count;// 当前页码
	private int total;// 总页数
	private int beginIndex;// 起始记录下标
	private int endIndex;// 截止记录下标

	/**
	 * 使用总记录数、当前页码构造
	 *
	 * @param rowTotal
	 * @param count
	 *            页码，从1开始
	 */
	public Page(int totalRow, int count) {
		this.rowTotal = totalRow;
		this.count = count;
		calculate();
		System.out.println("rowTotal =" + rowTotal + " count = " + count
				+ " total = " + total + " beginIndex = " + beginIndex
				+ " endIndex = " + endIndex);
	}

	/**
	 * 使用总记录数、当前页码和每页记录数构造
	 *
	 * @param rowTotal
	 * @param count
	 *            页码，从1开始
	 * @param pageSize
	 *            默认30条
	 */
	public Page(int totalRow, int count, int pageSize) {
		this.rowTotal = totalRow;
		this.count = count;
		this.pageSize = pageSize;
		calculate();
		System.out.println("rowTotal = " + rowTotal + " count = " + count
				+ " total = " + total + " beginIndex = " + beginIndex
				+ " endIndex = " + endIndex);
	}

	private void calculate() {
		if (rowTotal < pageSize)
			total = 1;
		else
			total = rowTotal / pageSize + ((rowTotal % pageSize) > 0 ? 1 : 0);

		if (count > total) {
//			count = total;
		} else if (count < 1) {
			count = 1;
		}

		if (count == 1)
			beginIndex = 0;
		else
			beginIndex = (count - 1) * pageSize;

		endIndex = beginIndex + pageSize;
		if (endIndex > rowTotal) {
			endIndex = rowTotal;
		}
	}

	public int getCount() {
		return count;
	}

	public int getTotal() {
		return total;
	}

	public int getTotalRow() {
		return rowTotal;
	}

	public int getPageSize() {
		return pageSize;
	}

	public int getBeginIndex() {
		return beginIndex;
	}

	public int getEndIndex() {
		return endIndex;
	}

}
