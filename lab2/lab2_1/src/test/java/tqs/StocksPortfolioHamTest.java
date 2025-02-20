package tqs;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.*;
import static org.hamcrest.MatcherAssert.assertThat;

@ExtendWith(MockitoExtension.class)
class StocksPortfolioHamTest {

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
    void totalValueHamcrest() {
        portfolio.addStock(new Stock("TSLA", 4));
        portfolio.addStock(new Stock("NVDA", 2));

        double result = portfolio.totalValue();

        assertThat(500.0, equalTo(result));
    }

}