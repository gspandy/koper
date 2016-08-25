/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package koper;

import com.alibaba.fastjson.JSON;
import kafka.serializer.Encoder;

import java.io.UnsupportedEncodingException;

/**
 * @author kk
 * @since 1.0
 */
public class MsgBeanEncoder implements Encoder<MsgBean<String, String>> {

    @Override
    public byte[] toBytes(MsgBean<String, String> msgBean) {
        String json = JSON.toJSONString(msgBean);
        try {
            return json.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Fail to encode msgbean " + e.getMessage(), e);
        }
    }
}
