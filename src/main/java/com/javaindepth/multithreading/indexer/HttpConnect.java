package com.javaindepth.multithreading.indexer;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import com.google.common.base.Charsets;
import com.google.common.io.CharStreams;
import com.javaindepth.multithreading.IOUtil;

public class HttpConnect {

  public static String download(String sourceUrl) throws MalformedURLException, URISyntaxException {
    System.out.println("Downloading: " + sourceUrl);
    URL url = new URI(sourceUrl).toURL();

    try {
      HttpURLConnection con = (HttpURLConnection) url.openConnection();
      int responseCode = con.getResponseCode();

      if (responseCode >= 200 && responseCode < 300) { // ok
        return IOUtil.read(con.getInputStream());
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    return null;
  }

  public static String download(InputStream sourceUrlInputStream) throws URISyntaxException,
      IOException {
    // https://stackoverflow.com/questions/309424/read-convert-an-inputstream-to-a-string
    String sourceUrl =
        CharStreams.toString(new InputStreamReader(sourceUrlInputStream, Charsets.UTF_8));
    return download(sourceUrl);
  }
}
