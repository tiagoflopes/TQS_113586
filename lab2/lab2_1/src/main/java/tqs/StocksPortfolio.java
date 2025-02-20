package tqs;

import java.util.ArrayList;
import java.util.List;

public class StocksPortfolio implements IStockmarketService {

    private final List<Stock> stocks;

    public StocksPortfolio(IStockmarketService stockmarket) {
        this.stocks = new ArrayList<>();
    }

    public void addStock(Stock stock) {
        if (stocks.contains(stock)) {
            throw new IllegalStateException();
        }
        stocks.add(stock);
    }

    public double totalValue() {
        double total = 0.0;
        for (Stock stock : stocks) {
            total += stock.getQuantity() * lookUpPrice(stock.getLabel());
        }
        return total;
    }

    @Override
    public double lookUpPrice(String label) {
        return 0.0;
    }

}
