package org.xujin.halo.test;

import org.xujin.halo.annotation.extension.Extension;

import java.util.List;

@Extension(id="PaymentQueryService",extensionPointId="PaymentQueryServiceExtensionPoint" ,desc = "测试扩展")
public class PaymentQueryServiceImpl implements PaymentQueryService{

    @Override
    public List<String> queryAllPayMethod(String str) {
        return null;
    }
}
