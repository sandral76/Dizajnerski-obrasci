package observer2;


public class TestObserver2 {

	public static void main(String[] args) {
		 CryptoCurrencyPrice cryptoCurrencyPrice=new CryptoCurrencyPrice();
		 CryptoCurrencyUpdateSMS cryptoCurrencyUpdateSMS=new CryptoCurrencyUpdateSMS();

		 cryptoCurrencyPrice.addObserver(cryptoCurrencyUpdateSMS);
		 cryptoCurrencyPrice.setBitcoinPrice(250000);
		 cryptoCurrencyPrice.setEtherPrice(1500);
		 
	}

}
