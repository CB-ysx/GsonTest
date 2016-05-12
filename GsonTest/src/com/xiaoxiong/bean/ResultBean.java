package com.xiaoxiong.bean;

import java.util.List;

/**
 * 
 * @ClassName: ResultBean 
 * @Description: 百度翻译返回的信息
 * @author smile
 * @date 2016年5月12日 上午11:54:35 
 *
 */
public class ResultBean {
	private String from;
	private String to;
	private List<TransResultBean> trans_result;

	public ResultBean(String from, String to, List<TransResultBean> trans_result) {
		super();
		this.from = from;
		this.to = to;
		this.trans_result = trans_result;
	}

	public String getFrom() {
		return from;
	}

	public String getTo() {
		return to;
	}

	public List<TransResultBean> getTransResult() {
		return trans_result;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public void setTransResult(List<TransResultBean> trans_result) {
		this.trans_result = trans_result;
	}

}
