/*
 *  Copyright (c) 2005-2013, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  WSO2 Inc. licenses this file to you under the Apache License,
 *  Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 *
 */
package org.wso2.carbon.governance.api.cache;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.wso2.carbon.context.PrivilegedCarbonContext;
import org.wso2.carbon.context.RegistryType;
import org.wso2.carbon.governance.api.util.GovernanceUtils;
import org.wso2.carbon.registry.core.Registry;
import org.wso2.carbon.registry.core.exceptions.RegistryException;
import org.wso2.carbon.registry.core.internal.RegistryCoreServiceComponent;

import javax.cache.event.CacheEntryEvent;
import javax.cache.event.CacheEntryListener;
import javax.cache.event.CacheEntryListenerException;
import javax.cache.event.CacheEntryUpdatedListener;

/**
 * This is a listener class to listen to cache entry updates
 * @param <K>
 * @param <V>
 */
public class RXTConfigCacheEntryUpdatedListener<K, V>  implements CacheEntryUpdatedListener<K, V> {
    private static final Log log = LogFactory.getLog(RXTConfigCacheEntryUpdatedListener.class);
    @Override
    public void entryUpdated(CacheEntryEvent<? extends K, ? extends V> cacheEntryEvent) throws CacheEntryListenerException {
        try {
            Registry registry = RegistryCoreServiceComponent.getRegistryService().getGovernanceSystemRegistry();
            GovernanceUtils.registerArtifactConfigurationByPath(registry, PrivilegedCarbonContext.getThreadLocalCarbonContext().getTenantId(), cacheEntryEvent.getKey().toString());
        } catch (RegistryException e) {
            log.error("Error while updating artifact configurations",e);
        }
    }
}
