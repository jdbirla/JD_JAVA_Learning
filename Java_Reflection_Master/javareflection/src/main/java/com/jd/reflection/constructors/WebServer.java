/*
 *  MIT License
 *
 *  Copyright (c) 2020 Michael Pogrebinsky - Java Reflection - Master Class
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy
 *  of this software and associated documentation files (the "Software"), to deal
 *  in the Software without restriction, including without limitation the rights
 *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in all
 *  copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *  SOFTWARE.
 */

package com.jd.reflection.constructors;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;

public class WebServer {

    public void startServer() throws IOException {
        HttpServer httpServer = HttpServer.create(ServerConfiguration.getInstance().getServerAddress(), 0);

        httpServer.createContext("greeting").setHandler(exchange -> {

            String responseMessage = ServerConfiguration.getInstance().getGreetingMessage();

            exchange.sendResponseHeaders(200, responseMessage.length());

            OutputStream responseBody = exchange.getResponseBody();
            responseBody.write(responseMessage.getBytes());
            responseBody.flush();
            responseBody.close();
        });


        System.out.println(String.format("Starting server on address %s:%d",
                ServerConfiguration.getInstance().getServerAddress().getHostName(),
                ServerConfiguration.getInstance().getServerAddress().getPort()));

        httpServer.start();
    }
}
