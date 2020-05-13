package page;

import java.util.List;

import model.Product;

public class ProductPage extends Page {
	private List<Product> content;

	public ProductPage(int totalCount, int currentPage, int size, List<Product> content) {
		super(totalCount, currentPage, size);
		this.content = content;
	}

	public List<Product> getContent() {
		return content;
	}
}
