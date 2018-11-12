package com.edu.controller;


import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.HtmlButton;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlImage;
import com.gargoylesoftware.htmlunit.html.HtmlImageInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlTextInput;
import com.gargoylesoftware.htmlunit.javascript.host.html.HTMLElement;

@Controller
public class TestController {
	private final static String USER_AGENT = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/33.0.1750.152 Safari/537.36";
    private static final String URL = "https://teht.hometax.go.kr/ui/ab/a/a/UTEABAAA13.xml";
//    private static final String URL = "https://teht.hometax.go.kr/wqAction.do?actionId=ATTABZAA001R08&screenId=UTEABAAA13&popupYn=false&realScreenId=";
    
	@RequestMapping("/index")
	public String index(Model model) {
		try {
            Connection conn = Jsoup
                    .connect(URL)
                    .header("Content-Type", "application/json;charset=UTF-8")
                    .userAgent(USER_AGENT)
                    .data("bsno", "1234567890")
                    .method(Connection.Method.GET)
                    .ignoreContentType(true);
            
            Document doc = conn.get();
            
            System.out.println(doc.toString());

            
            
		} catch (IOException e) {
		    // Exp : Connection Fail
		    e.printStackTrace();
		}
		
		model.addAttribute("name", "DDDD");
//		model.addAttribute("test", test);

		return "index";
	}
}
