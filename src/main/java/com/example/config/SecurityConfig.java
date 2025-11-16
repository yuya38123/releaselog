package com.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
				.csrf(csrf -> csrf.disable()) // CSRF禁止（APIなのでOK）
				.authorizeHttpRequests(auth -> auth
						.anyRequest().permitAll() // 全部アクセス許可
				)
				.formLogin(login -> login.disable()) // デフォルトログイン画面OFF
				.httpBasic(basic -> basic.disable()); // Basic認証OFF

		return http.build();
	}
}
