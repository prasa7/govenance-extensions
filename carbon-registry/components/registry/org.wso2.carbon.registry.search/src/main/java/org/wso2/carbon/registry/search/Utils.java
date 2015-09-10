/*
*  Copyright (c) 2005-2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
*  WSO2 Inc. licenses this file to you under the Apache License,
*  Version 2.0 (the "License"); you may not use this file except
*  in compliance with the License.
*  You may obtain a copy of the License at
*
*    http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing,
* software distributed under the License is distributed on an
* "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
* KIND, either express or implied.  See the License for the
* specific language governing permissions and limitations
* under the License.
*/
package org.wso2.carbon.registry.search;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.wso2.carbon.registry.common.AttributeSearchService;
import org.wso2.carbon.registry.core.service.RegistryService;
import org.wso2.carbon.registry.indexing.service.ContentSearchService;
import org.wso2.carbon.registry.indexing.service.TermsSearchService;

public class Utils {
    private static final Log log = LogFactory.getLog(Utils.class);

    private static RegistryService registryService;
    private static ContentSearchService contentSearchService;
    private static AttributeSearchService attributeSearchService;
    private static TermsSearchService termsSearchService;

    public static synchronized void setRegistryService(RegistryService service) {
        registryService = service;
    }

    public static RegistryService getRegistryService() {
        return registryService;
    }

    public static synchronized void setContentSearchService(ContentSearchService service){
         contentSearchService = service;
    }

    public static ContentSearchService getContentSearchService(){
        return contentSearchService;
    }

    public static void setAttributeIndexingService(AttributeSearchService service) {
        attributeSearchService = service;
    }

    public static AttributeSearchService getAttributeSearchService() {
        return attributeSearchService;
    }

    /**
     * This method is used to get TermSearchService.
     *
     * @return termSearchService
     */
    public static TermsSearchService getTermsSearchService() {
        return termsSearchService;
    }

    /**
     * This method is used to set TermSearchService.
     *
     * @param termsSearchService TermSearchService
     */
    public static void setTermsSearchService(TermsSearchService termsSearchService) {
        Utils.termsSearchService = termsSearchService;
    }
}
