
import java.util.HashMap;
import java.util.Map;

public class ExchangeRateProvider {
    private Map<String, Double> exchangeRates;

    public ExchangeRateProvider() {
        exchangeRates = new HashMap<>();
        exchangeRates.put("USD", 1.0);
        exchangeRates.put("EUR", 0.91);
        exchangeRates.put("GBP", 0.76);
        exchangeRates.put("INR", 83.90);
        exchangeRates.put("JPY", 110.0);
        exchangeRates.put("AUD", 1.4);
    }

    public double getExchangeRate(String currency) {
        return exchangeRates.getOrDefault(currency, 1.0); // Default to 1.0 if currency not found
    }
}
