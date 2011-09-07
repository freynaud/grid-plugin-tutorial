package org.openqa.demo;

import org.openqa.grid.common.RegistrationRequest;
import org.openqa.grid.internal.Registry;
import org.openqa.grid.internal.TestSession;
import org.openqa.grid.internal.listeners.TestSessionListener;
import org.openqa.grid.internal.utils.HtmlRenderer;
import org.openqa.grid.selenium.proxy.WebDriverRemoteProxy;

public class TestCounterWebDriverProxy extends WebDriverRemoteProxy implements TestSessionListener {

  private int totalTests = 0;

  public TestCounterWebDriverProxy(RegistrationRequest request, Registry registry) {
    super(request, registry);
  }


  @Override
  public void beforeSession(TestSession session) {
    super.beforeSession(session);
    synchronized (this) {
      totalTests++;
    }
  }


  public synchronized int getTotalTests() {
    return totalTests;
  }

  private HtmlRenderer renderer = new TotalTestAwareHtmlRenderer(this);

  @Override
  public HtmlRenderer getHtmlRender() {
    return renderer;
  }



}
