package com.tms.sbsecurity.app.utils;

import com.tms.sbsecurity.app.security.model.CustomPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;

public class AppUtils {
    public static Long getCurrentUserId() {
        CustomPrincipal principal = (CustomPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return principal.getCurrentUserId();
    }
}
