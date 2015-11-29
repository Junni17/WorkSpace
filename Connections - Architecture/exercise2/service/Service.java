package service;

import model.Newsflash;
import storage.Storage;

public class Service {

	public static Newsflash createNewsflash(String header, String content) {
		Newsflash nf1 = new Newsflash(header, content);
		Storage.storeNewsflash(nf1);
		return nf1;
	}

	public static Newsflash updateNewsflash(Newsflash newsflash, String header, String content) {
		newsflash.setHeader(header);
		newsflash.setContent(content);
		newsflash.increaseVersion();
		return newsflash;
	}

}
