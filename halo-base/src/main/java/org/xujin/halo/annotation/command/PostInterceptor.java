package org.xujin.halo.annotation.command;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * Post Type Interceptor
 * @author xujin
 */
@Inherited
@Component
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface PostInterceptor {

    Class<? extends org.xujin.halo.dto.Command>[] commands() default {};

}
