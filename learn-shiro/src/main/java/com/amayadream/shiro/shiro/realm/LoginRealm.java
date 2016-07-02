package com.amayadream.shiro.shiro.realm;

import com.amayadream.shiro.model.User;
import com.amayadream.shiro.service.IUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author :  Amayadream
 * @date :  2016.07.01 22:12
 */
@Component
public class LoginRealm extends AuthorizingRealm {

    /** 用户服务 */
    @Autowired private IUserService userService;

    /**
     * 权限认证
     * @param collection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection collection) {
        return null;
    }

    /**
     * 登录验证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        User user = userService.selectByUserId(token.getUsername());
        if(user != null){
            return new SimpleAuthenticationInfo(user.getUserId(), user.getPassword(), getName());
        }
        return null;
    }

}
