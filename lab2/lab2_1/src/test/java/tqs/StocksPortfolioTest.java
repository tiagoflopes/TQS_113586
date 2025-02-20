package tqs;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StocksPortfolioTest {

    @Mock
    IStockmarketService stockmarket;

    @InjectMocks
    StocksPortfolio portfolio;

    @BeforeEach
    void setUp() {
        when(stockmarket.lookUpPrice("TSLA")).thenReturn(100.0);
        when(stockmarket.lookUpPrice("NVDA")).thenReturn(50.0);
    }

    @AfterEach
    void tearDown() {
        stockmarket = null;
        portfolio = null;
    }

    @Test
    void totalValue() {
        portfolio.addStock(new Stock("TSLA", 4));
        portfolio.addStock(new Stock("NVDA", 2));

        double result = portfolio.totalValue();

        assertEquals(500, result);
        verify(stockmarket, times(2)).lookUpPrice(anyString());
    }

    @Test
    void mostValuableStocks() {
        when(stockmarket.lookUpPrice("ABC")).thenReturn(25.0);
        when(stockmarket.lookUpPrice("XYZ")).thenReturn(12.5);

        portfolio.addStock(new Stock("TSLA", 4));
        portfolio.addStock(new Stock("NVDA", 2));
        portfolio.addStock(new Stock("ABC", 10));
        portfolio.addStock(new Stock("XYZ", 13));

        List<Stock> result = portfolio.mostValuableStocks(2);
        List<Stock> expected = new ArrayList<>();
        Stock first = new Stock("TSLA", 4);
        Stock second = new Stock("ABC", 10);
        expected.add(first);
        expected.addLast(second);
        for (int i = 0; i < result.size(); i++) {
            assertTrue(expected.get(i).equals(result.get(i)));
        }
    }

}