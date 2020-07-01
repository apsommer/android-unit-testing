/*
 * Copyright 2018, Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.SimpleCalc;

// only imports from android.test, org.junit, and org.hamcrest ... no dependencies on Android framework
import android.test.suitebuilder.annotation.SmallTest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

/**
 * JUnit4 unit tests for the calculator logic. These are local unit tests; no device needed
 */
@RunWith(JUnit4.class) // define the test runner, JUnit4 is the default runner for Android Studio projects
@SmallTest // SmallTest indicates everything in this class is a unit test (no Android dependencies)
// @SmallTest, @MediumTest, and @LargeTest annotations are conventions to bundle tests with similar functionality
public class CalculatorTest {

    // declare a Calculator variable
    private Calculator mCalculator;

    /**
     * Set up the environment for testing
     */
    @Before // Before and setUp are used together to prepare the environment prior to test execution
    public void setUp() {

        // instantiate/initialize/assign a Calculator
        mCalculator = new Calculator();
    }

    /**
     * Test for simple addition
     */
    @Test // annotation defines the actual test, by convention the method name does not include "test"
    public void addTwoNumbers() {

        // all methods in test must be public or package-protected
        double resultAdd = mCalculator.add(1d, 1d);

        // assertion must evaluate TRUE to pass test
        assertThat(resultAdd, is(equalTo(2d)));
    }

    // general rule is to add one unit test for each assertion, they can be combined into a single @Test but then the
    // results are obscured if only one assertion fails

    @Test
    public void addTwoNegativeNumbers() {

        double resultAdd = mCalculator.add(-1d, 2d);

        // assertThat is JUnit4, this method is used with "matchers"
        // is(equalTo()) is a Hamcrest matcher
        assertThat(resultAdd, is(equalTo(1d)));
    }

    @Test
    public void addTwoNumbersFloats() {

        // add() method takes doubles as input parameters, therefore floats are also acceptable
        double resultAdd = mCalculator.add(1.111f, 1.111f);

        // due to precision errors in they type conversion an error delta is required with closeTo()
        assertThat(resultAdd, is(closeTo(2.222d, 0.01d)));
    }
}