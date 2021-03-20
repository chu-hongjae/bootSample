package com.chu.web.common.filter;


import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import org.apache.commons.io.IOUtils;

public class ReadableRequestBodyWrapper extends HttpServletRequestWrapper {

  private byte[] bytes;
  private String requestBody;

  public ReadableRequestBodyWrapper(HttpServletRequest request) throws IOException {
    super(request);

    InputStream in = super.getInputStream();
    bytes = IOUtils.toByteArray(in);
    requestBody = new String(bytes);
  }

  @Override
  public ServletInputStream getInputStream() throws IOException {
    final ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
    return new ServletImpl(bis);
  }

  public String getRequestBody() {
    return this.requestBody;
  }

  class ServletImpl extends ServletInputStream {

    private InputStream inputStream;

    public ServletImpl(InputStream inputStream) {
      this.inputStream = inputStream;
    }

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
    public int read() throws IOException {
      return inputStream.read();
    }

    @Override
    public int read(byte[] b) throws IOException {
      return inputStream.read(b);
    }

  }
}