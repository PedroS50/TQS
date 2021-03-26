package ua.deti.pedros50.stocks;

import java.util.List;
import java.util.ArrayList;

public class StocksPortfolio {
	private String name;
	private IStockMarket stockMarket;
	private List<Stock> stocks = new ArrayList<Stock>();

	public IStockMarket getMarketService() {
		return this.stockMarket;
	}

	public void setMarketService(IStockMarket stockMarket) {
		this.stockMarket = stockMarket;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getTotalValue() {
		Double total = 0.0;

		for (Stock s: stocks) {
			total += stockMarket.getPrice(s.getName()) * s.getQuantity();
		}

		return total;
	}

	public void addStock(Stock stock) {
		this.stocks.add(stock);
	}
}