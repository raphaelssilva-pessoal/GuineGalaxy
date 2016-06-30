package com.thoughtworks.codingassignment.guinegalaxy.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileUtil {
	public static List<String> getTextFile(String path) throws Exception {
		try {
			File file = getFile(path);
			return getTextFile(file);
		} catch (FileNotFoundException e) {
			throw new Exception("Arquivo não informado");
		}
	}

	private static List<String> getTextFile(File file) throws FileNotFoundException {
		List<String> lines = new ArrayList<String>();
		Scanner scanner = null;
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
			scanner = new Scanner(fis);
			while (scanner.hasNextLine()) {
				lines.add(scanner.nextLine());
			}
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
		return lines;
	}

	private static File getFile(String path) throws Exception {
		if (path != null) {
			System.out.println(path);
			if (fileExist(path)) {
				return new File(path);
			} else {
				throw new Exception("Arquivo invalido");
			}
		} else {
			throw new Exception("Arquivo não informado");
		}
	}

	private static boolean fileExist(String path) {
		File file = new File(path);
		return file.exists();
	}
}
