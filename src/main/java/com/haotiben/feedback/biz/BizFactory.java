package com.haotiben.feedback.biz;

import com.haotiben.feedback.biz.impl.BizFactoryImpl;


public abstract class BizFactory {

	protected BizFactory() {
		super();
	}

	/**
	 * Create a factory instance
	 *
	 * @return
	 */
	public static BizFactory newInstance() throws Exception {
		return new BizFactoryImpl();
	}
	public abstract RemarkBiz getRemarkBiz()throws Exception;
}