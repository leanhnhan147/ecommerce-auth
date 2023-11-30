package com.ecommerce.auth.controller;

import com.ecommerce.auth.constant.Constant;
import com.ecommerce.auth.utils.JwtUtils;
import com.ecommerce.auth.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;

import java.util.Objects;

public class ABasicController {
    @Autowired
    private UserServiceImpl userService;

    public long getCurrentUser(){
        JwtUtils jwtUtils = userService.getAddInfoFromToken();
        return jwtUtils.getAccountId();
    }

    public long getTokenId(){
        JwtUtils jwtUtils = userService.getAddInfoFromToken();
        return jwtUtils.getTokenId();
    }

    public JwtUtils getSessionFromToken(){
        return userService.getAddInfoFromToken();
    }

    public boolean isSuperAdmin(){
        JwtUtils jwtUtils = userService.getAddInfoFromToken();
        if(jwtUtils !=null){
            return jwtUtils.getIsSuperAdmin();
        }
        return false;
    }

    public boolean isShop(){
        JwtUtils jwtUtils = userService.getAddInfoFromToken();
        if(jwtUtils !=null){
            return Objects.equals(jwtUtils.getUserKind(), Constant.USER_KIND_MANAGER);
        }
        return false;
    }

    public String getCurrentToken() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            OAuth2AuthenticationDetails oauthDetails =
                    (OAuth2AuthenticationDetails) authentication.getDetails();
            if (oauthDetails != null) {
                return oauthDetails.getTokenValue();
            }
        }
        return null;
    }
}
