package by.it_academy.electronic_notepad.logic;

import java.time.LocalDate;
import by.it_academy.electronic_notepad.entity.NoteBookProvider;

public class NoteBookLogic {

//	public String dataToString() {
//		LocalDate date = LocalDate.now(); // получаем текущую дату
//		int yyyy = date.getYear();
//		int mm = date.getMonthValue();
//		int dd = date.getDayOfMonth();
//		return dd + "." + mm + "." + yyyy;
//	}

	public void addNote(NoteBookProvider notebook, String newNote) {
		notebook.getNote().add(newNote); // добавляем новую запись в List с записями
		LocalDate date = LocalDate.now(); // получаем текущую дату
		int yyyy = date.getYear();
		int mm = date.getMonthValue();
		int dd = date.getDayOfMonth();
		notebook.getData().add(dd + "." + mm + "." + yyyy); // добавляем дату в виде строки в List с датами создания
															// записей
	}

	public String showAllNote(NoteBookProvider notebook) {
		String strDataNote = "";
		for (int i = 0; i < notebook.getData().size(); i++) {
			String strData = notebook.getData().get(i);
			String strNote = notebook.getNote().get(i);
			strDataNote += strData + "\n" + strNote + "\n";
		}
		return strDataNote;
	}
	
	public String showByData(NoteBookProvider notebook, String str) {
		String strShowByData = "";
		for (int i = 0; i < notebook.getData().size(); i++) {
			if (notebook.getData().get(i).equals(str)) {
				strShowByData += str + "\n" + notebook.getNote().get(i) + "\n";
			}
		}
		return strShowByData;
	}
	
	public String showByNote(NoteBookProvider notebook, String str) {
		String strShowByNote = "";
		for (int i = 0; i < notebook.getNote().size(); i++) {
			if (notebook.getNote().get(i).toLowerCase().indexOf(str.toLowerCase()) != -1) {
				strShowByNote += notebook.getData().get(i) + "\n" + notebook.getNote().get(i) + "\n";
			}
		}
		return strShowByNote;
	}

}
