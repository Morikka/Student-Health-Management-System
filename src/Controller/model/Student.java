package Controller.model;
import java.time.LocalDate;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Student {
    private final StringProperty Sid;
    private final StringProperty Name;
    private final BooleanProperty Sex;
    private final ObjectProperty<LocalDate> Birthday;
	private final ObjectProperty<LocalDate> Stame;
	private final StringProperty Phone;
	private final StringProperty Major;
	public StringProperty getSid() {
		return Sid;
	}
	public void setSid(String sid){
		this.Sid.set(sid);
	}
	public StringProperty getName() {
		return Name;
	}
	public void setName(String name) {
        this.Name.set(name);
    }
	public BooleanProperty getSex() {
		return Sex;
	}
	public ObjectProperty<LocalDate> getBirthday() {
		return Birthday;
	}
	public ObjectProperty<LocalDate> getStame() {
		return Stame;
	}
	public StringProperty getPhone() {
		return Phone;
	}
	public StringProperty getMajor() {
		return Major;
	}

}
