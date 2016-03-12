package com.amayadream.shiro.realm;

import com.amayadream.shiro.pojo.User;
import com.amayadream.shiro.service.IUserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;

/**
 * @author :  Amayadream
 * @date :  2016.03.12 16:00
 */
public class LoginRealm extends AuthorizingRealm {

    @Resource private IUserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String userid=(String)token.getPrincipal();
        User user = userService.selectByUserid(userid);
        if (user != null) {
            AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(user.getUserid(), user.getPassword(), "xx");
            return authcInfo;
        } else {
            return null;
        }
    }
}
