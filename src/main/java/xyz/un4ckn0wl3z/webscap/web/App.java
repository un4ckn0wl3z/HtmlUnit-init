package xyz.un4ckn0wl3z.webscap.web;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class App 
{
    public static void main( String[] args ){

    	String baseUrl = "https://news.ycombinator.com/";
    	
    	WebClient client = new WebClient();
    	
    	client.getOptions().setCssEnabled(false);
    	client.getOptions().setJavaScriptEnabled(false);
    	
    	try {
			HtmlPage page = client.getPage(baseUrl);
			System.out.println(page.asXml());

		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	
    }
}
