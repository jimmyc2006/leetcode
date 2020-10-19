package shuwei.improve.base;

import org.junit.Test;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class UriTest {

    @Test
    public void test1() throws URISyntaxException {
        URI u = new URI("jar:file:/export/icity/datasync/datasync-service-1.0-SNAPSHOT.jar!/BOOT-INF/lib/hive-common-2.3.0.jar!/");
        System.out.println(u.getScheme());
        System.out.println(u.getPath());
        System.out.println(u.getPort());
        System.out.println(u.getQuery());
    }

    @Test
    public void test2() throws URISyntaxException {
        URL resource = UriTest.class.getClassLoader().getResource("java/net/URI.class");
        URI uri = resource.toURI();
        System.out.println(uri);
        System.out.println(uri.getScheme());
        System.out.println(uri.getQuery());
        new File(uri);
    }

    @Test
    public void test3() throws URISyntaxException {
        URI resource = UriTest.class.getProtectionDomain().getCodeSource().getLocation().toURI();
        System.out.println(resource);
        System.out.println(resource.getScheme());
        System.out.println(resource.getQuery());
        new File(resource);
    }

    @Test
    public void test4() throws URISyntaxException {
        URI resource = new URI("thrift://cityos-hadoop02:9083");
        System.out.println(resource);
        System.out.println(resource.getScheme());
        System.out.println(resource.getQuery());
        new File(resource);
    }
    @Test
    public void test5() throws URISyntaxException {
        String[] metastoreUrisString = "thrift://cityos-hadoop02:9083,aaa".split(",");
        URI[] metastoreUris = new URI[metastoreUrisString.length];
        int i = 0;
        for (String s : metastoreUrisString) {
            URI tmpUri = new URI(s);
            if (tmpUri.getScheme() == null) {
                throw new IllegalArgumentException("URI: " + s
                        + " does not have a scheme");
            }
            metastoreUris[i++] = tmpUri;
        }
        List uriList = Arrays.asList(metastoreUris);
        Collections.shuffle(uriList);
        metastoreUris = (URI[]) uriList.toArray();
        try {
            URLEncoder.encode("2020/10/13", Charset.defaultCharset().toString());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testy() {
        try {
            System.out.println(URLEncoder.encode("2020 10 13", Charset.defaultCharset().toString()));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

}
