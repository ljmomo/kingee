package com.junly.common.freemarker;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.servlet.view.freemarker.FreeMarkerView;

public class FreeMarkerViewExtend
  extends FreeMarkerView
{
  protected void exposeHelpers(Map<String, Object> model, HttpServletRequest request)
  {
    try
    {
      super.exposeHelpers(model, request);
    }
    catch (Exception localException) {}
    model.put("_time", Long.valueOf(new Date().getTime()));
    model.put("NOW_YEAY", Integer.valueOf(Calendar.getInstance().get(1)));
    model.put("basePath", request.getContextPath());
  }
}
 	 	