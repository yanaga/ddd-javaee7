package me.yanaga.ddd.javaee7.domain.model;

import java.io.Serializable;

public class InvoiceItemBuilder implements Serializable {

	private Integer code;

	private Integer amount;

	InvoiceItemBuilder() {
	}

	public InvoiceItem build() {
		return new InvoiceItem(code, amount);
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

}
