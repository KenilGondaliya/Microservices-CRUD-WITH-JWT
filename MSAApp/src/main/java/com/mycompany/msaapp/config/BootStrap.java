package com.mycompany.msaapp.config;

import jakarta.annotation.security.DeclareRoles;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import org.eclipse.microprofile.auth.LoginConfig;

@LoginConfig(authMethod= "MP-JWT")
@DeclareRoles({"chief", "hacker"})
@ApplicationPath("rest")
public class BootStrap extends Application {
}