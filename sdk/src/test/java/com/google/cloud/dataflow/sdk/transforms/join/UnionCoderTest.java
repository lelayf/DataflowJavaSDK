/*
 * Copyright (C) 2014 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.google.cloud.dataflow.sdk.transforms.join;

import static org.junit.Assert.assertEquals;

import com.google.cloud.dataflow.sdk.coders.Coder;
import com.google.cloud.dataflow.sdk.coders.DoubleCoder;
import com.google.cloud.dataflow.sdk.coders.StringUtf8Coder;
import com.google.cloud.dataflow.sdk.util.CloudObject;
import com.google.cloud.dataflow.sdk.util.Serializer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;

/**
 * Tests the UnionCoder.
 */
@RunWith(JUnit4.class)
public class UnionCoderTest {

  @Test
  public void testSerializationDeserialization() {
    UnionCoder newCoder =
        UnionCoder.of(Arrays.<Coder<?>>asList(StringUtf8Coder.of(),
            DoubleCoder.of()));
    CloudObject encoding = newCoder.asCloudObject();
    Coder<?> decodedCoder = Serializer.deserialize(encoding, Coder.class);
    assertEquals(newCoder, decodedCoder);
  }
}
