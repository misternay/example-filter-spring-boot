package com.example.demo.filters;

import com.example.demo.model.SecureRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.*;

import static java.nio.charset.StandardCharsets.UTF_8;

public class HttpServletRequestWritableWrapper extends HttpServletRequestWrapper {

    private String decodeBody = "";

    public HttpServletRequestWritableWrapper(HttpServletRequest request) {
        super(request);
        try {
            InputStream inputStream = request.getInputStream();
            byte[] rawData = IOUtils.toByteArray(inputStream);
            ObjectMapper mapper = new ObjectMapper();

            //MAP request to Secure Request prepare to do something
            SecureRequest secureRequest = mapper.readValue(rawData, SecureRequest.class);
            System.out.println("param 1 -> " + secureRequest.getParam1());
            System.out.println("param 2 -> " + secureRequest.getParam2());

//            secureRequest.getParam1() do process decrypt here
            //Example mock data if decrpt finnish.
            String plainTextAfterDecrypt = "{\"mobileNo\":\"rD12Rkn3f1dOzGRFCI7MaYD6aUBK5tWb4y7+dGDnoxI=\",\"citizenNo\":\"1adada2dsa\"}";
            this.decodeBody = plainTextAfterDecrypt;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ServletInputStream getInputStream() {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(decodeBody.getBytes(UTF_8));
        return new ServletInputStream() {
            @Override
            public boolean isFinished() {
                return false;
            }

            @Override
            public boolean isReady() {
                return false;
            }

            @Override
            public void setReadListener(ReadListener readListener) {

            }

            @Override
            public int read() {
                return byteArrayInputStream.read();
            }
        };
    }

    @Override
    public BufferedReader getReader() throws IOException {
        return new BufferedReader(new InputStreamReader(this.getInputStream()));
    }
}