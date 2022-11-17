package com.example.account.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    @Autowired
    private UserDetailsService userDetailsService;

    private static String HEADER = "Authorization";

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        // Lấy token từ header, /authenticate thì k gửi token, thì token sẽ là null
        // từ /hello, thì có điền token
        String token = httpServletRequest.getHeader(HEADER);

        Claims claims;
        if (token == null || !token.startsWith("Bearer ")) {
            claims = null;
        } else {
            token = token.replace("Bearer ", "");

            try {
                claims = Jwts.parser().setSigningKey("supersecret").parseClaimsJws(token).getBody();
            } catch (Exception ex) {
                claims = null;
            }
        }

//        Claims claims = jwtTokenUtil.getClaimsFromToken(token);
        if (claims == null) {
            filterChain.doFilter(httpServletRequest, httpServletResponse);
            return;
        }

        // Kiểm tra hạn token
        Date expiration = claims.getExpiration();
        if (expiration.before(new Date())) {
            filterChain.doFilter(httpServletRequest, httpServletResponse);
            return;
        }

        // Tạo object Authentication
        String username = claims.getSubject();
        if (username != null) {
            UserDetails user = userDetailsService.loadUserByUsername(username);
            UsernamePasswordAuthenticationToken authenticationObject = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());

            // Xác thực thành công, lưu object Authentication vào SecurityContextHolder
            SecurityContextHolder.getContext().setAuthentication(authenticationObject);
            filterChain.doFilter(httpServletRequest, httpServletResponse);
        }

    }

}
