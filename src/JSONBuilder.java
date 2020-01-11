  
import java.util.HashMap;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class JSONBuilder implements Builder {
	Element document;
	String filename;
	public JSONBuilder(String filename) {
		this.filename = filename;
	}

	@Override
	public void build() {
		try {
			ObjectMapper mapper = new ObjectMapper();
			HashMap<String, Object> map = mapper.readValue(new File(filename), HashMap.class);
			document = processMap(map);
			} catch (JsonParseException e) {
			e.printStackTrace();
			} catch (JsonMappingException e) {
			e.printStackTrace();
			} catch (IOException e) {
			e.printStackTrace();
			}
		
	}
	
	private Element processMap(HashMap<String, Object> map) {
		String myClass = (String)map.get("class");
		Element element = null;
		switch(myClass) {
			case"Section":
				element = buildSection(map);
			break;
			case"Paragraph":
				element = buildParagraph(map);
			break;
			case"Image":
				element = buildImage(map);
			break;
			case"ImageProxy":
				element = buildImageProxy(map);
			break;
			case"Table":
				element = buildTable(map);
			break;
		}
		
		return element;
		
	}
	

	@Override
	public Element getResult() {
		return document;
	}


	@Override
	public Element buildSection(HashMap<String, Object> map) {
		Section section = new Section((String)map.get("title"));
		Collection<HashMap<String, Object>> children = (Collection)map.get("children");
		children.forEach((childMap) -> {

		Element e = this.processMap(childMap);
		if (e != null) {
		try {
		section.add(e);
		} catch (Exception var5) {
		var5.printStackTrace();
		}
		}
		});
		return section;
		}

	@Override
	public Element buildParagraph(HashMap<String, Object> map) {
		Paragraph paragraph = new Paragraph((String)map.get("text"));
		return paragraph;
	}

	@Override
	public Element buildImage(HashMap<String, Object> map) {
		Image paragraph = new Image((String)map.get("url"));
		return paragraph;
	}

	@Override
	public Element buildImageProxy(HashMap<String, Object> map) {
		ImageProxy paragraph = new ImageProxy((String)map.get("url"));
		return paragraph;
	}

	@Override
	public Element buildTable(HashMap<String, Object> map) {
		Table paragraph = new Table((String)map.get("title"));
		return paragraph;
	}

}