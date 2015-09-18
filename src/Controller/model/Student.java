package Controller.model;
import java.time.LocalDate;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
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
	
	public Student(){
		this.Sid = new SimpleStringProperty("");
		this.Name = new SimpleStringProperty("");
		this.Sex = new SimpleBooleanProperty(false);
		this.Birthday = new SimpleObjectProperty<LocalDate>(LocalDate.of(0000, 0, 0));
		this.Stame = new SimpleObjectProperty<LocalDate>(LocalDate.of(0000, 0, 0));
		this.Phone = new SimpleStringProperty("");
		this.Major = new SimpleStringProperty("");
	}
	
	public StringProperty getSid() {
		return Sid;
	}
	public void setSid(String sid){
		this.Sid.set(sid);
	}
	public StringProperty SidProperty() {
		return Sid;
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
	public void setSex(Boolean sex){
		this.Sex.set(sex);
	}
	public ObjectProperty<LocalDate> getBirthday() {
		return Birthday;
	}
    public void setBirthday(LocalDate birthday) {
        this.Birthday.set(birthday);
    }
	public ObjectProperty<LocalDate> getStame() {
		return Stame;
	}
	public void setStame(LocalDate stame){
		this.Stame.set(stame);
	}
	public StringProperty getPhone() {
		return Phone;
	}
	public void setPhone(String phone){
		this.Phone.set(phone);
	}
	public StringProperty getMajor() {
		return Major;
	}
	public void setMajor(String major){
		this.Major.set(major);
	}
}
