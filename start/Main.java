package by.it_academy.electronic_notepad.start;

import java.util.Scanner;

import by.it_academy.electronic_notepad.entity.NoteBookProvider;
import by.it_academy.electronic_notepad.logic.NoteBookLogic;

public class Main {

	public static void main(String[] args) {
		NoteBookLogic logic = new NoteBookLogic();
		NoteBookProvider notebook = NoteBookProvider.getSingleton();

		Scanner scan = new Scanner(System.in);
		int x = 0;
		String s = "";

		while (!"5".equals(s)) {
			System.out.println("            Добавить запись - введите 1");
			System.out.println("Найти запись по содержимому -         2");
			System.out.println("       Найти запись по дате -         3");
			System.out.println("            Показать записи -         4");
			System.out.println("              Выход из меню -         5");
			s = scan.next();

			try {
				x = Integer.parseInt(s);
			} catch (NumberFormatException e) {
				System.out.println("Неверный ввод");
			}
			switch (x) {
			case 1:
				Scanner scan1 = new Scanner(System.in);
				String str1 = scan1.nextLine();
				logic.addNote(notebook, str1);
				break;
			case 2:
				Scanner scan2 = new Scanner(System.in);
				String str2 = scan2.nextLine();
				System.out.println(logic.showByNote(notebook, str2));
				break;
			case 3:
				Scanner scan3 = new Scanner(System.in);
				String str3 = scan3.nextLine();
				System.out.println(logic.showByData(notebook, str3));
				break;
			case 4:
				System.out.println(logic.showAllNote(notebook));
			}
		}
		System.out.println("До встречи!");
	}
}
