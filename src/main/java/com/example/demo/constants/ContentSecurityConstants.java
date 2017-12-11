package com.example.demo.constants;

/**
 * 加密内容常量配置
 * 如DES请求参数key
 * ========================
 * Created with IntelliJ IDEA.
 * User：恒宇少年
 * Date：2017/10/11
 * Time：22:57
 * 码云：http://git.oschina.net/jnyqy
 * ========================
 */
public interface ContentSecurityConstants {
    /**
     * 加密内容字符集
     */
    String CONTENT_CHARSET = "UTF-8";
    /**
     * DES方式请求的request key
     */
    String DES_PARAMETER_NAME = "desString";
    /**
     * DES解密key
     */
    String DES_KEY = "DE76E3EC39801CEEE0440025";
    /**
     * 传递的attribute前缀
     */
    String ATTRIBUTE_PREFFIX = "security_";
}
