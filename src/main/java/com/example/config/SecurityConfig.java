package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Bean
	public PasswordEncoder papsswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
				.csrf(csrf -> csrf.disable()) // CSRF禁止（APIなのでOK）
				.headers(headers -> headers.disable())
				.authorizeHttpRequests(auth -> auth
						.anyRequest().permitAll() // 全部アクセス許可（あとで絞る）
				)
				.formLogin(login -> login.disable()) // デフォルトログイン画面OFF
				.httpBasic(basic -> basic.disable()); // Basic認証OFF

		return http.build();
	}
}
