package com.github.wenhao.monitor.core.dependencies;

import com.github.wenhao.monitor.core.dependencies.http.ClientModule;
import com.github.wenhao.monitor.core.dependencies.http.EntityModule;
import com.github.wenhao.monitor.core.dependencies.http.RequestModule;
import se.jbee.inject.bind.BuildinBundle;
import se.jbee.inject.bootstrap.BootstrapperBundle;

public class RootBundle extends BootstrapperBundle
{

    @Override
    protected void bootstrap()
    {
        install(ClientModule.class);
        install(EntityModule.class);
        install(RequestModule.class);
        install(BuildinBundle.LIST);
    }
}
