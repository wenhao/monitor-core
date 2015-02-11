package com.github.wenhao.http.core.method;

import org.apache.http.Header;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;

import com.github.wenhao.http.core.entity.HttpEntityFactory;
import com.github.wenhao.http.core.model.HttpRequest;

import static com.github.wenhao.http.core.model.HttpMethod.PUT;

public class HttpPutRequest implements HttpRequestable
{
    private HttpEntityFactory httpEntityFactory;

    public HttpPutRequest(HttpEntityFactory httpEntityFactory)
    {
        this.httpEntityFactory = httpEntityFactory;
    }

    @Override
    public Boolean isApplicable(HttpRequest httpRequest)
    {
        return httpRequest.getHttpMethod().equals(PUT);
    }

    @Override
    public HttpUriRequest apply(HttpRequest httpRequest)
    {
        HttpPut httpPut = new HttpPut();
        httpPut.setEntity(httpEntityFactory.create(httpRequest));
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(httpRequest.getTimeout())
                .setConnectTimeout(httpRequest.getTimeout())
                .build();
        httpPut.setConfig(requestConfig);
        httpPut.setHeaders(httpRequest.getHeaders());
        return httpPut;
    }
}
