/*
 * Copyright 2014 Rodrigo Agerri

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */
package eus.ixa.ixa.pipe.nerc.features;

import java.util.List;

import eus.ixa.ixa.pipe.nerc.train.Flags;

import opennlp.tools.util.featuregen.FeatureGeneratorAdapter;

/**
 * Generates a feature which contains the token itself.
 */
public class TokenFeatureGenerator extends FeatureGeneratorAdapter {

  private boolean lowercase;

  public TokenFeatureGenerator(boolean lowercase) {
    this.lowercase = lowercase;
  }

  
  public TokenFeatureGenerator() {
    this(true);
  }

  public void createFeatures(List<String> features, String[] tokens, int index,
      String[] preds) {

    if (lowercase) {
      features.add("w=" + tokens[index].toLowerCase());
      if (Flags.DEBUG) {
        System.err.println("-> " + tokens[index].toLowerCase() + ": w=" + tokens[index].toLowerCase());
      }
    } else {
      features.add("w=" + tokens[index]);
    }
  }
}
