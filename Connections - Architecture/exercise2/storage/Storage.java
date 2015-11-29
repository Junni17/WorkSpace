package storage;

import java.util.ArrayList;

import model.Newsflash;

public class Storage {

	private static ArrayList<Newsflash> newsflashes = new ArrayList<Newsflash>();

	public static ArrayList<Newsflash> getAllNewsflashes() {
		return new ArrayList<Newsflash>(newsflashes);
	}

	public static void storeNewsflash(Newsflash newsflash) {
		newsflashes.add(newsflash);
	}

	public static void deleteNewsflash(Newsflash newsflash) {
		newsflashes.remove(newsflash);
	}

}
