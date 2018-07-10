package org.xujin.halo.test;

import org.xujin.halo.annotation.extension.ExtensionPoint;

import java.util.List;

@ExtensionPoint(id="PaymentQueryServiceExtensionPoint",desc="PaymentQueryService Desc")
public interface PaymentQueryService {

    List<String> queryAllPayMethod(String str);

}
