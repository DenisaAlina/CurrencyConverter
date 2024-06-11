package se.lexicon;
import java.util.HashMap;
import java.util.Map;

public class CurrencyConverter {
    private final Map<String, Double> exchangeRates;

    public CurrencyConverter() {
        exchangeRates = new HashMap<>();
        exchangeRates.put("SEKtoUSD", 0.095342338);
        exchangeRates.put("USDtoSEK", 10.489228);
        exchangeRates.put("SEKtoEuro", 0.088549677);
        exchangeRates.put("EurotoSEK", 11.293096);
    }

    public double convert(String fromCurrency, String toCurrency, double amount) {
        String key = fromCurrency + "to" + toCurrency;
        if (exchangeRates.containsKey(key)) {
            return amount * exchangeRates.get(key);
        } else {
            throw new IllegalArgumentException("Unsupported currency conversion.");
        }
    }
}
