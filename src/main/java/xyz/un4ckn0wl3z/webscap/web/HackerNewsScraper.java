package xyz.un4ckn0wl3z.webscap.web;

import java.util.ArrayList;
import java.util.List;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.google.gson.Gson;

public class HackerNewsScraper {

	public static void main(String[] args) {
		
		Gson gson = new Gson();

		String baseUrl = "https://news.ycombinator.com/";

		WebClient client = new WebClient();

		client.getOptions().setCssEnabled(false);
		client.getOptions().setJavaScriptEnabled(false);
		
		List<HackerNewsItem> hackerNewsList = new ArrayList<HackerNewsItem>();

		try {
			HtmlPage page = client.getPage(baseUrl);
			
			List<HtmlElement> itemList = page.getByXPath("//tr[@class='athing']");
			
			if(itemList.isEmpty()) {
				System.out.println("No item found");
			}else {
				for(HtmlElement htmlElement : itemList) {
					int position = Integer.parseInt(((HtmlElement) htmlElement.getFirstByXPath("./td/span")).asText().replace(".", ""));
					int id = Integer.parseInt(htmlElement.getAttribute("id"));
					String title = ((HtmlElement) htmlElement.getFirstByXPath("./td[not(@valign='top')][@class='title']")).asText();
					String url = ((HtmlAnchor) htmlElement.getFirstByXPath("./td[not(@valign='top')][@class='title']/a")).getHrefAttribute();
			
				
					HackerNewsItem hackerNewsItem = new HackerNewsItem(url, title, position, id);
					
					hackerNewsList.add(hackerNewsItem);
					
					
					
				
				}
				
				System.out.println(gson.toJson(hackerNewsList));
				
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
