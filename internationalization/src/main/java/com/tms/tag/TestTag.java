package com.tms.tag;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class TestTag  extends TagSupport {

    public int doStartTag() {

        System.out.println("Inside custom tag");

        JspWriter out = pageContext.getOut();
        try {
            out.print("test information");
        } catch (Exception e) {
            System.out.println(e);
        }
        return SKIP_BODY;
    }

    @Override
    public Object getValue(String k) {
        return super.getValue(k);
    }
}
