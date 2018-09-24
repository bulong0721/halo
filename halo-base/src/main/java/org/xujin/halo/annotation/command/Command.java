package org.xujin.halo.annotation.command;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * Command Annotation
 * @author xujin
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Component
public @interface Command {

}
