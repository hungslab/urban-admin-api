package com.hungslab.urban.core.Config;

/**
 * @author hungs
 * @date 2024-05-06
 * @Description 支付宝配置常量类
 */
public class AlipayConfig {
    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "9021000136673107";
    // 私钥
    public static String merchant_private_key = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCW++k0/TSyhl/lH4fegeJterv5xRtRWuRQorplhAIYr/13rz7kzsEt82BqksI5ij90CstgAgNc+53+7acFOEAH+NG92NRp+GkDIkH7pERzgumU523ey6gHaFDWW0+A15LuYYyEnO+T7Zu05XNHQGgG/mSBxCRLcf2NSMHCYBwUbSdabgdw9iMEHYXHs8vV67NbXH8DQ6pA/2ICn1ExJ9bYtO2xeqYotwRQys7sL8o/wRmD95XgUE7U/ltzjHlPDQfCTFNqs6nMl1jADxVa2UuhXaGq33ZejxbIFot1i0ABPEOi+D6YAVVtmPPrj3ym6NRBuux6fCilamGaqC6+ty0PAgMBAAECggEAIFV0fO+Y4H6cfMIC4+jm59E3/mZy0jpn2MjwqBrcJBNUcdQq4O9SOZf8VvZ098OekShao4Xq2HfePyD/+sMwG0TzDfgojUUwoAYvIUftjNtFUKk7Q1JT+rohTbaiURJZmgl0AVZmjER/av8Ub/bgEFdciNnLeAjCZwZk0E6q1MizQCYSx5JJIJQh5UiY0v0DrldVRkj0oVO8eISEXLK5lAIRPTYYctQdmrcX8HT//YZYE1QVJXPpzap6A36Xz+Q8fgWotU1IB+sGpnfeaARTZNDyFzoAZxJ8MkvMcaKAqK8tYRdsSWuw70xpBsJgZ2Rwn9B5FixCCgtAPu3bNIXhWQKBgQDJjpTKA9L41zW2DVwhXcuI5wARNPfgQyDMhGLTWEF4XPDAnmVuTzujvXcpqVInRzza7p9dRFBjPlyhq0+SwKeYUcpeTY69P9CGZpjJ1gTPj21FZLYwbsjIv2RaQkeyaZ7frY3SE+GQPepsH+6CdCkN19thn1HthirgxVHjcWlMYwKBgQC/xEXlyf8gthWtOm8MOb9VyVwW4WOmDbH46lPSqO1CQKzAUmgNf1Q534DCeMjfBqDaLXIvt3fc0lOXRbyvbP9pTlwBNS9VQ0SYWulty0vlKsHsPXosw5AJG8smP48Ge/vo2enJpynsa8ImoJMl+o3eqxRwx3pDwyqq8kzvPLjuZQKBgBZe9vC9H+typ4l/Thx99ptJWF6QjHqduMQ6ZWWjxBCB8E7Qxd1Kegoge1tqaa3mYEDEf3ewn2OEhm+DPh/BtlhXq6hv30nuDUz9kjPEx1/qQWyUUwxpH2v4okDKXn7U7kdRUg5hGoYR+TTrDmP4VJ4uuTDKqCM+4v9zpzUhX1iVAoGAYQmlwRjNJDVflK/r/4i9PGDPW7ij3yQw+d9BmWjn3k2x3QQWKTZUXZCurDnIk6rb/Gtgy6qQWcqIiBS+3RpPyG7hea77C68lZ98hHfDwr79KMAwP5dTz7tgEnY8uBb75gyO5/NO9ECibL0a0D1TRM2roxgT65o086xH/QlQ81E0CgYAapEQeG7S4r0RyeDZ/6X4C2UIsMpLJAQyO/aiBjEoTCsn1FQOTjMsTn6cpdHura9QqmaywX+S3jyTSfLmwWuai+tSokY/TsdcN3ninjptiTtOjrUs/RZyXDV+1iHtFGLqTj9LGQsgss9UizYOCv799gewC+SsiXKiGXZ9U4fy3aw==";
    // 支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAnIvRjReyXYfr4/RkCA84JYx3yRPdE4nNO3eVifzp7DuqZ+e8nBBdJu3Zpocxj/Lp5HVbcK01uCWM2OU6MVD1cpwLc13gigZ4Hwy/+5ojAbPnj6AnMySqJDzNXOet4Xym57lUbeYa7r8bKn8AEBdPH5ne05V0wUfz9L1uk9zLRKHL+0rcYR37gLL6Q+7FDw6fhnsW9Qac+qouKTppmnFE+jsD/vee8wkBqaaWEyTV2d69ljJM4a/HkwHCxw3qXiHhl9KZgqLgmbYU+meZlx910aZdsZ5/7P1t+EBghHLe1n+wwn0KpLFh3OTLVw9XUtywCdOW5/+jIn3H7xAIOxRS1wIDAQAB";
    // 服务器异步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    /**
     * 返回的时候此页面不会返回到用户页面，只会执行你写到控制器里的地址
     */
    public static String notify_url = "https://****/notifyUrl";
    // 页面跳转同步通知页面路径
    public static String return_url = "http://*****/alipay/returnUrl";
    // 签名方式
    public static String sign_type = "RSA2";
    // 字符编码格式
    public static String charset = "utf-8";
    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
    // 日志地址
    //public static String log_path = "";
}
