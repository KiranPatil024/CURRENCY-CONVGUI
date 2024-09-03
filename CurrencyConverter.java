public class CurrencyConverter {
    private ExchangeRateProvider exchangeRateProvider;

    public CurrencyConverter(ExchangeRateProvider provider) {
        this.exchangeRateProvider = provider;
    }

    public double convert(String fromCurrency, String toCurrency, double amount) {
        double fromRate = exchangeRateProvider.getExchangeRate(fromCurrency);
        double toRate = exchangeRateProvider.getExchangeRate(toCurrency);
        return (amount / fromRate) * toRate;
    }
}
