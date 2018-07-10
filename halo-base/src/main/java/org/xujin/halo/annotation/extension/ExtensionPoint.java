package org.xujin.halo.annotation.extension;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ExtensionPoint {

    /**
     * 扩展点id
     * @return
     */
    String id();

    /**
     * 扩展点描述
     * @return
     */
    String desc();


}
