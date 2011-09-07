package org.openqa.demo;

import static org.openqa.grid.common.RegistrationRequest.APP;
import static org.openqa.grid.common.RegistrationRequest.BROWSER;

import org.openqa.grid.internal.TestSession;
import org.openqa.grid.internal.TestSlot;
import org.openqa.grid.internal.utils.HtmlRenderer;

public class TotalTestAwareHtmlRenderer implements HtmlRenderer {

  private TestCounterWebDriverProxy proxy;

  @SuppressWarnings("unused")
  private TotalTestAwareHtmlRenderer() {}

  public TotalTestAwareHtmlRenderer(TestCounterWebDriverProxy proxy) {
    this.proxy = proxy;
  }

  public String renderSummary() {
    StringBuilder builder = new StringBuilder();
    builder.append("<fieldset>");
    builder.append("<legend>").append(proxy.getClass().getSimpleName()).append("</legend>");
    builder.append("listening on ").append(proxy.getRemoteURL());
    if (proxy.getTimeOut() > 0) {
      int inSec = proxy.getTimeOut() / 1000;
      builder.append("test session time out after ").append(inSec).append(" sec.");
    }

    builder.append("<br>Supports up to <b>").append(proxy.getMaxNumberOfConcurrentTestSessions())
        .append("</b> concurrent tests from : </u><br>");

    builder.append("this proxy ran ").append(proxy.getTotalTests()).append(" already.<br>");


    for (TestSlot slot : proxy.getTestSlots()) {
      builder.append(slot.getCapabilities().containsKey(BROWSER) ? slot.getCapabilities().get(
          BROWSER) : slot.getCapabilities().get(APP));
      TestSession session = slot.getSession();
      builder.append(session == null ? "(free)" : "(busy, session " + session + ")");
      builder.append("<br>");
    }
    builder.append("</fieldset>");
    return builder.toString();
  }
}
