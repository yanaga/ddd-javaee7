package me.yanaga.ddd.javaee7.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class InvoiceItem implements Serializable {

	@Id
	@GeneratedValue
	private Long id;

	private Integer code;

	private Integer amount;

	protected InvoiceItem() {
	}

	InvoiceItem(Integer code, Integer amount) {
		this.code = code;
		this.amount = amount;
	}

	public static InvoiceItemBuilder builder() {
		return new InvoiceItemBuilder();
	}

	public Integer getCode() {
		return code;
	}

	public Integer getAmount() {
		return amount;
	}

}
