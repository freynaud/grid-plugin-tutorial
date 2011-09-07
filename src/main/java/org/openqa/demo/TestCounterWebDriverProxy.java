package org.openqa.demo;

import org.openqa.grid.common.RegistrationRequest;
import org.openqa.grid.internal.Registry;
import org.openqa.grid.selenium.proxy.WebDriverRemoteProxy;

public class TestCounterWebDriverProxy extends WebDriverRemoteProxy {

  public TestCounterWebDriverProxy(RegistrationRequest request, Registry registry) {
    super(request, registry);

  }

}
