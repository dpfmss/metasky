package tech.mcverse.metasky.external;

public class CurrencyExchange {
  String quotCurrency;
  String baseCurrency;
  double amount;
  public CurrencyExchange(String quotCurrency, String baseCurrency, double amount) {
    this.quotCurrency = quotCurrency;
    this.baseCurrency = baseCurrency;
    this.amount = amount;
  }
  private double exchange(double amount) {
    return this.amount * getRate(baseCurrency, quotCurrency);
  }
  private double getRate(String baseCurrency, String quotCurrency) {
    double rate = 0.87;
    return rate;
  }
}
