package com.example.day_17_1118_blog.security;

import io.jsonwebtoken.Claims;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

// Kiểm tra cho mỗi request gửi lên
@Component
@AllArgsConstructor
public class CustomFilter extends OncePerRequestFilter {
    private JwtUtils jwtUtils;
    private CustomUserDetailService customUserDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // Lấy token từ trong header của request
        String token = jwtUtils.getTokenFromRequest(request);
        if(token == null) {
            filterChain.doFilter(request, response);
            return;
        }

        // Parse thông tin từ token
        Claims claims = jwtUtils.getClaimsFromToken(token);

        // Kiểm tra token đã hết hạn hay chưa
        if(claims.getExpiration().before(new Date())) {
            filterChain.doFilter(request, response);
            return;
        }

        // Lấy thông tin của user dựa trên email
        String email = claims.getSubject();
        UserDetails userDetails = customUserDetailsService.loadUserByUsername(email);

        // Tạo đối tượng authentication
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

        // Lưu vào trong context
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        filterChain.doFilter(request, response);
    }
}