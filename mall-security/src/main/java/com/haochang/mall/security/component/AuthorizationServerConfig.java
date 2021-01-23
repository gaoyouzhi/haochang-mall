package com.haochang.mall.security.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

/**
 * @description: 描述：认证中心服务配置
 * @author: youzhi.gao
 * @date: 2021-01-20 14:12
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("front_app")
                .secret("front_app")
                .authorizedGrantTypes("authorization_code", "password", "refresh_token")
                .accessTokenValiditySeconds(3600)
                .scopes("read")
                .redirectUris("www.baidu.com")
                .and()
                .withClient("order_app")
                .secret("order_app")
                .scopes("read")
                .authorizedGrantTypes("authorization_code", "password", "refresh_token")
                .resourceIds("order-service")
                .and()
                .withClient("product_app")
                .secret("product_app")
                .scopes("read")
                .authorizedGrantTypes("authorization_code", "password", "refresh_token")
                .resourceIds("product-service");
    }
}
