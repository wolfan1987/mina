/*
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 *
 */
package org.apache.mina.codec.delimited;

import org.apache.mina.codec.delimited.ints.VarInt;
import org.apache.mina.codec.delimited.serialization.ProtobufMessageDecoder;

import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;

public class ProtobufDecoder<M extends GeneratedMessage> extends SizePrefixedDecoder<M> {
    static public <L extends GeneratedMessage> ProtobufDecoder<L> newInstance(Class<L> clazz,
            ExtensionRegistryLite registry) throws SecurityException, NoSuchMethodException {
        return new ProtobufDecoder<L>(clazz, registry);
    }

    static public <L extends GeneratedMessage> ProtobufDecoder<L> newInstance(Class<L> clazz) throws SecurityException,
            NoSuchMethodException {
        return newInstance(clazz, ExtensionRegistryLite.getEmptyRegistry());
    }

    public ProtobufDecoder(Class<M> clazz, ExtensionRegistryLite registry) throws SecurityException,
            NoSuchMethodException {
        super(new VarInt.Decoder(), ProtobufMessageDecoder.newInstance(clazz, registry));
    }
}