package org.jz.util;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.conn.HttpHostConnectException;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Hongyi Zheng
 * @date 2018/2/8
 */
public class HttpClientUtils {

    private static final Logger logger = LoggerFactory.getLogger(HttpClientUtils.class);

    /**
     * default charset
     */
    private static String CHARSET = "UTF-8";

    private static ThreadLocal<Map<String, String>> httpHeader = new ThreadLocal<Map<String, String>>();

    private static ThreadLocal<Map<String, Object>> httpClientConfig = new ThreadLocal<Map<String, Object>>();

    private static final String CONNECT_TIMEOUT = "connect_timeout";

    private static final String SOCKET_TIMEOUT = "socket_timeout";

    /**
     * get request URI
     * @param uri
     * @return
     */
    public static String getPureUri(String uri){
        return uri.substring(uri.indexOf('/',uri.indexOf('/')+1),uri.length());
    }


    /**
     * send HTTP Get request
     *
     * @param url     request url
     * @param params  request parameters
     * @param charset encoding charset
     * @return response
     */
    public static String doGet(String url, Map<String, String> params, String charset) throws IOException {
        String encoding = CHARSET;
        if (StringUtils.isNotBlank(charset)) {
            encoding = charset;
        }
        return doGet(url, params, encoding, encoding);
    }

    /**
     * reload doGet method
     * @param url request url
     * @param params request params
     * @return
     * @throws IOException
     */
    public static String doGet(String url,Map<String,String>params)throws IOException{
        return doGet(url,params,CHARSET);
    }


    /**
     *
     * @param url target request url
     * @param params set request parameters
     * @param reqCharset specify request charset
     * @param respCharset specify response charset
     * @return response from the server
     */
    public static String doGet(String url, Map<String, String> params, String reqCharset, String respCharset)throws IOException{
        if (StringUtils.isBlank(url)) {
            return null;
        }
        String requestCharset = CHARSET;
        if (StringUtils.isNotBlank(reqCharset)) {
            requestCharset = reqCharset;
        }
        String responseCharset = CHARSET;
        if (StringUtils.isNotBlank(respCharset)) {
            responseCharset = respCharset;
        }

        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        HttpGet httpGet = null;

        try {
            if (null != params && !params.isEmpty()) {
                List<NameValuePair> pairs = new ArrayList<>(params.size());
                for (Map.Entry<String, String> entry : params.entrySet()) {
                    String value = entry.getValue();
                    if (null != value) {
                        pairs.add(new BasicNameValuePair(entry.getKey(),value));
                    }
                }
                url += "?" + EntityUtils.toString(new UrlEncodedFormEntity(pairs,requestCharset));
            }
            httpGet = new HttpGet(url);
            handlerHeader(httpGet);

            httpClient = buildHttpClient();
            response  = httpClient.execute(httpGet);
            int statusCode = response.getStatusLine().getStatusCode();
            if (200 != statusCode) {
                httpGet.abort();
                throw new RuntimeException("Httpclient error, statusCode : "+statusCode);
            }
            HttpEntity entity = response.getEntity();
            String result = null;
            if (null != entity) {
                result = EntityUtils.toString(entity,responseCharset);
            }
            EntityUtils.consume(entity);
            response.close();
            return result;
        } catch (IOException e) {
            logger.error(e.getMessage(),e);
            throw e;
        }finally {
            if (null != response) {
                response.close();
            }
            if (null != httpGet) {
                httpGet.releaseConnection();
            }
            if (null != httpClient) {
                httpClient.close();
            }
        }
    }

    private static void handlerHeader(HttpRequestBase requestBase) {
        if (httpHeader != null && httpHeader.get() != null) {
            Map<String, String> map = httpHeader.get();
            for (String key : map.keySet()) {
                requestBase.addHeader(key, map.get(key));
            }
        }
    }

    public static CloseableHttpClient buildHttpClient() {
        Map<String, Object> configSetting = new HashMap<String, Object>();
        if (httpClientConfig != null && null != httpClientConfig.get()) {
            configSetting = httpClientConfig.get();
        }
        RequestConfig.Builder builder = RequestConfig.custom();
        Integer DEFAULT_CONNECT_TIMEOUT = 600000;
        Integer connectTimeout = DEFAULT_CONNECT_TIMEOUT;
        connectTimeout = getInteger(configSetting, connectTimeout, CONNECT_TIMEOUT, DEFAULT_CONNECT_TIMEOUT);
        builder.setConnectTimeout(connectTimeout);
        Integer DEFAULT_SOCKET_TIMEOUT = 600000;
        Integer socketTimeout = DEFAULT_SOCKET_TIMEOUT;
        socketTimeout = getInteger(configSetting, socketTimeout, SOCKET_TIMEOUT, DEFAULT_SOCKET_TIMEOUT);
        builder.setSocketTimeout(socketTimeout);
        RequestConfig config = builder.build();
        return HttpClientBuilder.create().setDefaultRequestConfig(config).build();
    }

    private static Integer getInteger(Map<String, Object> configSetting, Integer connectTimeout, String connectTimeout2, Integer defaultConnectTimeout) {
        if (configSetting.get(connectTimeout2) != null) {
            try {
                connectTimeout = Integer.valueOf(configSetting.get(connectTimeout2).toString());
            } catch (Exception e) {
                logger.warn("class covert error!", e);
                connectTimeout = defaultConnectTimeout;
                throw e;
            }
        }
        return connectTimeout;
    }
}
