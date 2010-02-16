/*
 * Copyright 2010 Ning, Inc.
 *
 * Ning licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package ning.http.client;

import ning.http.client.ProxyServer;
import ning.http.client.Request;

import java.io.IOException;
import java.util.concurrent.Future;

/**
 * Interface to be used when implementing custom asynchronous I/O HTTP client.
 * See {@link ning.http.client.providers.NettyAsyncHttpProvider}
 */
public interface AsyncHttpProvider {

    /**
     * Send the request and invoke the {@link Handler} when the response arrive.
     *
     * @param handler an instance of {@link AsyncHandler}
     * @return a {@link java.util.concurrent.Future}
     * @throws IOException
     */
    public <T> Future<T> handle(Request request, AsyncHandler<T> handler) throws IOException;

    /**
     * Close the current underlying TCP/HTTP connection.
     */
    public void close();

    public void setMaximumConnectionsTotal(int maxConnectionsTotal);

    public void setMaximumConnectionsPerHost(int maxConnectionsPerHost);

    public void setConnectionTimeout(long timeOutInMS);

    public void setIdleConnectionTimeout(long timeOutInMS);

    public void setRequestTimeout(int timeOutInMS);

    public void setFollowRedirects(boolean followRedirects);

    public void setMaximumNumberOfRedirects(int maxNumRedirects);

    void setProxyServer(final ProxyServer proxyServer);

    public void setCompressionEnabled(boolean compressionEnabled);

    public boolean isCompressionEnabled();

    public void setUserAgent(String userAgent);

}
