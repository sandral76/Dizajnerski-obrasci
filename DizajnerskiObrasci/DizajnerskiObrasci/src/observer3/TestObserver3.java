package observer3;



public class TestObserver3 {

	public static void main(String[] args) {
		  CryptoCurrencyPrice cryptoCurrencyPrice=new CryptoCurrencyPrice();
		  CryptoCurrencyUpdateSMS CrypoCurrencyUpdateSMS=new CryptoCurrencyUpdateSMS();
		  
		  cryptoCurrencyPrice.addPropertyChangeListener(CrypoCurrencyUpdateSMS);
		  
		  cryptoCurrencyPrice.setBitcoinPrice(30000);
		  cryptoCurrencyPrice.setEtherPrice(2000);
	}

}
