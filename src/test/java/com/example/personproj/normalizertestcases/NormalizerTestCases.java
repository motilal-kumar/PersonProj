package com.example.personproj.normalizertestcases;

import com.example.personproj.normalizertest.Normalizer;
import org.junit.Assert;
import org.junit.Test;


public class NormalizerTestCases {


	@Test
	  public void testNormalizeWithFullUrl() {
	    String result = Normalizer.normalize("https://example.com:8080/a/b/c");
	    Assert.assertEquals("https://example.com:8080/a/b/c", result);
	  }

	  @Test
	  public void testNormalizeWithDomainOnly() {
	    String result = Normalizer.normalize("example.com");
	    Assert.assertEquals("http://example.com:80/", result);
	  }

	  @Test
	  public void testNormalizeWithEmptyString() {
	    String result = Normalizer.normalize("");
	    Assert.assertEquals("http://localhost:80/", result);
	  }

	  @Test
	  public void testNormalizeWithProtocolOnly() {
	    String result = Normalizer.normalize("https://");
	    Assert.assertEquals("https://localhost:80/", result);
	  }

	  @Test
	  public void testNormalizeWithPortOnly() {
	    String result = Normalizer.normalize(":8080");
	    Assert.assertEquals("http://localhost:8080/", result);
	  }

	  @Test
	  public void testNormalizeWithPathOnly() {
	    String result = Normalizer.normalize("/path");
	    Assert.assertEquals("http://localhost:80/path", result);
	  }

	  @Test
	  public void testNormalizeWithInvalidUrl() {
	    String result = Normalizer.normalize("htps://example.com:8080/a/b/c");
	    Assert.assertNotEquals("https://example.com:8080/a/b/c", result);
	  }


  /*  @Test
    public void testNormalizeWithFullUrl() {
        String url = "https://example.com:8080/a/b/c";
        String normalized = Normalizer.normalize(url);
        Assert.assertEquals(url, normalized);
    }

    @Test
    public void testNormalizeWithDomainOnly() {
        String domain = "example.com";
        String normalized = Normalizer.normalize(domain);
        Assert.assertEquals("http://" + domain + ":80/", normalized);
    }

    @Test
    public void testNormalizeWithEmptyString() {
        String normalized = Normalizer.normalize("");
        Assert.assertEquals("http://localhost:80/", normalized);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNormalizeWithInvalidUrl() {
        Normalizer.normalize("ramu://bar.com:sony");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNormalizeWithInvalidPort() {
        Normalizer.normalize("http://example.com:raja");
    }*/
}
