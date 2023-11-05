package observer;

public class TestObserver {
  public static void main(String[] args) {
	  CryptoCurrencyPrice cryptoCurrencyPrice=new CryptoCurrencyPrice();
	  CryptoCurrencyUpdateSMS CrypoCurrencyUpdateSMS=new CryptoCurrencyUpdateSMS();
	  
	  cryptoCurrencyPrice.addObserver(CrypoCurrencyUpdateSMS);
	  
	  cryptoCurrencyPrice.setBitcoinPrice(20000);
	  cryptoCurrencyPrice.setEtherPrice(1000);
  }
}
