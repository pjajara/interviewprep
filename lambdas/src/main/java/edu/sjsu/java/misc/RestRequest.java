package edu.sjsu.java.misc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RestRequest {

	private Pattern collectionPattern = Pattern.compile("/storage/documents");
	private Pattern instancePattern = Pattern
			.compile("/storage/documents/[0-9|a-z|A-Z]*");
	private String id;

	public RestRequest(final String pathInfo) {
		Matcher matcher;
		matcher = instancePattern.matcher(pathInfo);

		if (matcher.find()) {
			id = matcher.group();
			return;
		}

		matcher = collectionPattern.matcher(pathInfo);
		if (matcher.find())
			return;

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
