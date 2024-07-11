
package com.example.day3.config;


import jakarta.servlet.ServletException;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.support.RequestContextUtils;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Locale;

@Configuration
public class ValidationConfig implements WebMvcConfigurer {

    // Định nghĩa một Bean để cấu hình nguồn thông báo (MessageSource)
    @Bean
    public MessageSource messageSource() {
        // Tạo một đối tượng ReloadableResourceBundleMessageSource để nạp các tệp tin tài nguyên
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        // Đặt các tên cơ sở của các tệp tin tài nguyên
        messageSource.setBasenames("classpath:menu", "classpath:message");
        // Đặt mã hóa mặc định là UTF-8
        messageSource.setDefaultEncoding("utf-8");
        // Trả về đối tượng messageSource
        return messageSource;
    }

    // Định nghĩa một Bean để cấu hình cách xác định locale
    @Bean(name = "localeResolver")
    public LocaleResolver localeResolver() {
        // Tạo một đối tượng CookieLocaleResolver để lưu trữ locale trong cookie
        CookieLocaleResolver localeResolver = new CookieLocaleResolver();
        // Đặt tên cho cookie
        localeResolver.setCookieName("lang");
        // Đặt đường dẫn cho cookie
        localeResolver.setCookiePath("/");
        // Đặt thời gian sống của cookie (10 ngày)
        localeResolver.setCookieMaxAge(10 * 24 * 60 * 60);
        // Đặt locale mặc định là tiếng Anh
        localeResolver.setDefaultLocale(new Locale("en"));
        // Trả về đối tượng localeResolver
        return localeResolver;
    }

    // Override phương thức addInterceptors để thêm các interceptor
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // Tạo một đối tượng LocaleChangeInterceptor để thay đổi locale dựa trên tham số yêu cầu
        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor() {
            // Override phương thức preHandle để thực hiện xử lý trước khi yêu cầu được xử lý
            @Override
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException {
                // Lấy locale hiện tại trước khi thay đổi
                Locale currentLocale = RequestContextUtils.getLocale(request);
                // In ra locale hiện tại
                System.out.println("Current locale before change: " + currentLocale);

                // Gọi phương thức preHandle của superclass để thực hiện thay đổi locale
                boolean result = super.preHandle(request, response, handler);

                // Lấy locale mới sau khi thay đổi
                Locale newLocale = RequestContextUtils.getLocale(request);
                // In ra locale mới
                System.out.println("New locale after change: " + newLocale);
                // In ra tham số "lang" từ yêu cầu
                System.out.println("Language parameter: " + request.getParameter("lang"));

                // Trả về kết quả của phương thức preHandle của superclass
                return result;
            }
        };
        // Đặt tên tham số là "lang"
        localeChangeInterceptor.setParamName("lang");
        // Thêm interceptor vào registry và áp dụng cho tất cả các đường dẫn
        registry.addInterceptor(localeChangeInterceptor).addPathPatterns("/**");
    }
}
