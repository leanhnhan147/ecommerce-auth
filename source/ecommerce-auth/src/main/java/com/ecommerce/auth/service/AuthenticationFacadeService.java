package com.ecommerce.auth.service;

import org.springframework.security.core.Authentication;

public interface AuthenticationFacadeService {

    Authentication getAuthentication();
}
