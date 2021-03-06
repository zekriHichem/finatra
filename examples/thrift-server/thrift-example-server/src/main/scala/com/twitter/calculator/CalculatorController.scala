package com.twitter.calculator

import com.twitter.calculator.thriftscala.Calculator
import com.twitter.calculator.thriftscala.Calculator._
import com.twitter.finatra.thrift.Controller
import com.twitter.util.Future
import javax.inject.Singleton

@Singleton
class CalculatorController extends Controller(Calculator) {

  handle(AddNumbers) { args: AddNumbers.Args =>
    info(s"Adding numbers $args.a + $args.b")
    Future.value(args.a + args.b)
  }

  handle(AddStrings) { args: AddStrings.Args =>
    Future.value((args.a.toInt + args.b.toInt).toString)
  }

  handle(Increment) { args: Increment.Args =>
    Future.value(args.a + 1)
  }
}
