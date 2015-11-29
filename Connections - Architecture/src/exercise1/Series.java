package exercise1;

import java.util.ArrayList;

public class Series {

	private String title;
	private ArrayList<String> actors;
	private ArrayList<Episode> episodes = new ArrayList<>();

	public Series(String title, ArrayList<String> actors) {
		this.title = title;
		this.actors = actors;
	}

	public String getTitle() {
		return this.title;
	}

	public ArrayList<String> getActors() {
		return this.actors;
	}

	public Episode createEpisode(int nr, int length, String guestActor) {
		Episode episode = new Episode(nr, length, guestActor, Series.this);
		this.episodes.add(episode);
		return episode;
	}

	public void deleteEpisode(Episode episode) {
		this.episodes.remove(episode);
	}

	public int getTotalLength() {
		int totalLength = 0;
		for (Episode episode : this.episodes) {
			totalLength += episode.getLength();
		}
		return totalLength;
	}

	public ArrayList<String> getGuestActors() {
		ArrayList<String> guestActors = new ArrayList<>();
		for (int i = 0; i < this.episodes.size(); i++) {
			if (!guestActors.contains(this.episodes.get(i).getGuestActor())) {
				guestActors.add(this.episodes.get(i).getGuestActor());
			}
		}
		return guestActors;
	}

}
