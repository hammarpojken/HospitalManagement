package Hospital;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

public class Medicine {
	
	private final SimpleIntegerProperty medicineId;
    private final SimpleStringProperty name;
    private final SimpleStringProperty type;
    private final SimpleStringProperty volume;
    private final SimpleDoubleProperty price;
    
    public Medicine(int medId, String name, String type, String volume, double price) {
    	this.medicineId  = new SimpleIntegerProperty(medId);
    	this.name = new SimpleStringProperty(name);
    	this.type = new SimpleStringProperty(type);
    	this.volume = new SimpleStringProperty(volume);
    	this.price  = new SimpleDoubleProperty(price);
    }

	public final SimpleIntegerProperty medicineIdProperty() {
		return this.medicineId;
	}
	

	public final int getMedicineId() {
		return this.medicineIdProperty().get();
	}
	

	public final void setMedicineId(final int medicineId) {
		this.medicineIdProperty().set(medicineId);
	}
	

	public final SimpleStringProperty nameProperty() {
		return this.name;
	}
	

	public final String getName() {
		return this.nameProperty().get();
	}
	

	public final void setName(final String name) {
		this.nameProperty().set(name);
	}
	

	public final SimpleStringProperty volumeProperty() {
		return this.volume;
	}
	

	public final String getVolume() {
		return this.volumeProperty().get();
	}
	

	public final void setVolume(final String volume) {
		this.volumeProperty().set(volume);
	}
	

	public final SimpleDoubleProperty priceProperty() {
		return this.price;
	}
	

	public final double getPrice() {
		return this.priceProperty().get();
	}
	

	public final void setPrice(final double price) {
		this.priceProperty().set(price);
	}

	public final SimpleStringProperty typeProperty() {
		return this.type;
	}
	

	public final String getType() {
		return this.typeProperty().get();
	}
	

	public final void setType(final String type) {
		this.typeProperty().set(type);
	}
	
	

}
