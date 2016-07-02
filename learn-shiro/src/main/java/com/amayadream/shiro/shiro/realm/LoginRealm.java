package com.amayadream.shiro.shiro.realm;

import com.amayadream.shiro.model.User;
import com.amayadream.shiro.service.IUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
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
        String userId = (String)collection.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setRoles(userService.findRoles(userId));
        authorizationInfo.setStringPermissions(userService.findPermission(userId));
        return authorizationInfo;
    }

    /**
     * 登录验证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String userId = (String)authenticationToken.getPrincipal();
        User user = userService.findByUserId(userId);
        if (user == null) {
            throw new UnknownAccountException();    //没有找到账号
        }
        if (user.getState() == -1) {
            throw new LockedAccountException();     //账号锁定
        }
        //这里AuthenticatingRealm使用CredentialsMatcher进行密码匹配
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
            user.getUserId(),   //用户名
            user.getPassword(), //密码
            ByteSource.Util.bytes(user.getCredentialsSalt()),   //userId + salt
            getName()   //realm name
        );
        return authenticationInfo;
//        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
//        User user = userService.findByUserId(token.getUsername());
//        if(user != null){
//            return new SimpleAuthenticationInfo(user.getUserId(), user.getPassword(), getName());
//        }
//        return null;
    }

}
