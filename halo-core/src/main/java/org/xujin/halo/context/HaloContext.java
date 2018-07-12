package org.xujin.halo.context;

import org.xujin.halo.exception.BizException;

/**
 * 租户的上下文
 */
public class HaloContext {

   private static ThreadLocal<IdentityContext> haloContext = new ThreadLocal<>();

   private static class IdentityContext{
       String bizCode;
       String extBizCode;
       private IdentityContext(String bizCode,String extBizCode) {
           this.extBizCode = extBizCode;
           this.bizCode = bizCode;
       }
   }

   public static boolean exist(){
       return null != haloContext.get();
   }

   public static String getExtBizCode() {
       if (haloContext.get() == null || haloContext.get().extBizCode == null) {
           throw new BizException("No extBizCode in Context");
       }
       return haloContext.get().extBizCode;
   }

   public static String getBizCode() {
       if (haloContext.get() == null || haloContext.get().bizCode == null) {
           throw new BizException("No bizCode in Context");
       }
       return haloContext.get().bizCode;
   }

   public static void set(String bizCode,String extBizCode ) {
       IdentityContext identityContext = new IdentityContext(bizCode,extBizCode);
       haloContext.set(identityContext);
   }

   public static void remove() {
       haloContext.remove();
   }

}

