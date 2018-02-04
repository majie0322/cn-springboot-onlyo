package cn.boot.onlyo.shiro;

import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

public class ShiroRealm extends AuthorizingRealm {

    // AuthenticatingRealm
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("1111111111111");
        System.out.println("doGetAuthenticationInfo" + token.hashCode());
        // 1 把AuthenticationToken 转换成UsernamePasswordToken
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;
        // 2 从转换成UsernamePasswordToken中获取username
        String userName = upToken.getUsername();
        // 3 调用数据库的方法 从数据库中查询username 对应的用户记录
        System.out.println("从数据库中获取username ：" + userName + "所对应的用户信息");
        // 4 若用户不存在 ，则可以抛出unKnownAccountException
        if ("unKnow".equals(userName)) {
            throw new UnknownAccountException("用户不存在");
        }
        // 5 根据用户信息的情况，决定是否需要抛出其他AuthenticationException
        if ("monster".equals(userName)) {
            throw new LockedAccountException("用户被锁定");
        }
        // 6 根据用户的情况，来构建AuthenticationInfo 对象返回
        // 以下信息是从数据库中获取
        // （1） .principal：认证的实体信息，可以是username，也可以是 数据库表对应的用户实体对象
        Object principal = userName;
        // (2) . credentials:密码
        Object credentials = "fc1709d0a95a6be30bc5926fdb7f22f4";
        if ("admin".equals(userName)) {
            credentials = "038bdaf98f2037b31f1e75b5b4c9b26e";
        }
        if ("user".equals(userName)) {
            credentials = "098d2c478e9c11555ce2823231e02ec1";
        }

        // (3). realmName:当前realm对象的name ，调用父类的getName（）方法即可
        String realm = getName();
        ByteSource salt = ByteSource.Util.bytes(userName);
        SimpleAuthenticationInfo sa = new SimpleAuthenticationInfo(principal, credentials, salt, realm);
        return sa;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("权限验证");
        // 1. 从 PrincipalCollection 中来获取登录用户的信息
        Object principal = principals.getPrimaryPrincipal();

        // 2. 利用登录的用户的信息来用户当前用户的角色或权限(可能需要查询数据库)
        Set<String> roles = new HashSet<>();
        roles.add("user");
        if ("admin".equals(principal)) {
            roles.add("admin");
        }
        // 3. 创建 SimpleAuthorizationInfo, 并设置其 reles 属性.
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roles);

        // 4. 返回 SimpleAuthorizationInfo 对象.
        return info;
    }

    public static void main(String[] args) {

        String hashA = "MD5";
        Object cred = "123456";
        Object salt = "user";
        int hasInt = 1024;
        Object result = new SimpleHash(hashA, cred, salt, hasInt);
        System.out.println(result);
    }

}
