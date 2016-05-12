package com.xiaoxiong.bean;

/**
 * 
 * @ClassName: TransResultBean 
 * @Description: 翻译结果
 * @author smile
 * @date 2016年5月12日 上午11:56:24 
 *
 */
public class TransResultBean {
	private String src;
	private String dst;

	public TransResultBean(String src, String dst) {
		super();
		this.src = src;
		this.dst = dst;
	}

	public String getSrc() {
		return src;
	}

	public String getDst() {
		return dst;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	public void setDst(String dst) {
		this.dst = dst;
	}

}
