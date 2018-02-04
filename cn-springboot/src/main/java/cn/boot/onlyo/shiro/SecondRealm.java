package cn.boot.onlyo.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.util.ByteSource;

public class SecondRealm extends AuthenticatingRealm {

    // AuthenticatingRealm
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("secondRealm" + token.hashCode());
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
            credentials = "ce2f6417c7e1d32c1d81a797ee0b499f87c5de06--";
        }
        if ("user".equals(userName)) {
            credentials = "073d4c3ae812935f23cb3f2a71943f49e082a718---";
        }

        // (3). realmName:当前realm对象的name ，调用父类的getName（）方法即可
        String realm = getName();
        ByteSource salt = ByteSource.Util.bytes(userName);
        SimpleAuthenticationInfo sa = new SimpleAuthenticationInfo(principal, credentials, salt, realm);
        return sa;
    }

    public static void main(String[] args) {

        String hashA = "SHA1";
        Object cred = "123456";
        Object salt = "admin";
        int hasInt = 1024;
        Object result = new SimpleHash(hashA, cred, salt, hasInt);
        System.out.println(result);
    }
}
