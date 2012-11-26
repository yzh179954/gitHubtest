package com.haotiben.feedback.biz.impl;

import com.haotiben.feedback.biz.BizFactory;
import com.haotiben.feedback.biz.RemarkBiz;

public class BizFactoryImpl extends BizFactory {

	public BizFactoryImpl() {
		super();
	}

	@Override
	public RemarkBiz getRemarkBiz() throws Exception {
		return new RemarkBizImpl();
	}

}
