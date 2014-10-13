package me.yanaga.ddd.javaee7.domain.model;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.Optional;

import static com.google.common.base.Preconditions.checkNotNull;

@Entity
public class Invoice {

	@Id
	@GeneratedValue
	private Long id;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable
	private List<InvoiceItem> items = Lists.newLinkedList();

	protected Invoice() {
	}

	public static Invoice of() {
		return new Invoice();
	}

	public Long getId() {
		return id;
	}

	public List<InvoiceItem> getItems() {
		return ImmutableList.copyOf(items);
	}

	public void addItem(InvoiceItem item) {
		checkNotNull(item);
		Optional<InvoiceItem> repeated = items.stream().filter(i -> i.getCode().equals(item.getCode())).findAny();
		items.add(repeated.map(i -> {
			items.remove(i);
			return new InvoiceItem(i.getCode(), i.getAmount() + item.getAmount());
		}).orElse(item));
	}

	public Integer getTotal() {
		return items.stream().mapToInt(InvoiceItem::getAmount).sum();
	}

}
