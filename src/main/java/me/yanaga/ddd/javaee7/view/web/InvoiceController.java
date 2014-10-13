package me.yanaga.ddd.javaee7.view.web;

import me.yanaga.ddd.javaee7.domain.model.Invoice;
import me.yanaga.ddd.javaee7.domain.model.InvoiceItem;
import me.yanaga.ddd.javaee7.domain.model.InvoiceItemBuilder;
import me.yanaga.ddd.javaee7.domain.model.InvoiceRepository;
import me.yanaga.ddd.javaee7.domain.model.QInvoice;
import me.yanaga.ddd.javaee7.domain.model.QInvoiceItem;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@Stateless
public class InvoiceController {

	@Inject
	InvoiceRepository invoiceRepository;

	private Invoice invoice = Invoice.of();

	private InvoiceItemBuilder item = InvoiceItem.builder();

	public List<Invoice> getInvoices() {
		return invoiceRepository.find(
				q -> {
					QInvoice qInvoice = QInvoice.invoice;
					QInvoiceItem qInvoiceItem = QInvoiceItem.invoiceItem;
					return q.from(qInvoice)
							.join(qInvoice.items, qInvoiceItem).fetch()
							.distinct().list(qInvoice);
				}
		);
	}

	public String create() {
		invoice = Invoice.of();
		return "edit?faces-redirect=true";
	}

	public String edit(Invoice invoice) {
		this.invoice = invoice;
		return "edit?faces-redirect=true";
	}

	public void remove(Invoice invoice) {
		invoiceRepository.delete(invoice);
	}

	public String save() {
		invoiceRepository.save(invoice);
		return "list?faces-redirect=true";
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void newItem() {
		item = InvoiceItem.builder();
	}

	public InvoiceItemBuilder getItem() {
		return item;
	}

	public void addItem() {
		invoice.addItem(item.build());
	}

}
