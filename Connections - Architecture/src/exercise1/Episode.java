package exercise1;

public class Episode {

	private int nr;
	private int length;
	private String guestActor;
	private Series series;

	public Episode(int nr, int length, String guestActor, Series series) {
		this.nr = nr;
		this.length = length;
		this.guestActor = guestActor;
		this.series = series;
	}

	public int getNr() {
		return this.nr;
	}

	public int getLength() {
		return this.length;
	}

	public String getGuestActor() {
		return this.guestActor;
	}

	public void setGuestActor(String actor) {
		this.guestActor = actor;
	}

	// public String getSeriesName() {
	// return this.series.getTitle();
	// }
}
