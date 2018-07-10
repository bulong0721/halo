package org.xujin.halo.annotation.extension;

import org.springframework.stereotype.Component;
import org.xujin.halo.common.CoreConstant;

import java.lang.annotation.*;

/**
 * Extension 
 * @author xujin
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target({ElementType.TYPE})
@Component
public @interface Extension {

    /**
     * 扩展的Id
     * @return
     */
    String id() default "";

    /**
     * 对应的扩展点Id
     * @return
     */
    String extensionPointId() default "";

    /**
     * 扩展对应的描述
     * @return
     */
    String desc() default "";

    boolean defaultExtension() default false;

    /**
     * 一级业务code
     * @return
     */
    String bizCode()  default CoreConstant.DEFAULT_BIZ_CODE;

    /**
     * 二级业务code
     * @return
     */
    String tenantId() default CoreConstant.DEFAULT_TENANT_ID;
}
