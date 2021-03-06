/**
 * Copyright 2010 CosmoCode GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package de.cosmocode.palava.scope;

import com.google.common.base.Function;
import com.google.inject.Key;

/**
 * A noop implementation used by {@link ScopingProvider}.
 * 
 * @author Willi Schoenborn
 * @param <T> generic key type
 */
final class NoopKeyEncoder<T> implements Function<Key<T>, Object> {

    @Override
    public Object apply(Key<T> input) {
        return input;
    }
    
}
