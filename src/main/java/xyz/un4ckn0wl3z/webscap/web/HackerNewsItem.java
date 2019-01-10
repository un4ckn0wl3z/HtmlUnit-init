package xyz.un4ckn0wl3z.webscap.web;

public class HackerNewsItem {
	
	private String url;
	private String title;
	private int position;
	private int id;
	
	
	
	public HackerNewsItem(String url, String title, int position, int id) {
		this.url = url;
		this.title = title;
		this.position = position;
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	

	

}
