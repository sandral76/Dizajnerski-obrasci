package observer3;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class CryptoCurrencyPrice {
	private double bitcoinPrice;
	private double etherPrice;
	
	private PropertyChangeSupport propertyChangeSupport;
	
	
	public CryptoCurrencyPrice() {
		propertyChangeSupport=new PropertyChangeSupport(this);
	}
	
	public void addPropertyChangeListener(PropertyChangeListener propertyChangeListener) {
		propertyChangeSupport.addPropertyChangeListener(propertyChangeListener);
	}
	
	public void addPropertyChangedListener(PropertyChangeListener propertyChangeListener) {
		propertyChangeSupport.removePropertyChangeListener(propertyChangeListener);
	}

	public void setBitcoinPrice(double bitcoinPrice) {
		propertyChangeSupport.firePropertyChange("bitcoin",this.bitcoinPrice,bitcoinPrice);
		this.bitcoinPrice = bitcoinPrice;
	}

	public void setEtherPrice(double etherPrice) {
		propertyChangeSupport.firePropertyChange("ether",this.etherPrice,etherPrice);
		this.etherPrice = etherPrice;
	}

	public double getBitcoinPrice() {
		return bitcoinPrice;
	}

	public double getEtherPrice() {
		return etherPrice;
	}
}
