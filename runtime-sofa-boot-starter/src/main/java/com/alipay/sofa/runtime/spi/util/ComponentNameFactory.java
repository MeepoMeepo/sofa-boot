/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alipay.sofa.runtime.spi.util;

import com.alipay.sofa.runtime.api.component.ComponentName;
import com.alipay.sofa.runtime.model.ComponentType;

/**
 * ComponentName Factory
 *
 * @author xuanbei 18/2/28
 */
public class ComponentNameFactory {
    /**
     * create ComponentName by component type and class type
     *
     * @param type
     * @return
     */
    public static ComponentName createComponentName(ComponentType type, Class<?> clazz) {
        return new ComponentName(type, mergeComponentName(clazz, null));
    }

    /**
     * create ComponentName by component type and component name
     *
     * @param type
     * @param name
     * @return
     */
    public static ComponentName createComponentName(ComponentType type, String name) {
        return new ComponentName(type, name);
    }

    /**
     * create ComponentName by component type,class type and unique id
     *
     * @param type
     * @return
     */
    public static ComponentName createComponentName(ComponentType type, Class<?> clazz,
                                                    String uniqueId) {
        return new ComponentName(type, mergeComponentName(clazz, uniqueId));
    }

    /**
     * create ComponentName by class type and unique id
     *
     * @param clazz
     * @param uniqueId
     * @return
     */
    private static String mergeComponentName(Class<?> clazz, String uniqueId) {
        String ret = clazz.getName();
        if (uniqueId != null && uniqueId.length() > 0) {
            ret += ":" + uniqueId;
        }
        return ret;
    }
}
