package com.finanace.app.security;

import com.finanace.app.model.Role;

public class RoleChecker {

    public static void checkAdmin(Role role) {
        if (role != Role.ADMIN) {
            throw new RuntimeException("Access Denied: Admin only");
        }
    }

    public static void checkViewerOrAnalyst(Role role) {
        if (role == Role.VIEWER || role == Role.ANALYST || role == Role.ADMIN) {
            return;
        }
        throw new RuntimeException("Access Denied");
    }
}