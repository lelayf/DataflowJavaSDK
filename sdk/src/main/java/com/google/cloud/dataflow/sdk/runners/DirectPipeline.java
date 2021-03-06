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

package com.google.cloud.dataflow.sdk.runners;

import com.google.cloud.dataflow.sdk.Pipeline;
import com.google.cloud.dataflow.sdk.options.DirectPipelineOptions;

/**
 * A DirectPipeline, which returns a
 * {@link DirectPipelineRunner.EvaluationResults} subclass of PipelineResult
 * from {@link com.google.cloud.dataflow.sdk.Pipeline#run()}.
 */
public class DirectPipeline extends Pipeline {

  /**
   * Creates and returns a new DirectPipeline instance for tests.
   */
  public static DirectPipeline createForTest() {
    DirectPipelineRunner runner = DirectPipelineRunner.createForTest();
    return new DirectPipeline(runner, runner.getPipelineOptions());
  }

  private DirectPipeline(DirectPipelineRunner runner, DirectPipelineOptions options) {
    super(runner, options);
  }

  @Override
  public DirectPipelineRunner.EvaluationResults run() {
    return (DirectPipelineRunner.EvaluationResults) super.run();
  }

  @Override
  public DirectPipelineRunner getRunner() {
    return (DirectPipelineRunner) super.getRunner();
  }
}
