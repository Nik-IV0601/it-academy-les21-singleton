package by.it_academy.electronic_notepad.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class NoteBookProvider {

	private static NoteBookProvider singleton;
	private List<String> note = new ArrayList<>(); // записи
	private List<String> data = new ArrayList<>(); // даты создания записей

	private NoteBookProvider() {
	}
	private NoteBookProvider(List<String> note, List<String> data) {
		this.note = note;
		this.data = data;
	}

	public List<String> getNote() {
		return note;
	}

	public static void setSingleton(NoteBookProvider singleton) {
		NoteBookProvider.singleton = singleton;
	}

	public List<String> getData() {
		return data;
	}

	public static NoteBookProvider getSingleton() {
		if (singleton == null) { // если объект еще не создан
			singleton = new NoteBookProvider(); // создать новый объект
		}
		return singleton; // вернуть ранее созданный объект
	}

	@Override
	public int hashCode() {
		return Objects.hash(data, note);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NoteBookProvider other = (NoteBookProvider) obj;
		return Objects.equals(data, other.data) && Objects.equals(note, other.note);
	}
	@Override
	public String toString() {
		return "NoteBookProvider [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
}
