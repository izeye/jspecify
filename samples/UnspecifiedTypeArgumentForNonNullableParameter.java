/*
 * Copyright 2020 The JSpecify Authors.
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
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.NullnessUnspecified;

@NullMarked
class UnspecifiedTypeArgumentForNonNullableParameter {
  interface SupplierWithNonNullableBound<E> {
    E get();
  }

  String x0(
      // :: error: jspecify_nullness_not_enough_information
      SupplierWithNonNullableBound<@NullnessUnspecified String> s) {
    return s.get();
  }

  <E extends String> String x1(
      // :: error: jspecify_nullness_not_enough_information
      SupplierWithNonNullableBound<@NullnessUnspecified E> s) {
    return s.get();
  }

  <E extends @NullnessUnspecified String> String x2(
      // :: error: jspecify_nullness_not_enough_information
      SupplierWithNonNullableBound<E> s) {
    return s.get();
  }

  <E extends @NullnessUnspecified String> String x3(
      // :: error: jspecify_nullness_not_enough_information
      SupplierWithNonNullableBound<@NullnessUnspecified E> s) {
    return s.get();
  }
}
