package ua.deti.pedros50.stocks;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.Test;
import org.junit.Before;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.verify;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@ExtendWith(MockitoExtension.class)
public class StocksPortfolioTest {
	@Mock
    IStockMarket stockMarket;

    @InjectMocks
    StocksPortfolio portfolio;

    // NullPointerException without these lines:
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

	@Test
	public void testTotalValue() {
		portfolio.addStock( new Stock("EA", 3) );
        portfolio.addStock( new Stock("GS", 10) );

        when(stockMarket.getPrice("EA")).thenReturn(5.0);
        when(stockMarket.getPrice("GS")).thenReturn(20.0);

        assertThat(portfolio.getTotalValue(), is(215.0));
        verify(stockMarket, times(2)).getPrice(anyString());
	}
}
