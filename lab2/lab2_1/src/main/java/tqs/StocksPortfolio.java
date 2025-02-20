package tqs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StocksPortfolio {

    private final List<Stock> stocks;
    private final IStockmarketService stockmarket;

    public StocksPortfolio(IStockmarketService stockmarket) {
        this.stocks = new ArrayList<>();
        this.stockmarket = stockmarket;
    }

    public void addStock(Stock stock) {
        stocks.add(stock);
    }

    public double totalValue() {
        double total = 0.0;
        for (Stock stock : stocks) {
            total += stock.getQuantity() * stockmarket.lookUpPrice(stock.getLabel());
        }
        return total;
    }

    public List<Stock> mostValuableStocks(int topN) {
        return stocks.stream()
                .sorted(Comparator.comparingDouble(stock -> -stock.getQuantity() * stockmarket.lookUpPrice(stock.getLabel())))
                .limit(topN)
                .collect(Collectors.toList());
    }

}
