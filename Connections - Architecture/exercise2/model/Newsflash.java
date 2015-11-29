package model;

public class Newsflash {

	private String header;
	private String content;
	private int version = 1;

	public Newsflash(String header, String content) {
		this.header = header;
		this.content = content;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getHeader() {
		return this.header;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContent() {
		return this.content;
	}

	public void increaseVersion() {
		this.version++;
	}

	@Override
	public String toString() {
		String temp = "";
		temp += this.header + " , version: " + this.version;
		return temp;
	}

}
