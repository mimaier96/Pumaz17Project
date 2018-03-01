package de.dpma.projekt.models.util;

import java.util.ArrayList;

import de.dpma.projekt.models.ReportBook;
import de.dpma.projekt.models.User;

public class ReportBookList {

	private static ArrayList<ReportBook> reportBookList;

	public static void deleteReportBook(ReportBook reportBook) {

		reportBookList.remove(reportBook);

	}

	public static void deleteReportBookbyId(int id) {

		reportBookList.remove(searchReportBookbyId(id));

	}

	public static ReportBook searchReportBookbyId(int id) {

		for (ReportBook reportBook : reportBookList) {

			if (reportBook.getId() == id) {

				return reportBook;

			}

		}
		return null;
	}

	public static void addUser(User user) {

		reportBook.add(user);

	}
}
