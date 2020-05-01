package com.tms.tag;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class CustomTag extends TagSupport {

    public int doStartTag() {
        JspWriter out = pageContext.getOut();
        try {
            out.print("Copyright: 2020 by TMS");
        } catch (Exception e) {
            System.out.println(e);
        }
        return SKIP_BODY;
    }

}
