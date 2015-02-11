package com.github.wenhao.http.core.method;

import java.net.URI;

import static com.github.wenhao.http.core.model.HttpMethod.POST;

import com.github.wenhao.http.core.entity.HttpEntityFactory;
import com.github.wenhao.http.core.model.HttpRequest;
import org.apache.http.Header;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;

public class HttpPostRequest implements HttpRequestable
{

    private HttpEntityFactory httpEntityFactory;

    public HttpPostRequest(HttpEntityFactory httpEntityFactory)
    {
        this.httpEntityFactory = httpEntityFactory;
    }

    @Override
    public Boolean isApplicable(HttpRequest httpRequest)
    {
        return httpRequest.getHttpMethod().equals(POST);
    }

    @Override
    public HttpUriRequest apply(HttpRequest httpRequest)
    {
        HttpPost httpPost = new HttpPost(URI.create(httpRequest.getUrl()));
        httpPost.setEntity(httpEntityFactory.create(httpRequest));
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(httpRequest.getTimeout())
                .setConnectTimeout(httpRequest.getTimeout())
                .build();
        httpPost.setConfig(requestConfig);
        httpPost.setHeaders(httpRequest.getHeaders());
        return httpPost;
    }
}
